package com.reconnect.service;

import java.util.List;

import com.reconnect.dao.util.BlockUserDaoInterface;
import com.reconnect.factory.BlockUserDAOFactory;
import com.reconnect.model.User;

public class UserBlockService implements UserBlockServiceInterface {

	public BlockUserDaoInterface bd;

	public UserBlockService(){

		bd=BlockUserDAOFactory.createobject();
	}
	
	public List<User> viewBlockedUsers(String userName) {
		
		return bd.viewBlockedUsers(userName);
	}

}
