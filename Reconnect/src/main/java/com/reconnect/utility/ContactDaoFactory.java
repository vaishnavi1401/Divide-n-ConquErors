package com.reconnect.utility;

import com.reconnect.dao.ContactDao;
import com.reconnect.dao.ContactDaoInterface;

public class ContactDaoFactory {
	
	private ContactDaoFactory()
	{
		
	}
	
	public static ContactDaoInterface createContactDaoObject()
	{
		return new ContactDao();
	}

}
