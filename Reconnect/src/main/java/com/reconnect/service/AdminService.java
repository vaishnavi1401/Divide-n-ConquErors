package com.reconnect.service;

import java.util.List;
import java.util.Map;

import com.reconnect.model.Admin;
import com.reconnect.model.User;

public interface AdminService {

	Admin getAdminDetails();
	Map<String, String> viewAllUserInfo();
	void deleteUser(int pid);
	Map<String, String> viewDisabledUser();
	Map<String, String> viewUserToDelete();
	void adminLogout();
	int numOfUser();
	Admin adminLogin(String nm, String pass);

}
