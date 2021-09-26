package com.reconnect.service;

import java.io.FileNotFoundException;
import java.util.List;

import com.reconnect.dao.util.ContactDaoInterface;
import com.reconnect.factory.ContactDAOFactory;
import com.reconnect.model.Contact;

public class ContactService implements ContactsServiceInterface {
	ContactDaoInterface contactDaoObj = null;

	public ContactService() {
		// Object for ContactDao
		contactDaoObj = ContactDAOFactory.createObject();

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

	@Override
	public boolean ifContactExistsService(String username, String email) {
		return contactDaoObj.ifContactExists(username, email);
	}

	@Override
	public Contact viewContact(String username, String email) {
		// TODO Auto-generated method stub
		return contactDaoObj.viewContact(username, email);
	}

}