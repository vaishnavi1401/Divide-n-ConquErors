package com.reconnect.dao.util;

import java.util.Map;

import com.reconnect.model.Admin;



public interface AdminDao {

	Admin getAdminDetails();
	Map<String, String> viewAllUserInfo();
	void deleteUser(int pid);
	Map<String, String> viewDisabledUser();
	void adminLogout();
	int numOfUser();
	Admin adminLogin(String nm, String pass);
	Map<String, String> viewUserToDelete();


}
