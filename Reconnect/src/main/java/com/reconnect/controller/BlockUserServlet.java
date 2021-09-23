package com.reconnect.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.reconnect.factory.BlockUserServiceFactory;
import com.reconnect.factory.UserServiceFactory;
import com.reconnect.model.User;
import com.reconnect.service.UserBlockServiceInterface;
import com.reconnect.service.UserServiceInterface;

@WebServlet("/BlockUserServlet")
public class BlockUserServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String a=request.getParameter("ac");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		
		if(a.equals("showBlockUsers"))
		{
			System.out.println("In Block Servlet ");
			
			UserBlockServiceInterface us = BlockUserServiceFactory.createObject();
			
			//get username from session after agrima's code is merged
			//HttpSession ss = request.getSession();
			//String userName = ss.getAttribute("message").toString();
			
			String userName="abc"; //initialize for testing
			
			List<User> blockedUsersList = new ArrayList<User>();
			
			blockedUsersList=us.viewBlockedUsers(userName);
			
			for(User u:blockedUsersList)
			{
				if(u!=null) 
				{
					System.out.println("username : "+u.getUsername());
					System.out.println("Fname : "+u.getFname());
					System.out.println("Lname : "+u.getLname());
					
					System.out.println("City : "+u.getCity());
					System.out.println("State : "+u.getCity().getState());
					System.out.println("Country : "+u.getCity().getCountry());
				}
				
			}
		}
		
		if(a.equals("UnBlockUser"))
		{
			//get username from session after agrima's code is merged
			//HttpSession ss = request.getSession();
			//String userName1 = ss.getAttribute("message").toString();
			
			System.out.println("In UnblockBlock");
			
			String userName1 ="abc";
			String userName2=request.getParameter("user_name");
			
			UserBlockServiceInterface us = BlockUserServiceFactory.createObject();
			boolean b=us.unblockUser(userName1, userName2);
			
			if(b)
			{
				out.println("User Unblocked");
			}
			else {
				out.println("Unblock Fail");
			}
			
		}
		
		out.println("</body></html>");
	}

}
