package com.reconnect.service;

import com.reconnect.model.City;
import com.reconnect.model.User;
import com.reconnect.model.UserLogin;

public interface UserServiceInterface {

	int loginValidation(UserLogin ul);

	int registerUserCity(City c);

	int registerUserCred(UserLogin ul);

	boolean checkEmailUnique(String email);

	boolean registerUserDetail(User usr, int city_id, int cred_id);

}
