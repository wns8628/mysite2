package com.douzone.mysite.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.douzone.mvc.action.Action;
import com.douzone.mvc.util.WebUtils;
import com.douzone.mysite.repository.UserDao;
import com.douzone.mysite.vo.UserVo;

public class LoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		//로그인한사람은 들어오면안됨
		UserVo authUser = null;
		HttpSession session = request.getSession();
		authUser = (UserVo)session.getAttribute("authuser");
		if(authUser != null) {
			WebUtils.redirect(request, response, request.getContextPath());
			return;
		}
		
		String email = request.getParameter("email");
		String password =request.getParameter("password");
		
		authUser = new UserDao().get(email, password); //귀찮 vo만들기 그래서걍함 
		
		if(authUser==null){
			//인증실패			
			request.setAttribute("result", "fail");
			WebUtils.forward(request, response, "/WEB-INF/views/user/loginform.jsp");
		
			return; //제어권은 넘어갔지만 코드는 밑에계속실행되니 return해줘야함 
		}
		
		
		// 인증성공 -> 인증처리 
		session = request.getSession(true); //true면 없으면 만들어달라
		session.setAttribute("authuser", authUser); //세션에 등록

		// main redirect
		WebUtils.redirect(request, response, request.getContextPath());
	}

}
