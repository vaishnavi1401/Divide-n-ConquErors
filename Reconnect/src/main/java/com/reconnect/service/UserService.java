package com.reconnect.service;


import java.io.FileNotFoundException;
import java.util.List;

import com.reconnect.dao.util.FriendDaoInterface;
import com.reconnect.dao.util.UserDaoInterface;
import com.reconnect.model.City;
import com.reconnect.model.User;
import com.reconnect.model.UserLogin;
import com.reconnect.factory.FriendDaoFactory;
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

	public User getUserDetailsById(int userId) {
		return ud.getUserDetailsById(userId);
	}
	
	//Friend Module Methods 
	
public int addFriendRequest(UserLogin friend1, UserLogin friend2) {
		
		FriendDaoInterface friendDao=FriendDaoFactory.createObj();
		return friendDao.sendFriendRequest(friend1, friend2);
	}

	public int acceptFriendRequest(UserLogin friend1, UserLogin friend2) {
		FriendDaoInterface friendDao=FriendDaoFactory.createObj();
		return friendDao.acceptFriendRequest(friend1, friend2);
	}
	
	public int removeFriend(UserLogin friend1, UserLogin friend2) {
		FriendDaoInterface friendDao=FriendDaoFactory.createObj();
		return friendDao.removeFriend(friend1, friend2);
	}

	public int ignoreRequest(UserLogin friend1, UserLogin friend2) {
		FriendDaoInterface friendDao=FriendDaoFactory.createObj();
		return friendDao.ignoreRequest(friend1, friend2);
	}


	public List<User> getPendingRequest(UserLogin self) {
		FriendDaoInterface friendDao=FriendDaoFactory.createObj();
		return friendDao.getPendingRequests(self);
	}

	public List<User> getFriends(UserLogin self) {
		FriendDaoInterface friendDao=FriendDaoFactory.createObj();
		return friendDao.getFriends(self);
	}

	
}
