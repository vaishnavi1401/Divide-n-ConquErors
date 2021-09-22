package com.reconnect.dao.util;

import java.util.List;

import com.reconnect.model.User;

public interface BlockUserDaoInterface {

	List<User> viewBlockedUsers(String userName);

}
