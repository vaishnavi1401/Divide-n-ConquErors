package com.reconnect.controller;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class FileLocationContextListener implements ServletContextListener {


	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
    	String rootPath = "D:\\HSBC Training";
    	ServletContext ctx = servletContextEvent.getServletContext();
    	File file = new File(rootPath);
    	if(!file.exists()) file.mkdirs();
    	System.out.println("File Directory created to be used for storing files"+rootPath);
    	ctx.setAttribute("FILES_DIR_FILE", file);
    	ctx.setAttribute("FILES_DIR", rootPath);
    }

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		//do cleanup if needed
	}

}