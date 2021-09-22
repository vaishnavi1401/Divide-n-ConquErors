package com.reconnect.factory;

import com.reconnect.service.UserService;
import com.reconnect.service.UserServiceInterface;

public class UserServiceFactory {

	private UserServiceFactory()
	{

	}
	public static UserServiceInterface createObject() {

		return new UserService();
	}

}
