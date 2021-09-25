package com.reconnect.factory;

import com.reconnect.service.ContactService;
import com.reconnect.service.ContactServiceInterface;

public class ContactServiceFactory {

	public static ContactServiceInterface createObject()
	{
		return new ContactService();
	}
}
