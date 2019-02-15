package com.douzone.mysite.controller.api;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzone.mvc.action.AbstractActionFactory;
import com.douzone.mvc.action.Action;
import com.douzone.mysite.action.guestbook.GuestBookActionFactory;

//똑같은거왜 두개쳐만듬? 웹과 json응답 api는 분리하는게좋음?
@WebServlet(name = "APIGuestbookServlet", urlPatterns = { "/api/guestbook" })
public class GuestbookServlet extends HttpServlet {

	
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String actionName = request.getParameter("a");
			
			//프레임워크부분
			AbstractActionFactory af = new GuestBookActionFactory();
			Action action = af.getAction(actionName);		
			action.execute(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
