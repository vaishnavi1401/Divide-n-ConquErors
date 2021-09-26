package com.reconnect.service;

public class ContactServiceFactory {

	public static ContactsServiceInterface createObject()
	{
		return new ContactService();
	}
}