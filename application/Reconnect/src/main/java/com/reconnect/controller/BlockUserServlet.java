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

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String a=request.getParameter("ac");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");

		if(a.equals("showBlockUsers"))
		{

			UserBlockServiceInterface us = BlockUserServiceFactory.createObject();

			//get username from session

			HttpSession ss = request.getSession();
			String userName1 = ss.getAttribute("message").toString(); //String userName1="_sejalchoudhary"; //initialize for testing

			List<User> blockedUsersList = new ArrayList<>();

			//get all blocked users blocked by user who is logged in
			blockedUsersList=us.viewBlockedUsers(userName1);


			for(User u:blockedUsersList)
			{
				if(u!=null)
				{
					System.out.println("username : "+u.getUsername());
					System.out.println("Fname : "+u.getFname());
					System.out.println("Lname : "+u.getLname());

					System.out.println("City : "+u.getCity().getCity());
					System.out.println("State : "+u.getCity().getState());
					System.out.println("Country : "+u.getCity().getCountry());
				}

			}

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
			System.out.println("In UnblockBlock");

			//get username from session
			HttpSession ss = request.getSession();
			String userName1 = ss.getAttribute("message").toString();

			String userName2=request.getParameter("user_name");

			UserBlockServiceInterface us = BlockUserServiceFactory.createObject();

			boolean b1=us.unblockUser(userName1, userName2); //boolean b=us.unblockUser("_sejalchoudhary", "_sejalchoudhary1234");

			if(b1)
			{
				RequestDispatcher rd=getServletContext().getRequestDispatcher("/blockList.jsp");
				rd.forward(request, response);
			}
			else {
				RequestDispatcher rd=getServletContext().getRequestDispatcher("/blockList.jsp");
				rd.forward(request, response);
			}

		}

		out.println("</body></html>");
	}

}