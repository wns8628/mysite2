package com.douzone.mysite.controller.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzone.mysite.vo.UserVo;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class AjaxServlet3
 */
@WebServlet("/ajax3")
public class AjaxServlet3 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//
		List<UserVo> list = new ArrayList<UserVo>();
		
		// java object -> json String 으로 바꾸기
		UserVo vo = new UserVo();
		vo.setNo(10);
		vo.setName("둘리");
		vo.setEmail("wns8628@naver.com");
		vo.setGender("male");
		list.add(vo);
		
		UserVo vo2 = new UserVo();
		vo2.setNo(10);
		vo2.setName("둘리");
		vo2.setEmail("wns8628@naver.com");
		vo2.setGender("male");
		list.add(vo2);
		
		JSONArray jsonarray = JSONArray.fromObject(list);
		String jsonString = jsonarray.toString();
		
		response.setContentType("application/json; charset=utf-8");
		PrintWriter pw = response.getWriter();
		pw.println(jsonString);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
