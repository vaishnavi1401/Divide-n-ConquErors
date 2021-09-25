package com.reconnect.service;

import java.io.FileNotFoundException;
import java.util.List;

import com.reconnect.controller.JsonConverter;
import com.reconnect.dao.ContactDaoInterface;
import com.reconnect.model.Contact;
import com.reconnect.model.User;
import com.reconnect.utility.ContactDaoFactory;

public class ContactService implements ContactServiceInterface {
	ContactDaoInterface contactDaoObj = null;

	public ContactService() {
		// Object for ContactDao
		contactDaoObj = ContactDaoFactory.createObject();

	}

	@Override
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

	@Override
	public List<Contact> viewAllContactService(String userName) {
		// Function calling view method of ContactDao class
		return contactDaoObj.viewAllContacts(userName);
	}

	@Override
	public int editContactService(Contact c1, String userName) {
		// Function calling edit method of ContactDao class
		return contactDaoObj.editContact(c1, userName);

	}

	@Override
	public int deleteContactService(String username, String email) {
		// Function calling delete method of ContactDao class
		return contactDaoObj.deleteContact(username, email);

	}

}
