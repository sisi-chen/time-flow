package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.entity.Album;
import com.entity.Friend;
import com.entity.User;
import com.entity.UserCheck;

public class SocialImplement  implements SocialDao{
	@Autowired
	protected JdbcTemplate jdbcTemplate;
	
	
	//返回用户好友列表
	@Override
	public List<Friend> show(String requestId) {
		String sql="select * from friend where requestId=?";
		List<Friend>  rows=jdbcTemplate.query(sql,new Object[]{requestId},new FriendRowMapper());
		return rows;
	}
	
	
	//返回好友数量
	@Override
	public int countFriend(String requestId) {
		String sql="select count(*) from friend where requestId=?";
		int i=jdbcTemplate.queryForObject(sql,new Object[]{requestId},Integer.class);
		return i;
	}
	@Override
	public int check(String id)
	{
	   String sql="select count(*) from user where user_id=?";
		int i=jdbcTemplate.queryForObject(sql,new Object[]{id},Integer.class);
		return i;
	}
	
	
	//经过2次判断后，添加好友
	public void addFriend(Friend friend)
	{
		String sql="insert into friend  values (?,?,?,?)";
		jdbcTemplate.update(sql,friend.getRequestId(),friend.getRequestName(),friend.getFriendId(),friend.getFriendName());
	}
	
	
	
	
	//判断用户表是否有这个人,有的话就返回部分信息
	@Override
	public User checkPeople(String user_id) {
		
		String sql="select user_id,user_name from user where user_id=?";
		User   user=(User)jdbcTemplate.queryForObject(sql,new Object[]{user_id},new checkFriendRowMapper());
		
		return user;
	}
	
	//判断是否已经是朋友
	@Override
	public String checkFriend(String user_id,String friendId) {
		 String sql="select count(*) from friend where requestId=? and friendId=? "; 
		  int friend=jdbcTemplate.queryForObject(sql,new Object[]{user_id,friendId},Integer.class);
		 String s="true";
		 if(friend==0)
		 {
			 return "success";
		 }
		 return "false";
	}


	@Override
	public boolean deleteFriend(String friendId) {
		String sql="delete from friend where friendID=?";
		 jdbcTemplate.update(sql,friendId);
		 return true;
	}
}





