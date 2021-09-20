package com.reconnect.service;

import java.util.List;
import java.util.Map;

import com.reconnect.model.Admin;
import com.reconnect.model.User;

public interface AdminService {

	Admin getAdminDetails();
	Map<Integer,String> viewAllUserInfo();
	List<User>lastLoginUSer();
	void deleteUser();
	void viewDisabledUser();
	void adminLogout();
	int numOfUser();
	Admin AdminLogin(String nm, String pass);

}
