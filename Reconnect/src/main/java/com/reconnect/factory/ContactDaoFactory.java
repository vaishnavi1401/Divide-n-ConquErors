package com.reconnect.factory;

import com.reconnect.dao.ContactDao;
import com.reconnect.dao.util.ContactDaoInterface;

public class ContactDaoFactory {

	public static ContactDaoInterface createObject()
	{
		return new ContactDao();
	}
}
