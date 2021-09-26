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

//Disable A User
@WebServlet("/Disable_User")
public class AdminDisableUserServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		HttpSession sess=request.getSession();

		String[] pidarr=request.getParameterValues("username");
		Admin ad=(Admin) sess.getAttribute("admin_session");
		if(ad!=null){
			AdminService admin_service=new AdminServiceImpl();
			boolean admin_user=false;
			if(pidarr!=null)
				admin_user=admin_service.DisableUser(pidarr);
			if(admin_user)
				out.print("Disabled successfully");
			else
				out.print("Not Disabled");


			RequestDispatcher rd = request.getRequestDispatcher("statistics.html");
			rd.forward(request, response);

	}
		else
		{
			request.setAttribute("error", "Please reenter credentials");
				RequestDispatcher rd = request.getRequestDispatcher("LoginPage.jsp");
				rd.forward(request, response);
		}
	}

}
