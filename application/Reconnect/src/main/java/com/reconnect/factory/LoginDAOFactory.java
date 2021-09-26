package com.reconnect.factory;

import com.reconnect.dao.LoginDao;
import com.reconnect.dao.util.LoginDaoInterface;

public class LoginDAOFactory {

	public LoginDAOFactory()
	{

	}

	public static LoginDaoInterface createLoginDaoObject()
	{
		return new LoginDao();
	}

}
