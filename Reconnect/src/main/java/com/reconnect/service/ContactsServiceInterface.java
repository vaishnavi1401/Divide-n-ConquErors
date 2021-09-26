package com.reconnect.service;

import java.util.List;

import com.reconnect.model.Contact;


public interface ContactsServiceInterface {

	public int addContactService(Contact contact1, String userName);

	public List<Contact> viewAllContactService(String userName);

	public int editContactService(Contact c1, String userName);

	public int deleteContactService(String userName, String email);
}