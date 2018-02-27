package com.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.entity.Album;
import com.entity.Image;
import com.entity.Page;
import com.entity.User;
import com.entity.dynamic;
import com.entity.news;
public class ImageDaoImplement implements ImageDao {
	@Autowired
	protected JdbcTemplate jdbcTemplate;
	@Override
	//保存图片
	public void save(Image image)
	{
		String sql=" insert into t_image(name,album_name,user_id,url) values(?,?,?,?)";
		 jdbcTemplate.update(sql,image.getName(),image.getAlbumName(),image.getUserId(),image.getUrl());
	}
	//返回图片数量
	@Override
	public int countImage(String user_id,String album_name) {

		String sql="  select count(*) from t_image where user_id=? and album_name=? ";
		int i=jdbcTemplate.queryForObject(sql,new Object[]{user_id,album_name}, Integer.class);
		return i;
	}
	//显示图片。返回结果集
	@Override
	public List<Image> findImg(String user_id,String album_name) 
	{
		//List<Image> list=new ArrayList<Image>();
		String sql=" select * from t_image where user_id=? and album_name=?" ;
		List<Image>  rows=jdbcTemplate.query(sql,new Object[]{user_id,album_name},new ImageRowMapper());
		 return rows;
    };
    //删除图片
    @Override
    public void deleteImage(String user_id,String album_name,String name)
    {
    	String sql="delete from t_image  where user_id=? and album_name=? and name=?  " ;
    	jdbcTemplate.update(sql,user_id,album_name,name);
    }
    
    //保存相册
	@Override
	public void save(Album album) {

		String sql="insert into t_album (album_name,user_id,type,url)values(?,?,?,?)";
		jdbcTemplate.update(sql,album.getAlbumName(),album.getUserId(),album.getType(),album.getUrl());
	}
	
    
    
    //显示相册，返回结果集合
	@Override
	public List<Album> findAlbum(String user_id)
	{
		String sql=" select * from t_album  where user_id=?" ;
		List<Album>  rows=jdbcTemplate.query(sql,new Object[]{user_id},new AlbumRowMapper());
		return rows;
    };
	//计算相册数量
	@Override
	public int countAlbum(String user_id) {
		String sql=" select count(*) from t_album where user_id=?";
		int i=jdbcTemplate.queryForObject(sql,new Object[]{user_id},Integer.class);
		return i;
	}
	
	//删除相册
	@Override
	public void deleteAlbum(String user_id,String album_name) {
		String sql="delete from t_image where user_id=? and album_name=?";
		jdbcTemplate.update(sql,user_id,album_name);
		String sql2="delete from t_album where user_id=? and album_name=?";
		jdbcTemplate.update(sql2,user_id,album_name);
	}
	
	//更新相册数量
	@Override
	public void updateAlbum(String oldname,Album album)
	{		String sql;
			if(album.getUrl()==null)
			{
				sql="update t_album set album_name=?,type=? where album_name=? and user_id=?";
				jdbcTemplate.update(sql,album.getAlbumName(),album.getType(),oldname,album.getUserId());
			}
			else 
			{
				sql="update t_album set album_name=?,type=?,url=? where album_name=? and user_id=?";
				jdbcTemplate.update(sql,album.getAlbumName(),album.getType(),album.getUrl(),oldname,album.getUserId());
			}
	}
	
	public void save(dynamic dy)
    {
    	String sql="insert into dynamic (user_id,news_id,message,url) values(?,?,?,?)";
    	jdbcTemplate.update(sql,dy.getUser_id(),dy.getNews_id(),dy.getMessage(),dy.getUrl());
    }
	
	public List<dynamic> findDynamic()
    {
       String sql="select * from dynamic";
       List<dynamic> dy=jdbcTemplate.query(sql,new DynamicRowMapper());
       
       return dy;
    }
	
	public dynamic news(String news_id)
	{
		 String sql = "select * from dynamic where news_id=?"; 
		 dynamic dn=new dynamic();
		 dn=(dynamic)jdbcTemplate.queryForObject(sql,new Object[]{news_id},new NewsRowMapper());
		 return dn;
	}
	
	public void save(news ns)
    {
    	String sql="insert into news(news_id,user_id,news) values(?,?,?)";
    	
    	jdbcTemplate.update(sql,ns.getNews_id(),ns.getUser_id(),ns.getNews());
    }
	
	public List<news> findnews(String news_id)
    {
    	String sql="select * from news where news_id=?";
    	List<news> ns=jdbcTemplate.query(sql,new Object[]{news_id},new findnewsRowMapper());
    	return ns;
    }
}