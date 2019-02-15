package com.douzone.mysite.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.douzone.mvc.action.Action;
import com.douzone.mvc.util.WebUtils;
import com.douzone.mysite.vo.UserVo;

public class LogoutAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		//로그인도안한사람 접근제한
		UserVo authUser = null;
		HttpSession session = request.getSession(false);
		authUser = (UserVo)session.getAttribute("authuser");
		if(authUser == null) {
			WebUtils.redirect(request, response, request.getContextPath());
			return;
		}
				
		//로그아웃 처리 
		session.removeAttribute("authuser"); //지워라
		session.invalidate(); //

		WebUtils.redirect(request, response, request.getContextPath());	 //로그아웃되면 메인페이지로
	}

}
