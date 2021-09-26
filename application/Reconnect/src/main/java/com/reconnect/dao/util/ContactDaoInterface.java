package com.reconnect.dao.util;

import java.io.FileNotFoundException;
import java.util.List;

import com.reconnect.model.City;
import com.reconnect.model.Contact;

public interface ContactDaoInterface {


	public int addContact(Contact c1 , String username) throws FileNotFoundException;  //image implementation remaining

	public int getUserId(String email);

	public List<Contact> viewAllContacts(String username);   //image implementation remaining

	public int editContact(Contact c1 , String username);   //image implementation remaining

	public int deleteContact(String username , String email);

	public int getContactId(String username , String email);

	public Contact viewContact(String username , String email);    //image implementation remaining

	public City fetchCityObj(int cid);

	Contact ifContactIsUser(String username, String email);

	boolean ifContactExists(String username, String email);
}

