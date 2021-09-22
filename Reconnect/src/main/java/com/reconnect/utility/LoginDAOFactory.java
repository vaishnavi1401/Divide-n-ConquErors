package com.reconnect.utility;

import com.reconnect.dao.LoginDao;
import com.reconnect.dao.LoginDaoInterface;

public class LoginDAOFactory {
	
	private LoginDAOFactory()
	{
		
	}
	
	public static LoginDaoInterface createLoginDaoObject()
	{
		return new LoginDao();
	}

}
