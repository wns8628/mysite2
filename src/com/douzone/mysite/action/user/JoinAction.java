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

public class JoinAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		//로그인한사람은 들어오면안됨
		UserVo authUser = null;
		HttpSession session = request.getSession();
		authUser =(UserVo)session.getAttribute("authuser");
		if(authUser != null) {
			WebUtils.redirect(request, response, request.getContextPath());
			return;
		}
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");

		UserVo vo = new UserVo();
		vo.setName(name);
		vo.setEmail(email);
		vo.setPassword(password);
		vo.setGender(gender);
		
		new UserDao().insert(vo);
		

		WebUtils.redirect(request, response, request.getContextPath()+"/user?a=joinsuccess");
	}

}
