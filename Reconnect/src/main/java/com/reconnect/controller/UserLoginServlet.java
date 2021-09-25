package com.reconnect.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.reconnect.model.User;
import com.reconnect.model.UserLogin;
import com.reconnect.service.UserServiceInterface;
import com.reconnect.factory.UserServiceFactory;

@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("In Login service");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");

		//Get parameter values from Login form
		String userName = request.getParameter("user_name");
		String password = request.getParameter("user_pwd");
	
		UserLogin ul = new UserLogin();
		ul.setUserName(userName);
		ul.setPassword(password);

		UserServiceInterface us = UserServiceFactory.createObject();

		int loginFlag = us.loginValidation(ul);

		if (loginFlag == 1) 
		{
			//making username of logged in user available throughout the session
			HttpSession ss = request.getSession();
			ss.setAttribute("message", userName);
			
			request.setAttribute("message", "Login Success");

			RequestDispatcher rd=getServletContext().getRequestDispatcher("/UserPortal.jsp");
			rd.forward(request, response);
		} 
		else if (loginFlag == 0) 
		{
			request.setAttribute("status", "Deactivated User");	
			RequestDispatcher rd=getServletContext().getRequestDispatcher("/LoginPage.jsp");
			rd.forward(request, response);
		} 
		else 
		{
			request.setAttribute("status", "Wrong Credentials");
			RequestDispatcher rd=getServletContext().getRequestDispatcher("/LoginPage.jsp");
			rd.forward(request, response);
		}

		out.println("</body></html>");
	}

}
