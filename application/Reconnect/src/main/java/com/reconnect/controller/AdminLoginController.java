package com.reconnect.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.reconnect.model.Admin;
import com.reconnect.service.AdminService;
import com.reconnect.service.AdminServiceImpl;

//Servlet For Admin Login
@WebServlet("/validate")
public class AdminLoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	//servlet to connect login button and validate admin
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String nm = request.getParameter("admin_username");
		String pass = request.getParameter("admin_pwd");
		AdminService uservice = new AdminServiceImpl();
		System.out.println(nm+" "+pass);
		// validate admin username and passward
		Admin u = uservice.adminLogin(nm, pass);
		System.out.println("ADMIN IN CONTROLLER"+u);
		// creating session
		if (u != null)
		{
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(20);
			if (session.isNew()) {
				System.out.print("new session");

			}
			else {
				session.invalidate();
				session = request.getSession(true);

			}
			session.setAttribute("admin_session", u);
			u=uservice.getAdminDetails();
			request.setAttribute("ad", u);
			RequestDispatcher rd = request.getRequestDispatcher("AdminPortal.jsp");
			rd.forward(request, response);
		}
		else {

			request.setAttribute("message", "Please re-enter credentials");
	    //    request.getRequestDispatcher("yourjsppage").forward(request,response);
			RequestDispatcher rd = request.getRequestDispatcher("LoginPage.jsp");
			rd.forward(request, response);
		}
}
}
