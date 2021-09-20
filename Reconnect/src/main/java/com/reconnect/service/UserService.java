package com.reconnect.service;


import java.io.FileNotFoundException;

import com.reconnect.dao.UserDaoInterface;
import com.reconnect.model.City;
import com.reconnect.model.User;
import com.reconnect.model.UserLogin;
import com.reconnect.utility.UserDAOFactory;

public class UserService implements UserServiceInterface {

	public UserDaoInterface ud;

	public UserService(){

		ud=UserDAOFactory.createobject();
	}

	@Override
	public int loginValidation(UserLogin ul) {

		return ud.loginValidation(ul);
	}

	@Override
	public int registerUserCity(City c) {
		return ud.registerUserCity(c);
	}

	@Override
	public int registerUserCred(UserLogin ul) {
		return ud.registerUserCred(ul);
	}

	@Override
	public boolean checkEmailUnique(String email) {
		return ud.checkEmailUnique(email);
	}

	@Override
	public boolean registerUserDetail(User usr, int city_id, int cred_id) {
		try {
			return ud.registerUserDetail(usr, city_id,cred_id);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
