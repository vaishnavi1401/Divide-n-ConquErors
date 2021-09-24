package com.reconnect.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.reconnect.factory.UserServiceFactory;
import com.reconnect.model.User;
import com.reconnect.service.UserServiceInterface;

public class DisplayUserDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession ss = request.getSession();
		String userName = ss.getAttribute("message").toString();
		
		UserServiceInterface usi = UserServiceFactory.createObject();
		User userObj=new User();
		userObj=usi.getUserDetailsByUsername(userName);
		
		//userObj=new User("Tom", "Cruise", "tom@gmail",new City("pune","maharashtra","india"));
		
		System.out.println("Fname"+userObj.getFname());
		System.out.println("Lname"+userObj.getLname());
	
		request.setAttribute("mydata", userObj);
		RequestDispatcher rd=getServletContext().getRequestDispatcher("/UserPortal.jsp");
		rd.forward(request, response);
	}

}
