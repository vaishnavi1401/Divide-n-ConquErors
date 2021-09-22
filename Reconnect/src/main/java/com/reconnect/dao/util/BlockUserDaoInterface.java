package com.reconnect.dao.util;

import java.util.List;

import com.reconnect.model.User;

public interface BlockUserDaoInterface {

	List<User> viewBlockedUsers(String userName);
	public List<Integer> getUserBlockedList(int userId);
	public boolean unblockUser(String blockedBy, String blockedWho);
}
