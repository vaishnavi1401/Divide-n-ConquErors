package com.reconnect.service;

import java.util.List;

import com.reconnect.model.Contact;
import com.reconnect.model.User;

public interface ContactServiceInterface {

	public int addContactService(User user,Contact contact1);
	public List<Contact> viewAllContactService(User user1);
	public Contact searchContact(User user1, String name);//name can be fname, lname, city, status, country as all are string-->no need of overloading
	public void editContactService(User user1, Contact contact1);
	public void deleteContactService(User user1, Contact contact1);
	
}
