package com.service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Album;
import com.entity.Image;
import com.entity.dynamic;
import com.dao.*;
import com.service.*;

@Service
public class ImageServiceImpl implements ImageService{
	@Autowired
	private ImageDao imagedao;

	@Override
	public void save(Image image) {
		imagedao.save(image);	
	}
	
	public void save(Album album){
		
		imagedao.save(album);
	}

	@Override
	public int countImage(String user_id,String album_name) {
		int rows = imagedao.countImage(user_id,album_name);
		return rows;
	}
	
	@Override
	public int countAlbum(String user_id) {
		int rows = imagedao.countAlbum(user_id);
		return rows;
	}

    public void save(dynamic dy){
		
		imagedao.save(dy);
	}
}
