package com.douzone.mysite.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzone.mvc.action.AbstractActionFactory;
import com.douzone.mvc.action.Action;
import com.douzone.mysite.action.main.MainActionFactory;


//@WebServlet("") //이건 기본으로 들어왔을때? 스캐닝??, / 
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String actionName = request.getParameter("a");
							
		//이까진 똑같죠? 근데 여기서 if ,else 안나누고 프레임워크~

		//프레임워크부분
		MainActionFactory af = new MainActionFactory();
		Action action = af.getAction(actionName);		
		action.execute(request,response);
	}
	

	@Override
	public void init() throws ServletException {
		String configPath = getServletConfig().getInitParameter("config");
		
		System.out.println("init called :" + configPath );
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
