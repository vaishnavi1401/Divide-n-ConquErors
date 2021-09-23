package com.reconnect.service;

import java.io.FileNotFoundException;
import java.util.List;

import com.reconnect.controller.JsonConverter;
import com.reconnect.dao.util.ContactDaoInterface;
import com.reconnect.model.Contact;
import com.reconnect.model.User;
import com.reconnect.utility.ContactDaoFactory;

public class ContactService implements ContactServiceInterface{
	ContactDaoInterface contactDaoObj=null;
	
	
	public ContactService()
	{
		contactDaoObj=ContactDaoFactory.createObject();
		
	}

	public int addContactService(User user1, Contact contact1) {
		int value=0;
		//System.out.println("Inside service");
		try {
			value= contactDaoObj.addContact(contact1, user1);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return value;
	}

	public List<Contact> viewAllContactService(User user1) {
		return contactDaoObj.viewAllContacts(user1);
	}

	 
	public Contact searchContact(User user1, String name) {
		
		return null;
	}

	 
	public void editContactService(User user1, Contact contact1) {
		
		
	}

	 
	public void deleteContactService(User user1, Contact contact1) {
		
		
	}

}
