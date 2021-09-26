
package com.reconnect.factory;

import com.reconnect.dao.FriendDao;
import com.reconnect.dao.util.FriendDaoInterface;




public class FriendDaoFactory {

	public static FriendDaoInterface createObj() {
		// TODO Auto-generated method stub
		return new FriendDao();
	}

}

