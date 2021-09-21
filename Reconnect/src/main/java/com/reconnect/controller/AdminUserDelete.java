package com.reconnect.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.reconnect.service.AdminService;
import com.reconnect.service.AdminServiceImpl;

/**
 * Servlet implementation class AdminUserDelete
 */
public class AdminUserDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pid=Integer.parseInt(request.getParameter("pid"));
		AdminService adservice=new AdminServiceImpl();
		adservice.deleteUser(pid);
		RequestDispatcher rd=request.getRequestDispatcher("");
		rd.forward(request,response);
	}

}
