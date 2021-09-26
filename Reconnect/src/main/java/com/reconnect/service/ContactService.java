package com.reconnect.service;

import java.io.FileNotFoundException;
import java.util.List;

import com.reconnect.controller.JsonConverter;
import com.reconnect.dao.util.ContactDaoInterface;
import com.reconnect.factory.ContactDAOFactory;
import com.reconnect.model.Contact;
import com.reconnect.model.User;


public class ContactService implements ContactsServiceInterface{
	ContactDaoInterface contactDaoObj=null;
	
	
	public ContactService()
	{
		contactDaoObj=ContactDAOFactory.createObject();
		
	}

	public int addContactService(Contact contact1,String userName) {
		int value=0;
		//System.out.println("Inside service");
		try {
			value= contactDaoObj.addContact(contact1, userName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return value;
	}

	public List<Contact> viewAllContactService(String userName) {
		return contactDaoObj.viewAllContacts(userName);
	}


	public int editContactService(Contact c1, String userName) {
		return contactDaoObj.editContact(c1, userName);
		
	}

	public int deleteContactService(String username, String email) {
		// Function calling delete method of ContactDao class
		return contactDaoObj.deleteContact(username, email);

	}

}
