package com.reconnect.dao.util;

import java.io.FileNotFoundException;
import java.util.List;

import com.reconnect.model.City;
import com.reconnect.model.Contact;
import com.reconnect.model.User;

public interface ContactDaoInterface {
	
	public int addContact(Contact c1 , User u1) throws FileNotFoundException;
	
	public int getUserId(String email);
	
	public int getCityId(City c);
	
	public List<Contact> viewAllContacts(User u1);
	
	public int editContact(Contact c1 , User u1);
	
	public int deleteContact(Contact c1 , User u1);
	
	public int getContactId(Contact c1 , User u1);
	
	public Contact viewContact(Contact c1 ,User u1);
}
