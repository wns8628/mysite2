package com.douzone.mysite.action.guestbook;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzone.mvc.action.Action;
import com.douzone.mysite.repository.GuestbookDao;
import com.douzone.mysite.vo.GuestbookVo;

import net.sf.json.JSONObject;

public class AjaxListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String sPage = request.getParameter("p"); //스프링은 바로 int면 int로바꿔줌 개꿀띠 
		if("".equals(sPage)) {
			sPage ="1";
		}
		if(sPage.matches("[-+]?\\d*\\.?\\d+")==false) {
			sPage ="1";	
		}

		int page = Integer.parseInt(sPage);
		GuestbookDao dao = new GuestbookDao();
		List<GuestbookVo> list = dao.getList(page);
		
		
		//map말고 이제 DTO를 쓰겠다.?
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", "success");
		map.put("data",list);
		
		//스프링에서는	잭슨이 메세지컨버터한테줌?? 쨋든알아서해줌
		response.setContentType("application/json; charset=UTF-8");//헤더한테 나가는건 json이다 라고 알려줌 
		JSONObject jsonObject = JSONObject.fromObject(map);
		response.getWriter().println(jsonObject.toString());
	}
}
