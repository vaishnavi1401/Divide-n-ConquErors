package com.reconnect.service;


import java.io.FileNotFoundException;
import java.util.List;

import com.reconnect.dao.util.UserDaoInterface;
import com.reconnect.model.City;
import com.reconnect.model.User;
import com.reconnect.model.UserLogin;
import com.reconnect.factory.UserDAOFactory;

public class UserService implements UserServiceInterface {

	public UserDaoInterface ud;

	public UserService(){

		ud=UserDAOFactory.createobject();
	}

	
	public int loginValidation(UserLogin ul) {

		return ud.loginValidation(ul);
	}

	
	public int registerUserCity(City c) {
		return ud.registerUserCity(c);
	}

	
	public int registerUserCred(UserLogin ul) {
		return ud.registerUserCred(ul);
	}

	
	public boolean checkEmailUnique(String email) {
		return ud.checkEmailUnique(email);
	}

	
	public boolean registerUserDetail(User usr, int city_id, int cred_id) {
		try {
			return ud.registerUserDetail(usr, city_id,cred_id);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}


	public boolean checkUsernameUniq(String username) {
		return ud.checkUsernameUniq(username);
	}


	public int getUserId(String username) {
		return ud.getUserId(username);
	}


	public User getUserDetailsByUsername(String username) {
		return ud.getUserDetailsByUsername(username);
	}


	public List<User> getUserDetailsByName(String firstName, String lastName) {
		return ud.getUserDetailsByName(firstName, lastName);
	}


	public List<User> getUserDetailsByCity(String city) {
		return ud.getUserDetailsByCity(city);
	}


	public List<User> getUserDetailsByState(String state) {
		return ud.getUserDetailsByState(state);
	}


	public List<User> getUserDetailsByCountry(String country) {
		return ud.getUserDetailsByCountry(country);
	}


	public List<User> getUserDetailsByCompany(String company) {
		return ud.getUserDetailsByCompany(company);
	}


	public List<User> getUserDetailsById(int userId) {
		return ud.getUserDetailsById(userId);
	}
}
