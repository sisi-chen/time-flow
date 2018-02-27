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
	
	
	//�����û������б�
	@Override
	public List<Friend> show(String requestId) {
		String sql="select * from friend where requestId=?";
		List<Friend>  rows=jdbcTemplate.query(sql,new Object[]{requestId},new FriendRowMapper());
		return rows;
	}
	
	
	//���غ�������
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
	
	
	//����2���жϺ���Ӻ���
	public void addFriend(Friend friend)
	{
		String sql="insert into friend  values (?,?,?,?)";
		jdbcTemplate.update(sql,friend.getRequestId(),friend.getRequestName(),friend.getFriendId(),friend.getFriendName());
	}
	
	
	
	
	//�ж��û����Ƿ��������,�еĻ��ͷ��ز�����Ϣ
	@Override
	public User checkPeople(String user_id) {
		
		String sql="select user_id,user_name from user where user_id=?";
		User   user=(User)jdbcTemplate.queryForObject(sql,new Object[]{user_id},new checkFriendRowMapper());
		
		return user;
	}
	
	//�ж��Ƿ��Ѿ�������
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





