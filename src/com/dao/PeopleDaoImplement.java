package com.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;


import com.entity.User;

public class PeopleDaoImplement implements PeopleDao {
	@Autowired
	protected JdbcTemplate jdbcTemplate;
	
	
	//显示个人用户信息
	@Override
	public List<User> findById(String username) {
		System.out.println("in DAO 111111111111");
		
		List<User> list=new ArrayList<User>();
		String sql="select user_id,user_name,sex,age,Email from user where user_id=?";
		List  rows=jdbcTemplate.queryForList(sql,username);
		Iterator iterator=rows.iterator();
		while(iterator.hasNext()){
			User people=new User();
			Map map=(Map)iterator.next();
				
		    people.setId((String)map.get("user_id"));
			people.setUsername((String)map.get("user_name"));
			people.setSex((String)map.get("sex"));
			people.setAge((String)map.get("age"));
			people.setEmail((String)map.get("Email"));
			  System.out.println(people.getId());
			  System.out.println(people.getUsername());
			  System.out.println(people.getAge());
		
			list.add(people);
		}
		 return list;
	}
	//更新个人信息
	@Override
	public int Update(String user_id,String user_name,String age,String sex,String Email) {
		 System.out.println("in dao and update ");
		 System.out.println(user_id+"--"+user_name+"--"+age+"--"+sex+"--"+Email);
		String sql="update user set user_name=?,age=?,sex=?,Email=? where user_id=?";  

			int row = jdbcTemplate.update(sql,user_name,age,sex,Email,user_id);

		    System.out.println("OK");
		    return row;
	}

	

}
