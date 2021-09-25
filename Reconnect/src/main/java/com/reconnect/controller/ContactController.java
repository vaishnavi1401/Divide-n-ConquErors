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
import com.reconnect.utility.JsonConverter;
import com.reconnect.factory.ContactServiceFactory;

@WebServlet("/ContactController/*")
public class ContactController extends HttpServlet {

	ContactServiceInterface contactService = null;
	PrintWriter out = null;
	JsonConverter jConverter = null;
	HttpSession session;

	public void init() throws ServletException {

		contactService = ContactServiceFactory.createObject();// calling the service method to return the object
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		session = req.getSession();
		out = resp.getWriter();
		if (req.getPathInfo() != null) {
			String path = req.getPathInfo().substring(1);// fetching the substring from the path

			if (path.equals("addContact")) {
				addContactController(req, resp);// calling method for adding data
			}
			if (path.equals("viewContact")) {
				viewAllContactController(req, resp);// calling method to send data in json form for searching
			}
			if (path.equals("viewContactMain")) {
				viewAllContactMainController(req, resp);// calling method to view data
			}
			if (path.equals("editContact")) {

				editContact(req, resp);// calling method to edit data
			} else {
				deleteContact(path, req, resp);// calling method to delete data
			}

		}
	}

	public void addContactController(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		out = resp.getWriter();

		// calling username from session
		String userName = (String) session.getAttribute("message");

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
		Date date1 = Date.valueOf(contactDob);

		City cityObject = new City();
		cityObject.setCity(contactCity);
		cityObject.setCountry(contactCountry);
		cityObject.setState(contactState);

		// creating contact object after fetching data from html page
		Contact contactObject = new Contact(contactFname, contactLname, contactEmail, date1, contactAddress,
				contactCompany, contactPhone, contactGender, cityObject);

		// calling service method to add contact
		int i = contactService.addContactService(contactObject, userName);

		// method to view contact after adding
		viewAllContactMainController(req, resp);
	}

	public void viewAllContactController(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// calling username from session
		String userName = (String) session.getAttribute("message");

		// Fetching list of objects
		List<Contact> list = contactService.viewAllContactService(userName);
		jConverter = new JsonConverter();// object of json converter
		String ContactList = jConverter.convertListToJson(list);// string stores the list of objects in json format
		out.print(ContactList);
	}

	public void viewAllContactMainController(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// calling username from session
		String userName = (String) session.getAttribute("message");

		List<Contact> list = contactService.viewAllContactService(userName);// Fetching list of objects
		req.setAttribute("contactList", list);
		req.getRequestDispatcher("/ContactList.jsp").forward(req, resp);// forwarding to jsp page

	}

	public void editContact(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// calling username from session
		String userName = (String) session.getAttribute("message");

		String emailEdit = (String) session.getAttribute("emailEdit");
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
		Date date1 = Date.valueOf(contactDob);
		City cityObject = new City();
		cityObject.setCity(contactCity);
		cityObject.setCountry(contactCountry);
		cityObject.setState(contactState);

		// creating contact object after fetching edited data from html page
		Contact contactObject = new Contact(contactFname, contactLname, emailEdit, date1, contactAddress,
				contactCompany, contactPhone, contactGender, cityObject);

		// calling service method to edit contact
		int i = contactService.editContactService(contactObject, userName);

		// method to view contact after editing
		viewAllContactMainController(req, resp);

	}

	public void deleteContact(String path, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// calling username from session
		String userName = (String) session.getAttribute("message");

		String[] deletePara = path.split("/");// Splitting path
		int l = deletePara.length;
		String email = deletePara[l - 1];// Assigning email the last value for multiple deletes

		// calling service method to delete contact
		contactService.deleteContactService(userName, email);

		// method to view contact after deleting
		viewAllContactMainController(req, resp);
	}

}
