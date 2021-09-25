package com.reconnect.service;

import java.util.List;

import com.reconnect.model.Contact;
import com.reconnect.model.User;

public interface ContactServiceInterface {

	public int addContactService(Contact contact1, String userName);

	public List<Contact> viewAllContactService(String userName);

	public int editContactService(Contact c1, String userName);

	public int deleteContactService(String username, String email);
}
