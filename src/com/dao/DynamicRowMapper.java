package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.entity.dynamic;

public class DynamicRowMapper implements RowMapper {
	@Override
	public Object mapRow(ResultSet rs, int arg1) throws SQLException {
		
		dynamic dy=new dynamic();
		
		dy.setNews_id(rs.getString("news_id"));
		dy.setUser_id(rs.getString("user_id"));
		dy.setMessage(rs.getString("message"));
		dy.setUrl(rs.getString("url"));
		
		return dy;
	}

}
