package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.entity.Friend;
import com.entity.User;

public class checkFriendRowMapper implements  RowMapper 
{


	@Override
	public Object mapRow(ResultSet rs, int arg1) throws SQLException {
		User user=new User();
		user.setId(rs.getString("user_id"));
		user.setUsername(rs.getString("user_name"));
	
		
		return user;
	}
}