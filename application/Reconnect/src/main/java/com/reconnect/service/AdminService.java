package com.reconnect.service;

import java.util.Map;

import com.reconnect.model.Admin;

//Admin Service Functions
public interface AdminService {

	Admin getAdminDetails();

	Map<String, String> viewAllUserInfo();

	boolean deleteUser(String[] pidarr);

	Map<String, String> viewDisabledUser();

	Map<String, String> viewUserToDelete();

	int numOfUser();

	Admin adminLogin(String nm, String pass);

	boolean DisableUser(String[] pidarr);

}
