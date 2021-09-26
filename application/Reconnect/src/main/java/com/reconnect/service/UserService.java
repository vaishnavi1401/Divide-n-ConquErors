package com.reconnect.service;


import java.io.FileNotFoundException;
import java.util.List;

import com.reconnect.dao.util.FriendDaoInterface;
import com.reconnect.dao.util.UserDaoInterface;
import com.reconnect.factory.FriendDaoFactory;
import com.reconnect.factory.UserDAOFactory;
import com.reconnect.model.City;
import com.reconnect.model.User;
import com.reconnect.model.UserLogin;

public class UserService implements UserServiceInterface {

	public UserDaoInterface ud;

	public UserService(){

		ud=UserDAOFactory.createUserDaoObject();
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
			e.printStackTrace();
		}
		return false;
	}


	@Override
	public boolean checkUsernameUniq(String username) {
		return ud.checkUsernameUniq(username);
	}


	@Override
	public int getUserId(String username) {
		return ud.getUserId(username);
	}


	@Override
	public User getUserDetailsByUsername(String username) {
		return ud.getUserDetailsByUsername(username);
	}


	@Override
	public List<User> getUserDetailsByName(String firstName, String lastName) {
		return ud.getUserDetailsByName(firstName, lastName);
	}


	@Override
	public List<User> getUserDetailsByCity(String city) {
		return ud.getUserDetailsByCity(city);
	}


	@Override
	public List<User> getUserDetailsByState(String state) {
		return ud.getUserDetailsByState(state);
	}


	@Override
	public List<User> getUserDetailsByCountry(String country) {
		return ud.getUserDetailsByCountry(country);
	}

	@Override
	public User getUserDetailsById(int userId) {
		return ud.getUserDetailsById(userId);
	}

	@Override
	public List<User> getNonFriendsList(String username){
		return ud.getNonFriendsList(username);
	}
	//Friend Module Methods

	@Override
	public int addFriendRequest(UserLogin friend1, UserLogin friend2) {

		FriendDaoInterface friendDao=FriendDaoFactory.createObj();
		return friendDao.sendFriendRequest(friend1, friend2);
	}

	@Override
	public int acceptFriendRequest(UserLogin friend1, UserLogin friend2) {
		FriendDaoInterface friendDao=FriendDaoFactory.createObj();
		return friendDao.acceptFriendRequest(friend1, friend2);
	}

	@Override
	public int removeFriend(UserLogin friend1, UserLogin friend2) {
		FriendDaoInterface friendDao=FriendDaoFactory.createObj();
		return friendDao.removeFriend(friend1, friend2);
	}

	@Override
	public int ignoreRequest(UserLogin friend1, UserLogin friend2) {
		FriendDaoInterface friendDao=FriendDaoFactory.createObj();
		return friendDao.ignoreRequest(friend1, friend2);
	}


	@Override
	public List<User> getPendingRequest(UserLogin self) {
		FriendDaoInterface friendDao=FriendDaoFactory.createObj();
		return friendDao.getPendingRequests(self);
	}

	@Override
	public List<User> getFriends(UserLogin self) {
		FriendDaoInterface friendDao=FriendDaoFactory.createObj();
		return friendDao.getFriends(self);
	}


	@Override
	public User getUserDetailsByEmail(String contactEmail) {
		// TODO Auto-generated method stub
		return ud.getUserDetailsByEmail(contactEmail);
	}

}
