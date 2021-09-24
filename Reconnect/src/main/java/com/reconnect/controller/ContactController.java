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
	HttpSession session;
	//User object will be passed using session from main page
	
	
	
	public void init() throws ServletException {
	
		contactService=ContactServiceFactory.createObject();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		session=req.getSession();
		out = resp.getWriter();
		if (req.getPathInfo() != null) {
			String path = req.getPathInfo().substring(1);
			//System.out.println("#"+path);
			if (path.equals("addContact")) {
				addContactController(req,resp);
			}
			if (path.equals("viewContact")) {
				viewAllContactController(req,resp);
			}
			if (path.equals("viewContactMain")) {
				viewAllContactMainController(req,resp);
			}
			if (path.equals("editContact")) {
				
				editContact(req,resp);
			}
			else
			{
				deleteContact(path,req,resp);
			}
			
		}
	}

	public void addContactController(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		out = resp.getWriter();
		
		//calling username from session 
		String userName=(String)session.getAttribute("message");
		
		
		String contactFname = req.getParameter("contactFname");
		String contactLname = req.getParameter("contactLname");
		String contactEmail = req.getParameter("contactEamil");
		String contactPhone = req.getParameter("contactPhone"); 
		String contactGender = req.getParameter("contactGender"); 
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
		Contact contactObject=new Contact(contactFname, contactLname, contactEmail, date1, contactAddress, contactCompany, contactPhone, contactGender,cityObject);
		int i=contactService.addContactService(contactObject,userName);
		
		
		viewAllContactMainController(req,resp);//To the page after adding contact
		//need to pass to a page after adding user
	}
	
	public void viewAllContactController(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		
		String userName=(String)session.getAttribute("message");
		
		List<Contact> list=contactService.viewAllContactService(userName);
		jConverter=new JsonConverter();
		String ContactList = jConverter.convertListToJson(list);
		System.out.println(ContactList);
		out.print(ContactList);
	}
	
	public void viewAllContactMainController(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		
		//calling username from session 
		String userName=(String)session.getAttribute("message");
		
		List<Contact> list=contactService.viewAllContactService(userName);
		req.setAttribute("contactList", list);
		req.getRequestDispatcher("/ContactList.jsp").forward(req, resp);
		
	}
	
	public void editContact(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		
		//calling username from session 
		String userName=(String)session.getAttribute("message");
		
		String emailEdit = (String)session.getAttribute("emailEdit");
		String contactFname = req.getParameter("contactEditFname");
		String contactLname = req.getParameter("contactEditLname");
		String contactEmail = req.getParameter("contactEditEamil");
		String contactPhone = req.getParameter("contactEditPhone"); 
		String contactGender = req.getParameter("contactEditGender"); 
		String contactDob = req.getParameter("contactEditDob"); 
		String contactAddress = req.getParameter("contactEditAddress"); 
		String contactCity = req.getParameter("contactEditCity"); 
		String contactState = req.getParameter("contactEditState"); 
		String contactCountry = req.getParameter("contactEditCountry"); 
		String contactCompany = req.getParameter("contactEditCompany");
		Date date1=Date.valueOf(contactDob);
		City cityObject=new City();
		cityObject.setCity(contactCity);
		cityObject.setCountry(contactCountry);
		cityObject.setState(contactState);
		Contact contactObject=new Contact(contactFname, contactLname, emailEdit, date1, contactAddress, contactCompany, contactPhone, contactGender,cityObject);
		int i=contactService.editContactService(contactObject, userName);
		
		viewAllContactMainController(req,resp);
		
	}
	
	public void deleteContact(String path,HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		//calling username from session 
		String userName=(String)session.getAttribute("message");
		
		String[] deletePara=path.split("/");
		String fname=deletePara[0];
		String lname=deletePara[0];
		String email=deletePara[0];
		String phone=deletePara[0];
		contactService.deleteContactService(userName,fname,lname,phone,email);
		
		viewAllContactMainController(req,resp);
	}
	
}
