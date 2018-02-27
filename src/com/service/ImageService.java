package com.service;

import javax.servlet.http.HttpSession;

import com.entity.Album;
import com.entity.Image;
import com.entity.dynamic;

public interface ImageService {
	public void save(Image image);
	public void save(Album album);
	public int countImage(String user_id,String album_name);

	public int countAlbum(String user_id);
	public void save(dynamic dy);



}
