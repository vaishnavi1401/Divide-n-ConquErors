

package com.reconnect.service;

import java.util.List;

import com.reconnect.model.City;
import com.reconnect.model.User;
import com.reconnect.model.UserLogin;

public interface UserServiceInterface {

	int loginValidation(UserLogin ul);

	int registerUserCity(City c);

	int registerUserCred(UserLogin ul);

	boolean checkEmailUnique(String email);

	boolean checkUsernameUniq(String username);

	int getUserId(String username);

	boolean registerUserDetail(User userDetails, int city_id, int cred_id);

	User getUserDetailsByUsername(String username);

	int addFriendRequest(UserLogin friend1, UserLogin friend2);

	int acceptFriendRequest(UserLogin friend1, UserLogin friend2);

	int removeFriend(UserLogin friend1, UserLogin friend2);

	int ignoreRequest(UserLogin friend1, UserLogin friend2);

	List<User> getPendingRequest(UserLogin self);

	List<User> getFriends(UserLogin self);


	List<User> getUserDetailsByName(String firstName, String lastName);

	List<User> getUserDetailsByCity(String city);

	List<User> getUserDetailsByState(String state);

	List<User> getUserDetailsByCountry(String country);

	User getUserDetailsById(int userId);

	List<User> getNonFriendsList(String username);

	User getUserDetailsByEmail(String contactEmail);

}
