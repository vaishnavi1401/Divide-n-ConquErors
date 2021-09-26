
package com.reconnect.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.reconnect.dao.util.FriendDaoInterface;
import com.reconnect.model.User;
import com.reconnect.model.UserLogin;
import com.reconnect.utility.DBUtils;



public class FriendDao implements FriendDaoInterface {

	Connection conn = null;
	//CityDao cityDao = new CityDao();
	//LoginDao loginDao = new LoginDao();

	public FriendDao()

	{
		conn = DBUtils.getConnection();
	}



	@Override
	public int sendFriendRequest(UserLogin friend1,UserLogin friend2)
	{
		PreparedStatement pstmt = null;
		String sql="select ud.user_id from user_details ud,credentials c where c.username=? and  c.credential_id=ud.credential_id";
		String sql2="select ud.user_id from user_details ud,credentials c where c.username=? and  c.credential_id=ud.credential_id";
		try {

			int cred_id1 = 0,cred_id2 = 0;
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,friend1.getUserName());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{ cred_id1=rs.getInt(1);}


			pstmt=conn.prepareStatement(sql2);
			pstmt.setString(1,friend2.getUserName());
			ResultSet result = pstmt.executeQuery();
			if(result.next())
			{ cred_id2=result.getInt(1);}

			System.out.println("cred1: "+cred_id1+"\ncred2 : "+cred_id2);


			String sqlInsert="insert into friend_details values(?,?,?)";
			pstmt=conn.prepareStatement(sqlInsert);
			pstmt.setInt(1, cred_id1);
			pstmt.setInt(2, cred_id2);
			pstmt.setInt(3, 0);
			int status=pstmt.executeUpdate();


			return status;

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return 0;

	}

	@Override
	public int acceptFriendRequest(UserLogin friend1,UserLogin friend2)
	{
		PreparedStatement pstmt = null;
		String sql="select ud.user_id from user_details ud,credentials c where c.username=? and  c.credential_id=ud.credential_id";
		String sql2="select ud.user_id from user_details ud,credentials c where c.username=? and  c.credential_id=ud.credential_id";
		System.out.println("frnd 2 "+friend2.getUserName());
		try {

			int cred_id1 = 0,cred_id2 = 0;
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,friend1.getUserName());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{ cred_id1=rs.getInt(1);}


			pstmt=conn.prepareStatement(sql2);
			pstmt.setString(1,friend2.getUserName());
			ResultSet result = pstmt.executeQuery();
			if(result.next())
			{ cred_id2=result.getInt(1);}

			System.out.println("In accept Friend Req: cred1: "+cred_id1+"\ncred2 : "+cred_id2);


			String sqlUpdate="update friend_details set status=1 where friend_one=? and friend_two=?";
			pstmt=conn.prepareStatement(sqlUpdate);
			pstmt.setInt(1, cred_id2);
			pstmt.setInt(2, cred_id1);
			int status=pstmt.executeUpdate();

			System.out.println("executed "+ status);
			return status;

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return 0;

	}

	//select first_name,last_name,email_id,phone_no,gender,address,username from user_details ud,credentials c where c.username=? and  c.credential_id=ud.credential_id




	@Override
	public List<User> getPendingRequests(UserLogin friend)
	{
		List<User> pendingFriendRequests=new ArrayList<>();
		PreparedStatement pstmt = null;
		String sql="select user_id from user_details ud,credentials c where c.username=? and  c.credential_id=ud.credential_id";
		try {

			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,friend.getUserName());
			ResultSet rs = pstmt.executeQuery();
			int user_id = 0;
			if(rs.next())
			{ user_id=rs.getInt(1);}

			System.out.println("User_id: "+user_id);
			String sql2="select friend_one,friend_two from friend_details where friend_two=? and status=0 ";
			pstmt=conn.prepareStatement(sql2);
			pstmt.setInt(1, user_id);
			/* pstmt.setInt(2, user_id); */
			rs=pstmt.executeQuery();
			List<Integer> friendIds=new ArrayList<>();
			while(rs.next())
			{

				int friend1=rs.getInt(1);
				int friend2=rs.getInt(2);
				System.out.println(friend1+" requested--> "+friend2);
				if(friend1==user_id)
				{
					friendIds.add(friend2);
				}
				else
				{
					friendIds.add(friend1);
				}
			}

			System.out.println(friendIds.toString());

			pstmt = null;
			sql="select first_name,last_name,email_id,phone_no,gender,address,username from user_details ud,credentials c where ud.user_id=? and ud.credential_id=c.credential_id";


			for(int frnd :friendIds)
			{
				//System.out.println(frnd);
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, frnd);
				ResultSet resultSet=pstmt.executeQuery();
				while(resultSet.next())
				{
					User user=new User();
					user.setFname(resultSet.getString(1));
					user.setLname(resultSet.getString(2));
					user.setEmail(resultSet.getString(3));
					user.setPhone(resultSet.getString(4));
					user.setGender(resultSet.getString(5));
					user.setAddress(resultSet.getString(6));
					user.setUsername(resultSet.getString(7));
					String username=(resultSet.getString(7));
					System.out.println(user.getFname()+" uname: "+username);
					pendingFriendRequests.add(user);
				}

			}

