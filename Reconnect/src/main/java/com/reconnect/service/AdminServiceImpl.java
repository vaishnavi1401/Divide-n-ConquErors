package com.reconnect.service;

import java.util.Map;

import com.reconnect.dao.util.AdminDao;
import com.reconnect.dao.AdminDaoImpl;
import com.reconnect.model.Admin;

public class AdminServiceImpl implements AdminService {
	static AdminDao admin_dao = new AdminDaoImpl();

	// function to validate admin
	
	public Admin adminLogin(String nm, String pass) {
		System.out.println("IN SERVICE");
		return admin_dao.adminLogin(nm, pass);
	}

	
	public Admin getAdminDetails() {
		return admin_dao.getAdminDetails();
	}

	
	public int numOfUser() {
	return admin_dao.numOfUser();
			}

	
	public Map<String, String> viewAllUserInfo() {
		return admin_dao.viewAllUserInfo();
	}

	
	public void deleteUser(int uid) {
		admin_dao.deleteUser(uid);
	}

	
	public Map<String, String> viewDisabledUser() {
		return admin_dao.viewDisabledUser();
		
		
	}

	
	public void adminLogout() {
		
		
	}

	
	public Map<String, String> viewUserToDelete() {
		return admin_dao.viewUserToDelete();
	}


}
