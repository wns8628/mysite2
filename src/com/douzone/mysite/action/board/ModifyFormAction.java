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

public class ModifyFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		//로그인도안하고  제한
		UserVo authUser = null;
		HttpSession session = request.getSession();
		authUser =(UserVo)session.getAttribute("authuser");		
		if(authUser == null) {
			WebUtils.redirect(request, response, request.getContextPath()+"/board");
			return;
		}
		String no = request.getParameter("no"); //번호가져오고

		BoardVo vo = new BoardVo();
	    vo.setNo(Long.parseLong(no));			
		BoardDao dao = new BoardDao();	
		BoardVo view = dao.getView(vo);
		
		if(view.getUserNo() == authUser.getNo()) {	
			request.setAttribute("view", view);
			WebUtils.forward(request, response, "/WEB-INF/views/board/modify.jsp");
		}else { //글 작성자가 아니면
			WebUtils.redirect(request, response, request.getContextPath());	 
		}
		
	}

}