			return pendingFriendRequests;
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;

	}



	//View all friends

	@Override
	public List<User> getFriends(UserLogin friend)
	{
		List<User> pendingFriendRequests=new ArrayList<>();
		PreparedStatement pstmt = null;
		String sql="select user_id from user_details ud,credentials c where c.username=? and  c.credential_id=ud.credential_id";
		try {

			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,friend.getUserName());
			ResultSet rs = pstmt.executeQuery();
			int user_id = 0;
			if(rs.next())
			{ user_id=rs.getInt(1);}

			System.out.println("User_id: "+user_id);
			String sql2="select friend_one,friend_two from friend_details where (friend_one=? or friend_two=?) and status=1 ";
			pstmt=conn.prepareStatement(sql2);
			pstmt.setInt(1, user_id);
			pstmt.setInt(2, user_id);
			rs=pstmt.executeQuery();
			List<Integer> friendIds=new ArrayList<>();
			while(rs.next())
			{

				int friend1=rs.getInt(1);
				int friend2=rs.getInt(2);
				System.out.println(friend1+" sent request to --> "+friend2);
				if(friend1==user_id)
				{
					friendIds.add(friend2);
				}
				else
				{
					friendIds.add(friend1);
				}
			}

			System.out.println(friendIds.toString());

			pstmt = null;
			sql="select first_name,last_name,email_id,phone_no,gender,address,username from user_details ud,credentials c where ud.user_id=? and ud.credential_id=c.credential_id";


			for(int frnd :friendIds)
			{
				//System.out.println(frnd);
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, frnd);
				ResultSet resultSet=pstmt.executeQuery();
				while(resultSet.next())
				{
					User user=new User();
					user.setFname(resultSet.getString(1));
					user.setLname(resultSet.getString(2));
					user.setEmail(resultSet.getString(3));
					user.setPhone(resultSet.getString(4));
					user.setGender(resultSet.getString(5));
					user.setAddress(resultSet.getString(6));
					user.setUsername(resultSet.getString(7));
					String username=(resultSet.getString(7));
					System.out.println("View Friends: "+user.getFname()+" uname: "+username);
					pendingFriendRequests.add(user);
				}

			}

			return pendingFriendRequests;
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;

	}




	@Override
	public int removeFriend(UserLogin friend1,UserLogin friend2)
	{
		PreparedStatement pstmt = null;
		String sql="select ud.user_id from user_details ud,credentials c where c.username=? and  c.credential_id=ud.credential_id";
		String sql2="select ud.user_id from user_details ud,credentials c where c.username=? and  c.credential_id=ud.credential_id";
		try {

			int cred_id1 = 0,cred_id2 = 0;
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,friend1.getUserName());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{ cred_id1=rs.getInt(1);}


			pstmt=conn.prepareStatement(sql2);
			pstmt.setString(1,friend2.getUserName());
			ResultSet result = pstmt.executeQuery();
			if(result.next())
			{ cred_id2=result.getInt(1);}

			System.out.println("In remove Friend : cred1: "+cred_id1+"\ncred2 : "+cred_id2);


			String sqlUpdate="delete from friend_details where (friend_one=? and friend_two=? and status=1) or (friend_one=?  and friend_two=? and status=1)";
			pstmt=conn.prepareStatement(sqlUpdate);
			pstmt.setInt(1, cred_id1);
			pstmt.setInt(2, cred_id2);
			pstmt.setInt(3, cred_id2);
			pstmt.setInt(4, cred_id1);
			int status=pstmt.executeUpdate();

			System.out.println("executed "+ status);
			return status;

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return 0;

	}


	@Override
	public int ignoreRequest(UserLogin friend1,UserLogin friend2)
	{
		PreparedStatement pstmt = null;
		String sql="select ud.user_id from user_details ud,credentials c where c.username=? and  c.credential_id=ud.credential_id";
		String sql2="select ud.user_id from user_details ud,credentials c where c.username=? and  c.credential_id=ud.credential_id";
		try {

			int cred_id1 = 0,cred_id2 = 0;
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,friend1.getUserName());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{ cred_id1=rs.getInt(1);}


			pstmt=conn.prepareStatement(sql2);
			pstmt.setString(1,friend2.getUserName());
			ResultSet result = pstmt.executeQuery();
			if(result.next())
			{ cred_id2=result.getInt(1);}

			System.out.println("In accept Friend Req: cred1: "+cred_id1+"\ncred2 : "+cred_id2);


			String sqlUpdate="delete from friend_details where friend_one=? and friend_two=? and status=0";
			pstmt=conn.prepareStatement(sqlUpdate);
			pstmt.setInt(1, cred_id2);
			pstmt.setInt(2, cred_id1);
			int status=pstmt.executeUpdate();

			System.out.println("executed "+ status);
			return status;

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return 0;

	}






}

