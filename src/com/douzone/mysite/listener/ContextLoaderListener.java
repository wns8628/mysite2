package com.douzone.mysite.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class ContextLoaderListener implements ServletContextListener {

    public ContextLoaderListener() {
    	System.out.println("Container Starts...");
    }

    public void contextDestroyed(ServletContextEvent arg0)  { 
    
    }


    public void contextInitialized(ServletContextEvent servletContextEvent)  { 
    	//webxml 어플리케이션 전역 파라미터 가져오기  
    	String contextConfigLocation =	servletContextEvent.getServletContext().getInitParameter("contextConfigLocation");

    	System.out.println(contextConfigLocation);
    }
	
}
