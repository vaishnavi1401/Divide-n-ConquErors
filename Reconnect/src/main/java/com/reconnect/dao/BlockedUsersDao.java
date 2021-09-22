package com.reconnect.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.reconnect.model.User;
import com.reconnect.utility.DBUtils;
import com.reconnect.dao.util.UserDaoInterface;
import com.reconnect.factory.UserDAOFactory;

public class BlockedUsersDao {
	
	Connection conn = null;
	UserDaoInterface userDao = null;
	public BlockedUsersDao() {
		userDao = UserDAOFactory.createobject();
		conn = DBUtils.getConnection();
	}

	public List<Integer> getUserBlockedList(int userId) {
		PreparedStatement pstmt = null;
		List<Integer> blockedList = new ArrayList<Integer>();
		String sql = "select bu.blocked_who from blocked_user bu, user_details ud where ud.user_id=? and bu.blocked_by=ud.user_id";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				blockedList.add(rs.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return blockedList;
	}
	
	public List<User> viewBlockedUsers(String username){
		int userId = userDao.getUserId(username);
		List<Integer> blockedList = getUserBlockedList(userId);
		List<User> blockedUsersList = new ArrayList<User>();
		for(int id: blockedList) {
			blockedUsersList = userDao.getUserDetailsById(id);
		}
		return blockedUsersList;
	}
	
}
