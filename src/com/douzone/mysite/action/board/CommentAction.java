package com.douzone.mysite.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.douzone.mvc.action.Action;
import com.douzone.mvc.util.WebUtils;
import com.douzone.mysite.repository.CommentDao;
import com.douzone.mysite.repository.UserDao;
import com.douzone.mysite.vo.CommentVo;
import com.douzone.mysite.vo.UserVo;

public class CommentAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		UserVo authUser = null;
		HttpSession session = request.getSession();
		authUser =(UserVo)session.getAttribute("authuser");	

		String viewno = request.getParameter("no");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String contents = request.getParameter("contents");
		String kwd = request.getParameter("kwd");
		

		if(authUser != null) {
			 name =  authUser.getName();			
			UserVo vo = new UserDao().get(authUser.getNo());  
			password = vo.getPassword();		
		}
		
				
		CommentVo vo =new CommentVo();
		vo.setBoardNo(Long.parseLong(viewno));
		vo.setName(name);
		vo.setPassword(password);
		vo.setContents(contents);
	
		if(authUser != null) {
			vo.setUserNo(authUser.getNo());
		}
		
		new CommentDao().insert(vo);
		
		WebUtils.redirect(request, response, request.getContextPath()+"/board?a=view&no=" + viewno+ "&kwd=" + kwd);	
		
	}

}
