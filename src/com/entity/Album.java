package com.entity;

public class Album {
	private String type;
	private String url;
	private String album_name;
	private String user_id;
	public  String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
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
