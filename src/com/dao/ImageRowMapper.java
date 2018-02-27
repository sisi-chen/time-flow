package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.entity.Image;

public class ImageRowMapper implements RowMapper{

	@Override
	public Object mapRow(ResultSet rs, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		Image img = new Image();
		img.setName(rs.getString("name"));
		img.setAlbumName(rs.getString("album_name"));
		img.setUserId(rs.getString("user_id"));
		img.setUrl(rs.getString("url"));
		return img;
	}

}
