package com.reconnect.factory;

import com.reconnect.dao.UserDao;
import com.reconnect.dao.util.UserDaoInterface;

public class UserDAOFactory {

	private UserDAOFactory()
	{

	}
	public static UserDaoInterface createobject() {
		return new UserDao();
	}

}
