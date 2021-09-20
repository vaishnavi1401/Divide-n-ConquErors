package com.reconnect.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.reconnect.model.City;
import com.reconnect.model.User;
import com.reconnect.model.UserLogin;
import com.reconnect.service.UserServiceInterface;
import com.reconnect.utility.UserServiceFactory;

public class UserServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String a = request.getParameter("ac");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");

		if (a.equals("userRegister")) {
			// 13
			String firstname = request.getParameter("firstname");
			String lastname = request.getParameter("lastname");
			String gender = request.getParameter("gender");
			String birthday = (request.getParameter("birthday"));
			String address = request.getParameter("address");
			String city = request.getParameter("city");
			String state = request.getParameter("state");
			String country = request.getParameter("country");
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");
			String username = request.getParameter("username");
			String confirmPassword = request.getParameter("confirm-password");
			String company = request.getParameter("company");
			String image=request.getParameter("image");
			File picture =new File(image);

			User usr = new User();

			usr.setFname(firstname);
			usr.setLname(lastname);
			usr.setGender(gender);
			Date dob = null;
			try {
				dob = (Date) new SimpleDateFormat("YYYY-MM-DD").parse(birthday);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			usr.setDob(dob);
			usr.setAddress(address);
			usr.setEmail(email);
			usr.setPhone(phone);
			usr.setCompany(company);
			usr.setProfileImage(picture);

			City c = new City();
			c.setCity(city);
			c.setCountry(country);
			c.setState(state);

			UserLogin ul = new UserLogin();
			ul.setUserName(username);
			ul.setPassword(confirmPassword);

			UserServiceInterface us = UserServiceFactory.createObject();

			int city_id = us.registerUserCity(c);
			int cred_id = us.registerUserCred(ul);
			boolean emailCheck = us.checkEmailUnique(email);
			boolean regFlag = us.registerUserDetail(usr, city_id, cred_id);

			if (emailCheck && regFlag) {
				out.println("Registration Success");
			}
		}
		out.println("</body></html>");

	}

}
