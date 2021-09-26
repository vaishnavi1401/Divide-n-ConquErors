package com.reconnect.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.reconnect.factory.UserServiceFactory;
import com.reconnect.model.City;
import com.reconnect.model.User;
import com.reconnect.model.UserLogin;
import com.reconnect.service.UserServiceInterface;
import com.reconnect.utility.CommonUtils;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {

	private ServletFileUpload uploader = null;

	@Override
	public void init() throws ServletException{
		DiskFileItemFactory fileFactory = new DiskFileItemFactory();
		File filesDir = (File) getServletContext().getAttribute("FILES_DIR_FILE");
		int minSizeOfFiles = 1; // In Bytes
		fileFactory.setSizeThreshold(minSizeOfFiles);
		fileFactory.setRepository(filesDir);
		this.uploader = new ServletFileUpload(fileFactory);
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		List<FileItem> userDetails = null;
		try {
			//getting registration details from register form
			userDetails = uploader.parseRequest(request);
			System.out.println(userDetails);
			String firstname = CommonUtils.getFieldValue(userDetails, "firstname");
			String lastname = CommonUtils.getFieldValue(userDetails,"lastname");
			String gender = CommonUtils.getFieldValue(userDetails,"gender");
			String birthday = CommonUtils.getFieldValue(userDetails,"birthday");
			String address = CommonUtils.getFieldValue(userDetails,"address");
			String city = CommonUtils.getFieldValue(userDetails,"city");
			String state = CommonUtils.getFieldValue(userDetails,"state");
			String country = CommonUtils.getFieldValue(userDetails,"country");
			String phone = CommonUtils.getFieldValue(userDetails,"phone");
			String email = CommonUtils.getFieldValue(userDetails,"email");
			String username = CommonUtils.getFieldValue(userDetails,"username");
			String confirmPassword = CommonUtils.getFieldValue(userDetails,"confirm-password");
			String company = CommonUtils.getFieldValue(userDetails,"company");

			FileItem image = CommonUtils.getImage(userDetails);
			//System.out.println(image);

			UserServiceInterface us = UserServiceFactory.createObject();
			int userId = us.getUserId(username);
			String documentPath = request.getServletContext().getAttribute("FILES_DIR").toString() + File.separator + username;
			File file=new File(documentPath);
			if(!file.exists())
				file.mkdirs();

			System.out.println(documentPath);
			String imagePath = documentPath+File.separator+image.getName();
			System.out.println(imagePath);
			File picture = new File(imagePath);
			image.write(picture);

			User usr = new User();
			usr.setProfileImagePath(imagePath);
			usr.setFname(firstname);
			usr.setLname(lastname);
			usr.setGender(gender);
			usr.setDob(Date.valueOf(birthday));
			usr.setAddress(address);
			usr.setEmail(email);
			usr.setPhone(phone);
			usr.setCompany(company);
			City c = new City();
			c.setCity(city);
			c.setCountry(country);
			c.setState(state);

			UserLogin ul = new UserLogin();
			ul.setUserName(username);
			ul.setPassword(confirmPassword);


			int city_id = us.registerUserCity(c);
			int cred_id = us.registerUserCred(ul);
			System.out.println(city_id);
			System.out.println(cred_id);
			boolean emailCheck = us.checkEmailUnique(email);
			boolean usernameUniqCheck = us.checkUsernameUniq(username);

			//if email and username is choosen unique then only registration is successfull
			if (emailCheck && usernameUniqCheck) {
				if(us.registerUserDetail(usr, city_id, cred_id)) {

					//out.println("Registration Success");
					request.setAttribute("message", "Profile Created <a href=LoginPage.jsp>Sign In</a>");
					RequestDispatcher rd=getServletContext().getRequestDispatcher("/RegistrationPage.jsp");
					rd.forward(request, response);
				}
			}
			else
			{
				request.setAttribute("message", "<font color=red>Registration Failed</font>");
				RequestDispatcher rd=getServletContext().getRequestDispatcher("/RegistrationPage.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		out.println("</body></html>");
	}
}

