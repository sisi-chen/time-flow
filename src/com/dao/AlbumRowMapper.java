package com.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import com.entity.Album;



public class AlbumRowMapper implements RowMapper{
	@Override
	public Object mapRow(ResultSet rs, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		Album album= new Album();
		album.setType(rs.getString("type"));
		album.setAlbumName(rs.getString("album_name"));
		album.setUserId(rs.getString("user_id"));
		album.setUrl(rs.getString("url"));
		return album;
	}

}
