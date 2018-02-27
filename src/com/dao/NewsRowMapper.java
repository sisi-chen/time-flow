package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.entity.dynamic;

public class NewsRowMapper implements RowMapper{

public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		dynamic dn=new dynamic();
		
		dn.setUser_id(rs.getString("user_id"));
		dn.setNews_id(rs.getString("news_id"));
		dn.setMessage(rs.getString("message"));
		dn.setUrl(rs.getString("url"));
		return dn;
		
	}
}
