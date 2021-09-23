package com.reconnect.dao.util;

import java.io.FileNotFoundException;
import java.util.List;

import com.reconnect.model.City;
import com.reconnect.model.Contact;
import com.reconnect.model.User;

public interface ContactDaoInterface {
	
	public int addContact(Contact c1 , String username) throws FileNotFoundException;  //done
	
	public int getUserId(String email);  //done
		
	public List<Contact> viewAllContacts(String username);  //done
	
	public int editContact(Contact c1 , String username);  //done
	
	int deleteContact(String username , String fName , String lName , String phoneNo , String email);  //done
	
	public int getContactId(String username , String fName , String lName , String phoneNo , String email);  //done
	
	public Contact viewContact(String username , String fName , String lName , String phoneNo , String email);  //done
	
	public City fetchCityObj(int cid);  //done
}
