package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.dao.*;
import com.entity.User;
@Service
public class PeopleServiceImplement implements PeopleService {
	@Autowired
	private PeopleDao peopleDao;
	
	@Override
	public List<User> findById(String id) {
		System.out.println("in Service 111111111111");
		List<User> list = peopleDao.findById(id);
		System.out.println("in Service 22222222222");
		return list;
		
	}

	@Override
	public int Update(String user_id,String user_name,String age,String sex,String Email) {
		 System.out.println("in service and update ");
		 System.out.println(user_id+"--"+user_name+"--"+age+"--"+sex+"--"+Email);
		
		return peopleDao.Update(user_id,user_name,age,sex,Email);
	
	}

}
