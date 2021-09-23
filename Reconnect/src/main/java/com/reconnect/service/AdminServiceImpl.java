package com.reconnect.service;

import java.util.Map;

import com.reconnect.dao.AdminDaoImpl;
import com.reconnect.dao.util.AdminDao;
import com.reconnect.model.Admin;

public class AdminServiceImpl implements AdminService {
	static AdminDao admin_dao = new AdminDaoImpl();

	// function to validate admin
	public Admin adminLogin(String nm, String pass) {
		System.out.println("IN SERVICE");
		return admin_dao.adminLogin(nm, pass);
	}
	
	//function to get admin Details
	public Admin getAdminDetails() {
		return admin_dao.getAdminDetails();
	}
	
	//function to get total number of users
	public int numOfUser() {
		return admin_dao.numOfUser();
	}
	
	//function to get user info 
	public Map<String, String> viewAllUserInfo() {
		return admin_dao.viewAllUserInfo();
	}

	//function to get  disabled user info
	public Map<String, String> viewDisabledUser() {
		return admin_dao.viewDisabledUser();

	}
	
	//function to get user that can be deleted
	public Map<String, String> viewUserToDelete() {
		return admin_dao.viewUserToDelete();
	}
	
	//function to delete users
	public boolean deleteUser(String[] username) {
		return admin_dao.deleteUser(username);
	}
	//function to disable a user
	public boolean DisableUser(String[] pidarr) {
		return admin_dao.DisableUser(pidarr);
	}

}
