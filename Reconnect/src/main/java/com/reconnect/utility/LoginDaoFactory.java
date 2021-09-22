package com.reconnect.utility;

import com.reconnect.dao.LoginDao;
import com.reconnect.dao.LoginDaoInterface;

public class LoginDaoFactory {

	private LoginDaoFactory()
	{

	}
	public static LoginDaoInterface createobject() {
		return new LoginDao();
	}
}
