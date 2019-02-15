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

public class DeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		//로그인도안하고 또 접근할려는새끼들 제한
		UserVo authUser = null;
		HttpSession session = request.getSession();
		authUser =(UserVo)session.getAttribute("authuser");		
		if(authUser == null) {
			WebUtils.redirect(request, response, request.getContextPath()+ "/board?a=list");
			return;
		}
				
		String no = request.getParameter("no");
		
	   	BoardVo vo = new BoardVo();
		vo.setNo(Long.parseLong(no));
		vo.setUserNo(authUser.getNo());
			
		BoardDao dao = new BoardDao();	
		dao.delete(vo);
		
	    WebUtils.redirect(request, response, request.getContextPath()+"/board?a=list");
	}
}
