package com.douzone.mysite.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.douzone.mvc.action.Action;
import com.douzone.mvc.util.WebUtils;
import com.douzone.mysite.repository.BoardDao;
import com.douzone.mysite.vo.BoardVo;
import com.douzone.mysite.vo.UserVo;

public class ModifyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		//1. 로그인 유무
		UserVo authUser = null;
		HttpSession session = request.getSession();
		authUser =(UserVo)session.getAttribute("authuser");		
		if(authUser == null) {
			WebUtils.redirect(request, response, request.getContextPath());
			return;
		}
		
		String no = request.getParameter("no"); 
		String title = request.getParameter("title"); 
		String contents = request.getParameter("content"); 

		BoardVo vo = new BoardVo();
	    vo.setNo(Long.parseLong(no));
		vo.setTitle(title);
		vo.setContents(contents);
		vo.setUserNo(authUser.getNo()); //체크
		
		new BoardDao().update(vo);
		
		WebUtils.redirect(request, response, request.getContextPath()+"/board?a=view&no=" + no);	
		
		
	}
}
