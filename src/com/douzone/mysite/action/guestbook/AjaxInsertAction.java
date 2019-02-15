package com.douzone.mysite.action.guestbook;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzone.mvc.action.Action;
import com.douzone.mysite.repository.GuestbookDao;
import com.douzone.mysite.vo.GuestbookVo;

import net.sf.json.JSONObject;

public class AjaxInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String name = request.getParameter("name");
		String message = request.getParameter("message");
		String password = request.getParameter("password");
		
		GuestbookVo vo = new GuestbookVo();
		vo.setName(name);
		vo.setMessage(message);
		vo.setPassword(password);
		
		GuestbookDao dao = new GuestbookDao();
		
		long no = dao.insert(vo);
		vo.setNo(no);
		//regdate가 필요하면 쿼리함더떄려 
		// 아니면 vo.setno해서 vo넘겨주면되지 
//		GuestbookVo newVo = dao.get(no);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", "success");
		map.put("data", vo);
		
		response.setContentType("application/json; charset=UTF-8");//헤더한테 나가는건 json이다 라고 알려줌 
		JSONObject jsonObject = JSONObject.fromObject(map);
		response.getWriter().println(jsonObject.toString());
	}

}
