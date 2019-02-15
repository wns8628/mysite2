package com.douzone.mvc.util;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.douzone.mysite.vo.UserVo;

public class WebUtils {
	
	public static void redirect(HttpServletRequest request, HttpServletResponse response, String url)
				throws IOException, ServletException{
		
		response.sendRedirect(url);

	} 
	
	public static void forward(HttpServletRequest request, HttpServletResponse response, String location)
				throws IOException, ServletException {
						//톰캣에서 처리하겠지 ? 
		
		RequestDispatcher rd = request.getRequestDispatcher(location);//내부에서 접근이기때문에 위치를알지 
		rd.forward(request, response);	
	}

	//로그인한사람 막기 
	
	//로그인안한사람 막기 
	
}
