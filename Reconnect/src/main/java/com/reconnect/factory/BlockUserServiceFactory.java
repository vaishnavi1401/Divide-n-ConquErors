package com.reconnect.factory;

import com.reconnect.service.UserBlockService;
import com.reconnect.service.UserBlockServiceInterface;

public class BlockUserServiceFactory {

	private BlockUserServiceFactory()
	{

	}
	public static UserBlockServiceInterface createObject() {

		return new UserBlockService();
	}

}
