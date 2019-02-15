package com.douzone.mysite.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.douzone.mvc.action.Action;
import com.douzone.mvc.util.WebUtils;
import com.douzone.mysite.vo.UserVo;

public class JoinFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		//로그인한사람은 들어오면안됨
		UserVo authUser = null;
		HttpSession session = request.getSession();
		authUser =(UserVo)session.getAttribute("authuser");
		if(authUser != null) {
			WebUtils.redirect(request, response, request.getContextPath());
			return;
		}
		
			WebUtils.forward(request, response, "/WEB-INF/views/user/joinform.jsp");
	}

}
