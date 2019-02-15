package com.douzone.mysite.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzone.mvc.action.Action;
import com.douzone.mvc.util.WebUtils;
import com.douzone.mysite.repository.CommentDao;
import com.douzone.mysite.vo.CommentVo;

public class CommentReplyFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String no = request.getParameter("no");
		
		CommentVo vo = new CommentVo();
		vo.setNo(Long.parseLong(no));
		CommentDao dao = new CommentDao();
		vo = dao.get(vo); 
		
		request.setAttribute("vo", vo);
		WebUtils.forward(request, response, "/WEB-INF/views/board/commentreplyform.jsp");
		
	}
}
