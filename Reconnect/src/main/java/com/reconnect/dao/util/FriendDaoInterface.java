package com.reconnect.dao.util;

import java.util.List;

import com.reconnect.model.User;
import com.reconnect.model.UserLogin;

public interface FriendDaoInterface {

	public int sendFriendRequest(UserLogin friend1,UserLogin friend2);
	public int acceptFriendRequest(UserLogin friend1,UserLogin friend2);
	public List<User> getPendingRequests(UserLogin friend);
//	public List<UserLogin> fetchByUn();
	public List<User> getFriends(UserLogin self);
	public int removeFriend(UserLogin friend1, UserLogin friend2);
	public int ignoreRequest(UserLogin friend1, UserLogin friend2);
}