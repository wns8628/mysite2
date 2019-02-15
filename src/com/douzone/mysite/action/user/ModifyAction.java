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

public class ModifyAction implements Action {

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
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		
		UserVo vo = new UserVo();
		vo.setNo(authUser.getNo());
		vo.setName(name);
		vo.setPassword(password);
		vo.setGender(gender);
		new UserDao().update(vo);

		
		authUser.setName(name);		
		session.setAttribute("authuser", authUser); 
	
		WebUtils.redirect(request, response, request.getContextPath()+"/user");
	}
}
