package com.reconnect.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.reconnect.factory.BlockUserServiceFactory;
import com.reconnect.model.User;
import com.reconnect.service.UserBlockServiceInterface;



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
			System.out.println("In showBlockUsers ");
			
			UserBlockServiceInterface us = BlockUserServiceFactory.createObject();
			
			//get username from session after agrima's code is merged
			HttpSession ss = request.getSession();
			String userName = ss.getAttribute("message").toString();
			
			//String userName="_sejalchoudhary"; //initialize for testing
			
			List<User> blockedUsersList = new ArrayList<User>();
			
			blockedUsersList=us.viewBlockedUsers(userName);
			
			/*
			 * List<User> blockedUsersListdemo = new ArrayList<User>() {{ add(new
			 * User("abc","Sid","Dope",new City("mah","pune","bombay"))); add(new
			 * User("ccc","AAA","Dope",new City("mah","pune","bombay"))); add(new
			 * User("ccc","AAA","Dope",new City("mah","pune","bombay"))); add(new
			 * User("ccc","AAA","Dope",new City("mah","pune","bombay"))); add(new
			 * User("ccc","AAA","Dope",new City("mah","pune","bombay"))); add(new
			 * User("ccc","AAA","Dope",new City("mah","pune","bombay"))); add(new
			 * User("ccc","AAA","Dope",new City("mah","pune","bombay"))); add(new
			 * User("ccc","AAA","Dope",new City("mah","pune","bombay"))); } };
			 */
			
			 System.out.println(blockedUsersList.size()); 
			 
			 if(blockedUsersList.size()>0) 
			{
				request.setAttribute("data", blockedUsersList);
				RequestDispatcher rd=getServletContext().getRequestDispatcher("/blockList.jsp");
				rd.forward(request, response);
			} 
			else
			{
				request.setAttribute("data", "No Blocked Users");
				RequestDispatcher rd=getServletContext().getRequestDispatcher("/blockList.jsp");
				rd.forward(request, response);
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
			//boolean b=us.unblockUser("_sejalchoudhary", "_sejalchoudhary1234");
			
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
