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

public class ReplyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		//로그인도안함 제한
		UserVo authUser = null;
		HttpSession session = request.getSession();
		authUser =(UserVo)session.getAttribute("authuser");		
		if(authUser == null) {
			WebUtils.redirect(request, response, request.getContextPath());
			return;
		}
		
		String gNo = request.getParameter("g_no"); 
		String oNo = request.getParameter("o_no"); 
		String depth = request.getParameter("depth"); 
		String title = request.getParameter("title"); 
		String contents = request.getParameter("content"); 
		long userNo = authUser.getNo();
		
		BoardVo vo = new BoardVo();
		vo.setgNo(Integer.parseInt(gNo));
		vo.setoNo(Integer.parseInt(oNo));
		vo.setDepth(Integer.parseInt(depth));
		vo.setTitle(title);
		vo.setContents(contents);
		vo.setUserNo(userNo);
		
		new BoardDao().reply(vo);
		
		WebUtils.redirect(request, response, request.getContextPath()+"/board?a=list");		
		
	}

}
