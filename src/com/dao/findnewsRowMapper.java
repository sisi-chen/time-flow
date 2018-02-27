package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.entity.news;

public class findnewsRowMapper implements RowMapper{

public Object mapRow(ResultSet rs, int arg1) throws SQLException {
		
		news ns=new news();
		ns.setNews_id(rs.getString("news_id"));
		ns.setUser_id(rs.getString("user_id"));
		ns.setNews(rs.getString("news"));
		return ns;
	}
}
