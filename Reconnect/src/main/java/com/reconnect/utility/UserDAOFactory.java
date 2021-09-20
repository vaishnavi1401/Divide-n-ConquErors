package com.reconnect.utility;

import com.reconnect.dao.UserDao;
import com.reconnect.dao.UserDaoInterface;

public class UserDAOFactory {

	private UserDAOFactory()
	{

	}
	public static UserDaoInterface createobject() {
		// TODO Auto-generated method stub
		return new UserDao();
	}

}
