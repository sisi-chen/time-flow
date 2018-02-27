package com.entity;

public class Image {
	private String name;
	private String album_name;
	private String user_id;
	private String url;


	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAlbumName() {
		return album_name;
	}
	public void setAlbumName(String name) {
		this.album_name= name;
	}
	public String getUserId() {
		return user_id;
	}
	public void setUserId(String user_id) {
		this.user_id= user_id;
	}


}
