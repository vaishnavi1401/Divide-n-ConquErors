package com.reconnect.model;

import java.sql.Timestamp;

public class UserLogin {

	private String userName;
	private String password;
	private Timestamp lastLogin; //initialized in dao


	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public void setLastLogin(Timestamp lastLogin) {
		this.lastLogin = lastLogin;
	}
	public Timestamp getLastLogin()
	{
		return lastLogin;
	}



}
