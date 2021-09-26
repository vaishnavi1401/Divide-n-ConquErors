package com.reconnect.dao.util;

import java.util.Map;

import com.reconnect.model.Admin;

//Admin Functions
public interface AdminDao {
	Admin getAdminDetails();

	Map<String, String> viewAllUserInfo();

	boolean deleteUser(String[] username);

	Map<String, String> viewDisabledUser();

	int numOfUser();

	Admin adminLogin(String nm, String pass);

	Map<String, String> viewUserToDelete();

	boolean DisableUser(String[] pidarr);

}
