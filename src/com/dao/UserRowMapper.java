package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.entity.UserCheck;

public class UserRowMapper implements RowMapper{
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		
	
		UserCheck user= new UserCheck();
	    user.setId(rs.getString("user_id"));
	    user.setPassword(rs.getString("password"));
	    return user;		
	}

}
