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

public class AjaxDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		  String no = request.getParameter("no");
		  String password = request.getParameter("password");

		  System.out.println(no);
		  System.out.println(password);
		  
		  GuestbookVo vo = new GuestbookVo();
		  vo.setNo(Long.parseLong(no));
		  vo.setPassword(password);
		  
		  int result = new GuestbookDao().delete(vo);
		  
		  if(result == -1) {
			  no = "-1";
		  } 
		  System.out.println(no);
			  
		  Map<String, Object> map = new HashMap<String, Object>();
	  	  map.put("result", "success");
		  map.put("data", result);	
		  
		  response.setContentType("application/json; charset=UTF-8");//헤더한테 나가는건 json이다 라고 알려줌 
		  JSONObject jsonObject = JSONObject.fromObject(map);
		  response.getWriter().println(jsonObject.toString());
	}
}
