package com.reconnect.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.reconnect.model.UserLogin;
import com.reconnect.service.UserServiceInterface;
import com.reconnect.utility.UserServiceFactory;

@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("In Login service");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");

		String userName = request.getParameter("user_name");
		String password = request.getParameter("user_pwd");
		
		UserLogin ul = new UserLogin();
		ul.setUserName(userName);
		ul.setPassword(password);

		UserServiceInterface us = UserServiceFactory.createObject();

		int loginFlag = us.loginValidation(ul);

		if (loginFlag == 1) 
		{
			//out.println("Login Success");
			request.setAttribute("message", "Login Success");
			RequestDispatcher rd=getServletContext().getRequestDispatcher("/LoginPage.jsp");
			rd.forward(request, response);
		} 
		else if (loginFlag == 0) 
		{
			//out.println("Deactivated User");
			request.setAttribute("message", "Deactivated User");
			RequestDispatcher rd=getServletContext().getRequestDispatcher("/LoginPage.jsp");
			rd.forward(request, response);
		} 
		else 
		{
			//out.println("Wrong Credentials");
			request.setAttribute("message", "Wrong Credentials");
			RequestDispatcher rd=getServletContext().getRequestDispatcher("/LoginPage.jsp");
			rd.forward(request, response);
		}


		out.println("</body></html>");
	}

}