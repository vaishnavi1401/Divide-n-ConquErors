package com.reconnect.dao.util;


import java.io.FileNotFoundException;
import java.util.List;

import com.reconnect.model.City;
import com.reconnect.model.User;
import com.reconnect.model.UserLogin;

public interface UserDaoInterface {

	int loginValidation(UserLogin ul);

	int registerUserCity(City c);

	int registerUserCred(UserLogin ul);

	boolean checkEmailUnique(String email);

	boolean checkUsernameUniq(String username);

	int getUserId(String username);

	boolean registerUserDetail(User userDetails, int city_id, int cred_id) throws FileNotFoundException;

	User getUserDetailsByUsername(String username);

	List<User> getUserDetailsByName(String firstName, String lastName);

	List<User> getUserDetailsByCity(String city);

	List<User> getUserDetailsByState(String state);

	List<User> getUserDetailsByCountry(String country);

	User getUserDetailsById(int userId);

	List<User> getNonFriendsList(String username);

	User getUserDetailsByEmail(String email);
}
