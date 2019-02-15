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

public class CommentReplyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String viewno = request.getParameter("viewno"); 
		String gNo = request.getParameter("gNo"); 
		String oNo = request.getParameter("oNo"); 
		String depth = request.getParameter("depth"); 
		String name = request.getParameter("name"); 
		String password = request.getParameter("password"); 
		String contents = request.getParameter("contents"); 
		
		CommentVo vo = new CommentVo();
		vo.setBoardNo(Long.parseLong(viewno));
		vo.setgNo(Integer.parseInt(gNo));
		vo.setoNo(Integer.parseInt(oNo));
		vo.setDepth(Integer.parseInt(depth));
		vo.setName(name);
		vo.setPassword(password);
		vo.setContents(contents);
		
		//로그인 한 사람이면
		UserVo authUser = null;
		HttpSession session = request.getSession();
		authUser =(UserVo)session.getAttribute("authuser");		
		if(authUser != null) {
			vo.setUserNo(authUser.getNo());
			vo.setName(authUser.getName());
			UserVo uservo = new UserDao().get(authUser.getNo());  
			password = uservo.getPassword();				
			vo.setPassword(password);
		}
		
		new CommentDao().reply(vo);
				
		WebUtils.redirect(request, response, request.getContextPath()+"/board?a=view&no="+ viewno);		
		
	}

}
