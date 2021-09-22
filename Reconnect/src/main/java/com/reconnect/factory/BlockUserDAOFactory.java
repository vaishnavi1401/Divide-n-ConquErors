package com.reconnect.factory;

import com.reconnect.dao.BlockedUsersDao;
import com.reconnect.dao.util.BlockUserDaoInterface;

public class BlockUserDAOFactory {

	private BlockUserDAOFactory()
	{

	}
	
	public static BlockUserDaoInterface createobject() {
		// TODO Auto-generated method stub
		return new BlockedUsersDao();
	}

}
