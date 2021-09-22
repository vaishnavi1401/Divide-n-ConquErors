package com.reconnect.utility;

import com.reconnect.dao.CityDao;
import com.reconnect.dao.CityDaoInterface;

public class CityDaoFactory {

	private CityDaoFactory()
	{

	}
	public static CityDaoInterface createobject() {
		return new CityDao();
	}
}
