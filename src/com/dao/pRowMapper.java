package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.entity.User;

public class pRowMapper implements RowMapper<User> {

public User mapRow(ResultSet rs,int rowNum) throws SQLException {
		
		User u=new User();
		u.setEmail(rs.getString("Email"));
		u.setPassword(rs.getString("password"));
		return u;
	}
}
