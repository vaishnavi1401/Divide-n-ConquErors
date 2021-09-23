package com.reconnect.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.reconnect.factory.UserServiceFactory;
import com.reconnect.model.User;
import com.reconnect.model.UserLogin;
import com.reconnect.service.UserServiceInterface;

/**
 * Servlet implementation class FriendServlet
 */
public class FriendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String a;
		a = "sendRequest";
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println(a);
		
		
		
		if(a.equals("sendRequest")) {
			out.println("In!");
			
			String username=request.getParameter("username");
			String friend=request.getParameter("friend");
			//declaring statically for testing purpose
			username="bharshita";
			friend="harsh";
			//---
			UserLogin friend1=new UserLogin();
			UserLogin friend2=new UserLogin();
			friend1.setUserName(username);
			friend2.setUserName(friend);
			UserServiceInterface us = UserServiceFactory.createObject();
			out.println("Request Sent!");
			int status = us.addFriendRequest(friend1,friend2);
			out.println(status+" status");
			
			
		}
		
		
		
		if(a.equals("acceptFriendRequest")) {
			out.println("In!");

			String username=request.getParameter("username");
			String friend=request.getParameter("friend");
			//declaring statically for testing purpose
			username="harsh";
			friend="bharshita";
			//---
			
			UserLogin friend1=new UserLogin();
			UserLogin friend2=new UserLogin();
			
			friend1.setUserName(username); 
			friend2.setUserName(friend); 
			UserServiceInterface us = UserServiceFactory.createObject();
			out.println("Request Sent Accept request!");
			int status = us.acceptFriendRequest(friend1,friend2);
			out.println("Request Response received! "+status);
			
			
		}
		
		if(a.equals("removeFriend")) {
			out.println("In remove friend!");
			
			String username=request.getParameter("username");
			String friend=request.getParameter("friend");
			//declaring statically for testing purpose
			username="bharshita";
			friend="harsh";
			//---

			UserLogin friend1=new UserLogin();
			UserLogin friend2=new UserLogin();
			
			friend1.setUserName(username); //take from sessionid
			friend2.setUserName(friend); //accepting request sent by this user
			UserServiceInterface us = UserServiceFactory.createObject();
			out.println("Request Sent Remove Friend request!");
			int status = us.removeFriend(friend1,friend2);
			out.println("Request Response received! "+status);
			
			
		}
		
		if(a.equals("ignoreRequest")) {
			out.println("In!");
			
			String username=request.getParameter("username");
			String friend=request.getParameter("friend");
			//declaring statically for testing purpose
			username="harsh";
			friend="bharshita";
			//---

			UserLogin friend1=new UserLogin();
			UserLogin friend2=new UserLogin();
			
			friend1.setUserName(username); //take from sessionid
			friend2.setUserName(friend); //accepting request sent by this user
			UserServiceInterface us = UserServiceFactory.createObject();
			out.println("Request Sent ignore request!");
			int status = us.ignoreRequest(friend1,friend2);
			out.println("Request Response received! "+status);
			
			
		}
		
		if(a.equals("viewPendingRequest")) {
			out.println("In viewPending req!");
			
			String username=request.getParameter("username");
			
			//declaring statically for testing purpose
			username="harsh";
			//---

			UserLogin self=new UserLogin();
			self.setUserName(username); //take from sessionid
			
			UserServiceInterface us = UserServiceFactory.createObject();
			
			List<User> pendingReq = us.getPendingRequest(self);
			out.println("Request Response received! "+pendingReq.get(0).getFname());
			
			
		}
		
		if(a.equals("viewFriends")) {
			out.println("In view Friends !");
			
			String username=request.getParameter("username");
			
			//declaring statically for testing purpose
			username="harsh";
			//---

			UserLogin self=new UserLogin();
			self.setUserName(username); //take from sessionid
			
			UserServiceInterface us = UserServiceFactory.createObject();
			
			List<User> friendsList = us.getFriends(self);
			if(friendsList.size()>0)
			{
			out.println("Request Response received! "+friendsList.get(0).getFname());
			}
			else
			{
				out.println("You dont have any friends!");
			}
			
			
		}
		


	}

}
