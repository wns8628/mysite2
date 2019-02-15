package com.douzone.mysite.action.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.douzone.mvc.action.Action;
import com.douzone.mvc.util.WebUtils;
import com.douzone.mysite.repository.BoardDao;
import com.douzone.mysite.repository.CommentDao;
import com.douzone.mysite.vo.BoardVo;
import com.douzone.mysite.vo.CommentVo;
import com.douzone.mysite.vo.UserVo;

public class ViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String no = request.getParameter("no"); //보여줄 게시물보고
		
		BoardVo vo = new BoardVo();
	    vo.setNo(Long.parseLong(no));
			
		BoardDao dao = new BoardDao();	
		vo = dao.getView(vo);
	    
		CommentVo commentVo = new CommentVo();
		commentVo.setBoardNo(Long.parseLong(no));
		CommentDao commentDao = new CommentDao();
		List<CommentVo> commentlist = commentDao.getList(commentVo);
		
		
		request.setAttribute("view", vo);
		request.setAttribute("commentlist", commentlist);
	
		WebUtils.forward(request, response, "WEB-INF/views/board/view.jsp");
	}

}
