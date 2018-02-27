package com.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.entity.Album;
import com.entity.Image;
import com.entity.Page;
import com.entity.dynamic;
import com.entity.news;

public interface ImageDao {
	
	public void save(Image image);
	public List<Image> findImg(String user_id,String album_name);
	public int countImage(String user_id,String album_name);//数据的总记录数
	public void deleteImage(String user_id,String album_name,String name);
	
	public void save(Album album);
	public List<Album> findAlbum(String user_id);
	public int countAlbum(String user_id);
	public void deleteAlbum(String user_id,String album_name);
	public void updateAlbum(String oldname,Album album);
	
	public void save(dynamic dy);
	public List <dynamic> findDynamic();
    public dynamic news(String news_id);
    
    public void save(news ns);
    
    public List<news> findnews(String news_id);
    
    
}
