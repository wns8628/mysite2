package com.douzone.mysite.action.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzone.mvc.action.AbstractActionFactory;
import com.douzone.mvc.action.Action;

public class MainActionFactory extends AbstractActionFactory {

	@Override
	public Action getAction(String actionName){
		
		return new IndexAction();
	}

}
