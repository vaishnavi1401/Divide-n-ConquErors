package com.reconnect.service;

import java.io.FileNotFoundException; 
import java.util.List;

import com.reconnect.utility.JsonConverter;
import com.reconnect.dao.util.ContactDaoInterface;
import com.reconnect.model.Contact;
import com.reconnect.model.User;
import com.reconnect.factory.ContactDAOFactory;

public class ContactService implements ContactsServiceInterface {
	ContactDaoInterface contactDaoObj = null;

	public ContactService() {
		// Object for ContactDao
		contactDaoObj = ContactDAOFactory.createObject();

	}

	public int addContactService(Contact contact1, String userName) {
		// Function calling add method of ContactDao class
		int value = 0;
		try {
			value = contactDaoObj.addContact(contact1, userName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return value;
	}

	public List<Contact> viewAllContactService(String userName) {
		// Function calling view method of ContactDao class
		return contactDaoObj.viewAllContacts(userName);
	}

	public int editContactService(Contact c1, String userName) {
		// Function calling edit method of ContactDao class
		return contactDaoObj.editContact(c1, userName);

	}

	public int deleteContactService(String username, String email) {
		// Function calling delete method of ContactDao class
		return contactDaoObj.deleteContact(username, email);

	}
	
	public boolean ifContactExistsService(String username, String email) {
		return contactDaoObj.ifContactExists(username, email);
	}

	public Contact viewContact(String username, String email) {
		// TODO Auto-generated method stub
		return contactDaoObj.viewContact(username, email);
	}

}