package com.reconnect.dao;

import java.sql.PreparedStatement;

import com.reconnect.model.UserLogin;

public interface LoginDaoInterface {
	
	public int checkLoginCredentials(UserLogin userLogin);
	
	public int registerCredentials(UserLogin ul);
	
	public boolean updateLastLogin(UserLogin ul);
	
	

}
