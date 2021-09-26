package com.reconnect.service;

import java.util.List;

import com.reconnect.model.User;

public interface UserBlockServiceInterface {

	public boolean blockUser(String blockedBy, String blockedWho);
	List<User> viewBlockedUsers(String userName);
	public List<Integer> getUserBlockedList(int userId);
	public boolean unblockUser(String blockedBy, String blockedWho);

	public boolean removeFromFriend(int userId, int userBlockedId);

}
