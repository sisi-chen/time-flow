package com.dao;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.entity.User;

public interface PeopleDao {
    public List<User> findById(String username);
   public int Update(String user_id,String user_name,String age,String sex,String Email);
	
	
}
