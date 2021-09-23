package com.reconnect.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.reconnect.model.City;
import com.reconnect.model.Contact;
import com.reconnect.model.User;
import com.reconnect.service.ContactServiceInterface;
import com.reconnect.utility.ContactServiceFactory;

@WebServlet("/ContactController/*")
public class ContactController extends HttpServlet{
	
	ContactServiceInterface contactService=null;
	PrintWriter out=null;
	JsonConverter jConverter=null;
	//User object will be passed using session from main page
	User userObj = new User();
	
	public void init() throws ServletException {
	
		contactService=ContactServiceFactory.createObject();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		out = resp.getWriter();
		if (req.getPathInfo() != null) {
			String path = req.getPathInfo().substring(1);
			if (path.equals("addContact")) {
				addContactController(req,resp);
			}
			if (path.equals("viewContact")) {
				
				HttpSession ss = req.getSession();
				String username= (String) ss.getAttribute("message");
				String usr = ss.getAttribute("message").toString();
				
				
				System.out.println("**********1*********");
				System.out.println(username);
				
				System.out.println("**********2*********");
				System.out.println(usr);
				
				viewAllContactController(req,resp);
				
				
			}
			
		}
	}

	public void addContactController(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		Object obj = req.getAttribute("info");
		User userObj = (User) obj;
		out = resp.getWriter();
		String contactFname = req.getParameter("contactFname");
		String contactLname = req.getParameter("contactLname");
		String contactEmail = req.getParameter("contactEamil");
		String contactPhone = req.getParameter("contactPhone"); 
		String contactGender = req.getParameter("contactGender"); 
		System.out.println(contactGender);
		String contactDob = req.getParameter("contactDob"); 
		String contactAddress = req.getParameter("contactAddress"); 
		String contactCity = req.getParameter("contactCity"); 
		String contactState = req.getParameter("contactState"); 
		String contactCountry = req.getParameter("contactCountry"); 
		String contactCompany = req.getParameter("contactCompany");
		Date date1=Date.valueOf(contactDob);
		//need to check for email clash
		//this code comes in else, when there is no clash of email
		City cityObject=new City();
		cityObject.setCity(contactCity);
		cityObject.setCountry(contactCountry);
		cityObject.setState(contactState);
		//System.out.println("Inside servletaddcontact");
//		Contact contactObject=new Contact(contactFname, contactLname, contactEmail, date1, contactAddress, contactCompany, contactPhone, cityObject,contactGender);
		
		Contact contactObject = new Contact(contactFname, contactLname, contactEmail, date1, contactAddress, contactCompany, contactPhone, contactGender, cityObject);
		if(contactService.addContactService(userObj, contactObject)>0)
			req.getRequestDispatcher("/index.html").forward(req, resp);//To the page after adding contact
		//need to pass to a page after adding user
	}
	
	public void viewAllContactController(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		
		 System.out.println("in view" + userObj.getCompany()); List<Contact>
		 list=contactService.viewAllContactService(userObj);
		 System.out.println(list.size()); jConverter=new JsonConverter(); String
		 ContactList = jConverter.convertListToJson(list); out.print(ContactList);
		 
	}
	
	public void searchContactController(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		
	}
	
	public void editContact(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		
	}
	
	public void deleteContact(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		
	}
	
}
