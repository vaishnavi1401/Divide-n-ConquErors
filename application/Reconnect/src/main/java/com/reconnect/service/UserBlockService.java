package com.reconnect.service;

import java.util.List;

import com.reconnect.dao.util.BlockUserDaoInterface;
import com.reconnect.factory.BlockUserDAOFactory;
import com.reconnect.model.User;

public class UserBlockService implements UserBlockServiceInterface {

	public BlockUserDaoInterface bd;

	public UserBlockService(){

		bd=BlockUserDAOFactory.createobject();
	}

	@Override
	public boolean blockUser(String blockedBy, String blockedWho) {
		return bd.blockUser(blockedBy, blockedWho);
	}

	@Override
	public List<User> viewBlockedUsers(String userName) {

		return bd.viewBlockedUsers(userName);
	}

	@Override
	public List<Integer> getUserBlockedList(int userId) {
		return bd.getUserBlockedList(userId);
	}

	@Override
	public boolean unblockUser(String blockedBy, String blockedWho) {
		return bd.unblockUser(blockedBy, blockedWho);
	}

	@Override
	public boolean removeFromFriend(int userId, int userBlockedId) {
		return bd.removeFromFriend(userId, userBlockedId);
	}
}


