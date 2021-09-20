package com.reconnect.utility;

import com.reconnect.dao.ContactDao;
import com.reconnect.dao.ContactDaoInterface;

public class ContactDAOFactory {

	private ContactDAOFactory()
	{
		
	}
	
	public static ContactDaoInterface createContactDaoObject()
	{
		return new ContactDao();
	}
}
