package com.reconnect.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.reconnect.factory.UserServiceFactory;
import com.reconnect.model.User;
import com.reconnect.model.UserLogin;
import com.reconnect.service.UserServiceInterface;

/**
 * Servlet implementation class FriendServlet
 */
@WebServlet("/FriendServlet")
public class FriendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String a;
		a = request.getParameter("ac");
		System.out.println("********" + a);

		/* response.setContentType("text/html"); */
		PrintWriter out = response.getWriter();
		/*
		 * out.println("<html><body>"); out.println(a);
		 */

		String username = request.getParameter("username");
		String friend = request.getParameter("friend");

		System.out.println(username);
		System.out.println(friend);

		if (a.equals("sendRequest")) {

			response.setContentType("text/html");

			UserLogin friend1 = new UserLogin();
			UserLogin friend2 = new UserLogin();

			friend1.setUserName(username);
			friend2.setUserName(friend);

			UserServiceInterface us = UserServiceFactory.createObject();

			int status = us.addFriendRequest(friend1, friend2);
			out.println(status);

		}

		if (a.equals("acceptFriendRequest")) {

			response.setContentType("text/html");

			UserLogin friend1 = new UserLogin();
			UserLogin friend2 = new UserLogin();

			friend1.setUserName(username);
			friend2.setUserName(friend);
			UserServiceInterface us = UserServiceFactory.createObject();

			int status = us.acceptFriendRequest(friend1, friend2);
			System.out.println("helloooooo"+username+friend+status);
			out.println(status);

		}

		if (a.equals("removeFriend")) {
			response.setContentType("text/html");


			UserLogin friend1 = new UserLogin();
			UserLogin friend2 = new UserLogin();

			friend1.setUserName(username); // take from sessionid
			friend2.setUserName(friend); // accepting request sent by this user
			UserServiceInterface us = UserServiceFactory.createObject();

			int status = us.removeFriend(friend1, friend2);
			out.println( status);

		}

		if (a.equals("ignoreRequest")) {
			response.setContentType("text/html");
			out.println("In!");

			UserLogin friend1 = new UserLogin();
			UserLogin friend2 = new UserLogin();

			friend1.setUserName(username); // take from sessionid
			friend2.setUserName(friend); // accepting request sent by this user
			UserServiceInterface us = UserServiceFactory.createObject();

			int status = us.ignoreRequest(friend1, friend2);
			out.println(status);

		}

		if (a.equals("viewPendingRequest")) {
			response.setContentType("application/json");

			UserLogin self = new UserLogin();
			self.setUserName(username); // take from sessionid

			UserServiceInterface us = UserServiceFactory.createObject();

			List<User> pendingReq = us.getPendingRequest(self);
			//String t = pendingReq.get(0).getUsername();
			JSONObject obj = new JSONObject();
			obj.put("PendingReqList", pendingReq);

			System.out.println(pendingReq);
			out.print(obj);

		}

		if (a.equals("viewFriends")) {

			response.setContentType("application/json");
			UserLogin self = new UserLogin();
			self.setUserName(username); // take from sessionid

			UserServiceInterface us = UserServiceFactory.createObject();

			List<User> friendsList = us.getFriends(self);

			JSONObject obj = new JSONObject();
			obj.put("FriendsList", friendsList);

			System.out.println(friendsList);
			out.print(obj);

		}

		if (a.equals("nonFriends")) {
			response.setContentType("application/json");
			UserLogin self = new UserLogin();
			self.setUserName(username); // take from sessionid

			UserServiceInterface us = UserServiceFactory.createObject();

			List<User> nonfriendsList = us.getNonFriendsList(username);

			JSONObject obj = new JSONObject();
			obj.put("NonFriendsList", nonfriendsList);

			System.out.println(nonfriendsList);
			out.print(obj);

		}

	}

}
