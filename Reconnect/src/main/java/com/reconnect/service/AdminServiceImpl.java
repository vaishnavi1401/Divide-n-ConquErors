package com.reconnect.service;

import java.util.List;
import java.util.Map;

import com.reconnect.dao.AdminDao;
import com.reconnect.dao.AdminDaoImpl;
import com.reconnect.model.Admin;
import com.reconnect.model.User;

public class AdminServiceImpl implements AdminService {
	static AdminDao admin_dao = new AdminDaoImpl();

	// function to validate admin
	@Override
	public Admin AdminLogin(String nm, String pass) {
		System.out.println("IN SERVICE");
		return admin_dao.adminLogin(nm, pass);

	}

	@Override
	public Admin getAdminDetails() {
		return admin_dao.getAdminDetails();
	}


	@Override
	public List<User> lastLoginUSer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser() {
		// TODO Auto-generated method stub

	}

	@Override
	public void viewDisabledUser() {
		// TODO Auto-generated method stub

	}

	@Override
	public void adminLogout() {
		// TODO Auto-generated method stub

	}

	@Override
	public int numOfUser() {
	return admin_dao.numOfUser();
			}

	@Override
	public Map<Integer, String> viewAllUserInfo() {
		return admin_dao.viewAllUser();
	}


}
