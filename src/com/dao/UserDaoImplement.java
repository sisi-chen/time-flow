package com.dao;

import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.UserRowMapper;

import com.entity.UserCheck;
import com.entity.User;


@Repository
@Transactional
public  class UserDaoImplement implements UserDao {
	
	

	@Autowired
	protected JdbcTemplate jdbcTemplate;
	//用户帐号注册，添加用户
	@Override
	public void add(User user)
	{
	    String sql ="insert into User(user_id,password,user_name,sex,age,Email) values(?,?,?,?,?,?)"; 
	    jdbcTemplate.update(sql,user.getId(),user.getPassword(),user.getUsername(),user.getSex(),user.getAge(),user.getEmail());
	}
	
	
	//登陆时候，判断是否有这个人
	@Override
	public UserCheck findByName(String account)
	{	
	 String sql = "select user_id,password from user where user_id=?"; 
	 UserCheck userCheck=(UserCheck) jdbcTemplate.queryForObject(sql,new Object[]{account},new UserRowMapper());
	 return userCheck;
	}
	public User forget(String user_id)
	{
		 String sql = "select Email,password from user where user_id=?";
		 User u=(User) jdbcTemplate.queryForObject(sql,new Object[]{user_id},new pRowMapper());
		 
		 return u;
	
	}
	
}
