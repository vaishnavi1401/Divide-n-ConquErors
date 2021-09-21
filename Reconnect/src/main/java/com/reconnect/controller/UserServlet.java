package com.reconnect.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.reconnect.model.City;
import com.reconnect.model.User;
import com.reconnect.model.UserLogin;
import com.reconnect.service.UserServiceInterface;
import com.reconnect.utility.UserServiceFactory;
import com.reconnect.utility.CommonUtils;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	
	private ServletFileUpload uploader = null;
	
	public void init() throws ServletException{
		DiskFileItemFactory fileFactory = new DiskFileItemFactory();
		File filesDir = (File) getServletContext().getAttribute("FILES_DIR_FILE");
		int minSizeOfFiles = 1; // In Bytes
		fileFactory.setSizeThreshold(minSizeOfFiles);
		fileFactory.setRepository(filesDir);
		this.uploader = new ServletFileUpload(fileFactory);
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String city = null, state = null, country = null, username = null, confirmPassword = null, email = null;
		String firstname = null;
		String lastname = null;
		String gender = null;
		String birthday = null;
		String address = null;
		String phone = null;
		String company = null;
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");

		User usr = new User();
		List<FileItem> userDetails = null;
		try {
			userDetails = uploader.parseRequest(request);
			System.out.println(userDetails);
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(FileItem item: userDetails) {
			if(item.isFormField()) {
				firstname = CommonUtils.getFieldValue(userDetails, "firstname");
				lastname = CommonUtils.getFieldValue(userDetails,"lastname");
				gender = CommonUtils.getFieldValue(userDetails,"gender");
				birthday = CommonUtils.getFieldValue(userDetails,"birthday");
				address = CommonUtils.getFieldValue(userDetails,"address");
				city = CommonUtils.getFieldValue(userDetails,"city");
				state = CommonUtils.getFieldValue(userDetails,"state");
				country = CommonUtils.getFieldValue(userDetails,"country");
				phone = CommonUtils.getFieldValue(userDetails,"phone");
				email = CommonUtils.getFieldValue(userDetails,"email");
				username = CommonUtils.getFieldValue(userDetails,"username");
				confirmPassword = CommonUtils.getFieldValue(userDetails,"confirm-password");
				company = CommonUtils.getFieldValue(userDetails,"company");	
			}
			if(!item.isFormField() && item.getSize()!=0){
				//System.out.println(item);
				String documentPath = request.getServletContext().getAttribute("FILES_DIR").toString() + File.separator + username;
				File file=new File(documentPath);
				if(!file.exists()) 
					file.mkdirs();
				File image = new File(documentPath+File.separator+item.getName());
				try {
					item.write(image);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//System.out.println("File location on server::"+image.getAbsolutePath());
				usr.setProfileImage(image);
			}
		}
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
			UserServiceInterface us = UserServiceFactory.createObject();

			int city_id = us.registerUserCity(c);
			int cred_id = us.registerUserCred(ul);
			System.out.println(city_id);
			System.out.println(cred_id);
			boolean emailCheck = us.checkEmailUnique(email);
			boolean usernameUniqCheck = us.checkUsernameUniq(username);
			if (emailCheck && usernameUniqCheck) {
				if(us.registerUserDetail(usr, city_id, cred_id))
					out.println("Registration Success");
		}
		
		out.println("</body></html>");
	}
		
		

}


