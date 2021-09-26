package com.reconnect.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.reconnect.dao.util.BlockUserDaoInterface;
import com.reconnect.dao.util.UserDaoInterface;
import com.reconnect.factory.UserDAOFactory;
import com.reconnect.model.User;
import com.reconnect.utility.DBUtils;

public class BlockedUsersDao implements BlockUserDaoInterface {

	Connection conn = null;
	UserDaoInterface userDao = null;
	int userId=0;

	public BlockedUsersDao() {
		userDao = UserDAOFactory.createUserDaoObject();
		conn = DBUtils.getConnection();
	}

	//Deletes the entry from friends table when the user is blocked.
	@Override
	public boolean removeFromFriend(int userId, int userBlockedId) {
		PreparedStatement pstmt = null;
		String sql = "delete from friend_details where (friend_one=? and friend_two=? and status=1) or (friend_one=?  and friend_two=? and status=1)";
		try {
			pstmt = conn.prepareStatement(sql);
			//Since the blocked user can be friend one or two(user who sent the request or accepted).
			pstmt.setInt(1, userId);
			pstmt.setInt(2, userBlockedId);
			pstmt.setInt(3, userBlockedId);
			pstmt.setInt(4, userId);
			int rs = pstmt.executeUpdate();
			if (rs > 0) {
				return true;
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
		return false;
	}

	//Blocks a user. Check the entry of blocked by user and blocked who user in the table
	@Override
	public boolean blockUser(String blockedBy, String blockedWho) {
		PreparedStatement pstmt = null;
		userId = userDao.getUserId(blockedBy);
		int userBlockedId = userDao.getUserId(blockedWho);
		String sql = "insert into blocked_user(blocked_by, blocked_who) values(?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userId);
			pstmt.setInt(1, userBlockedId);
			int rs = pstmt.executeUpdate();
			if (rs > 0 && removeFromFriend(userId, userBlockedId)) {
				return true;
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
		return false;
	}

	//Returns the list(user_id) of blocked users
	@Override
	public List<Integer> getUserBlockedList(int userId) {
		PreparedStatement pstmt = null;
		List<Integer> blockedList = new ArrayList<>();
		String sql = "select blocked_who from blocked_user where blocked_by=?";
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

	//Returns the details of blocked users according to the user_id.
	@Override
	public List<User> viewBlockedUsers(String username){
		userId = userDao.getUserId(username);
		List<Integer> blockedList = getUserBlockedList(userId);
		List<User> blockedUsersList = new ArrayList<>();
		for(int id: blockedList)
		{
			blockedUsersList.add(userDao.getUserDetailsById(id));
		}
		//System.out.println(blockedUsersList);
		return blockedUsersList;
	}

	//Unblocks a user (deletes the row from the blocked user table)
	@Override
	public boolean unblockUser(String blockedBy, String blockedWho) {
		PreparedStatement pstmt = null;
		userId = userDao.getUserId(blockedBy);
		int userBlockedId = userDao.getUserId(blockedWho);
		String sql = "delete from blocked_user where blocked_by = ? and blocked_who = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userId);
			pstmt.setInt(2, userBlockedId);
			int rs = pstmt.executeUpdate();
			if (rs > 0) {
				return true;
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
		return false;
	}

}