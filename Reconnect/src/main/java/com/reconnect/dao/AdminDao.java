package com.reconnect.dao;

import java.util.Map;

import com.reconnect.model.Admin;



public interface AdminDao {

	Admin adminLogin(String nm, String pass);
	Admin getAdminDetails();
	void viewDisabledUser();
	void viewDeletedUser();
	int numOfUser();
	Map<Integer, String> viewAllUser();

}
