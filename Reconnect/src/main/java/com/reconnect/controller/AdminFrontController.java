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

//servlet for admin main page 
@WebServlet("/Admin_front_page")
public class AdminFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		HttpSession sess=request.getSession();
		Admin ad=(Admin) sess.getAttribute("user");
		if(ad!=null){
			String uname=request.getParameter("username");
			AdminService admin_service=new AdminServiceImpl();
			ad=admin_service.getAdminDetails();
			request.setAttribute("ad", ad);
			RequestDispatcher rd = request.getRequestDispatcher("statistics.html");
			rd.forward(request, response);
	}
		else
		{
			out.println("<h4>pls re enter credentials</h4>");
			RequestDispatcher rd=request.getRequestDispatcher("LoginForm.html");
			rd.include(request,response);
		}

}
}
