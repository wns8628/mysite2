package com.douzone.mysite.action.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzone.mvc.action.Action;
import com.douzone.mvc.util.WebUtils;
import com.douzone.mysite.repository.BoardDao;
import com.douzone.mysite.repository.PaginationDao;
import com.douzone.mysite.repository.PaginationDao;
import com.douzone.mysite.repository.PaginationDao;
import com.douzone.mysite.vo.BoardVo;
import com.douzone.mysite.vo.PaginationVo;

public class ListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


		
//------------------------------------------------------------------전체검색위해		
		String kwd = request.getParameter("kwd");
		//그냥 리스트보기
		if(kwd == null ) {
			kwd= "";
		}
		kwd = kwd.replaceAll(" ", ""); //공백제거 스페이스검색ㄴㄴ
//-----------------------------------------------------------------		
				
//-----------------------------------------------------------------페이지네이션위해		

		int pageNo = 0;	    
		int manyboard = 5; //몇개당 한페이지할건지
		int limitcount = 5; //게시글이 10000개라도 한페이지당 10개의 페이지네이션이나오게

		//url null체크
		pageNo =  request.getParameter("pageNo") == null ? 1 : Integer.parseInt(request.getParameter("pageNo"));	
		
		PaginationDao pagedao = new PaginationDao();				
		int totalpage = pagedao.getmaxpage( kwd ,manyboard );

		//url page 최대 최소 체크
		if(pageNo < 1 ) {
			pageNo = 1;
		} else if( pageNo > totalpage ){
			pageNo = totalpage;
		}
		
		PaginationVo vo = pagedao.getPageinfomation(kwd ,pageNo , manyboard , limitcount); //페이지를위한정보 다가져와			
		request.setAttribute("page", vo);
		
//-----------------------------------------------------------------	
		
		BoardDao dao = new BoardDao();
		List<BoardVo> list = dao.getList(kwd , vo.getStartboard(), vo.getManyboard());			
		request.setAttribute("list", list);		
		WebUtils.forward(request, response, "WEB-INF/views/board/list.jsp");
	}
}
