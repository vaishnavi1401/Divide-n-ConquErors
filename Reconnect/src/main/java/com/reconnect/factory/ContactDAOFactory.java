package com.reconnect.factory;

import com.reconnect.dao.ContactDao;
import com.reconnect.dao.util.ContactDaoInterface;

public class ContactDAOFactory {
	
	private ContactDAOFactory()
	{
		
	}
	
	public static ContactDaoInterface createContactDaoObject()
	{
		return new ContactDao();
	}

}
