package com.reconnect.service;

import java.util.List;

import com.reconnect.model.User;

public interface UserBlockServiceInterface {

	List<User> viewBlockedUsers(String userName);

}
