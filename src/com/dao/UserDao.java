package com.dao;

import com.entity.UserCheck;
import com.entity.User;

public interface  UserDao {
	public void add(User user);
	public UserCheck findByName(String account);
	public User forget(String user_id);
}
