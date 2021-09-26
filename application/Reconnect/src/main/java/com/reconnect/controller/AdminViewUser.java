package com.reconnect.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.reconnect.model.Admin;
import com.reconnect.service.AdminService;
import com.reconnect.service.AdminServiceImpl;

//View All Users
@WebServlet("/Admin_user_details")
public class AdminViewUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		HttpSession sess = request.getSession();
		Admin ad = (Admin) sess.getAttribute("admin_session");
		if (ad != null) {
			AdminService admin_service = new AdminServiceImpl();
			Map<String, String> m = admin_service.viewAllUserInfo();
			System.out.println(new Gson().toJson(m));
			out.print(new Gson().toJson(m));
		} else {
			request.setAttribute("error", "Please renter credentials");
			RequestDispatcher rd = request.getRequestDispatcher("LoginPage.jsp");
			rd.forward(request, response);
		}

	}

}
