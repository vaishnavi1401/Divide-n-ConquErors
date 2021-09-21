package com.reconnect.service;


import java.io.FileNotFoundException;

import com.reconnect.dao.UserDaoInterface;
import com.reconnect.model.City;
import com.reconnect.model.User;
import com.reconnect.model.UserLogin;
import com.reconnect.utility.UserDAOFactory;

public class UserService implements UserServiceInterface {

	public UserDaoInterface ud;
	
	public UserService(){
		
		ud=UserDAOFactory.createobject();
	}
<<<<<<< HEAD

=======
>>>>>>> cc174a9ec9a13a67307729cb0f865a2acaa732b9
	
	public int loginValidation(UserLogin ul) {
		
		return ud.loginValidation(ul);
	}

<<<<<<< HEAD
	
=======
>>>>>>> cc174a9ec9a13a67307729cb0f865a2acaa732b9
	public int registerUserCity(City c) {
		return ud.registerUserCity(c);
	}

<<<<<<< HEAD
	
=======
>>>>>>> cc174a9ec9a13a67307729cb0f865a2acaa732b9
	public int registerUserCred(UserLogin ul) {
		return ud.registerUserCred(ul);
	}

<<<<<<< HEAD
	
=======
>>>>>>> cc174a9ec9a13a67307729cb0f865a2acaa732b9
	public boolean checkEmailUnique(String email) {
		return ud.checkEmailUnique(email);
	}

<<<<<<< HEAD
	
	public boolean registerUserDetail(User usr, int city_id, int cred_id) {
		try {
			return ud.registerUserDetail(usr, city_id,cred_id);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
=======
	public boolean registerUserDetail(User usr, int city_id, int cred_id) throws FileNotFoundException {
		return ud.registerUserDetail(usr, city_id,cred_id);
>>>>>>> cc174a9ec9a13a67307729cb0f865a2acaa732b9
	}

}
