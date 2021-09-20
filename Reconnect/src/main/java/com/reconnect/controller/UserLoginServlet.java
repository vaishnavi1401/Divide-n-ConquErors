package com.reconnect.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.reconnect.model.UserLogin;
import com.reconnect.service.UserServiceInterface;
import com.reconnect.utility.UserServiceFactory;

public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String a = request.getParameter("ac");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");

		if (a.equals("login")) {
			String userName = request.getParameter("username");
			String password = request.getParameter("password");

			UserLogin ul = new UserLogin();
			ul.setUserName(userName);
			ul.setPassword(password);

			UserServiceInterface us = UserServiceFactory.createObject();

			int loginFlag = us.loginValidation(ul);

			if (loginFlag == 1) {
				out.println("Login Success");
			} else if (loginFlag == 0) {
				out.println("Deactivated User");
			} else {
				out.println("Wrong Credentials");
			}

		}

		out.println("</body></html>");
	}

}
