package com.douzone.mysite.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzone.mvc.action.Action;
import com.douzone.mvc.util.WebUtils;
import com.douzone.mysite.repository.CommentDao;
import com.douzone.mysite.vo.CommentVo;

public class CommentDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
			
		String no = request.getParameter("no");
		String password = request.getParameter("password");
		String viewno = request.getParameter("viewno");
		
		  CommentVo vo = new CommentVo();
		  vo.setNo(Long.parseLong(no));
		  vo.setPassword(password);
		  new CommentDao().delete(vo);
		  
		  WebUtils.redirect(request, response , request.getContextPath()+"/board?a=view&no="+ viewno);

	}

}
