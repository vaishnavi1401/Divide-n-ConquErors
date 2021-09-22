package com.reconnect.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.reconnect.factory.BlockUserServiceFactory;
import com.reconnect.factory.UserServiceFactory;
import com.reconnect.model.User;
import com.reconnect.service.UserBlockServiceInterface;
import com.reconnect.service.UserServiceInterface;

public class BlockUserServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		
		UserBlockServiceInterface us = BlockUserServiceFactory.createObject();
		
		HttpSession ss = request.getSession();
		String userName = ss.getAttribute("message").toString();
		
		List<User> blockedUsersList = new ArrayList<User>();
		
		blockedUsersList=us.viewBlockedUsers(userName);
	}

}
