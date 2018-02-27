package com.service;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import com.dao.UserDao;
import com.entity.UserCheck;
import com.entity.LoginMessage;
import com.entity.User;

@Service
public  class UserServiceImplement implements UserService {
	
	@Resource
	private UserDao userDao;
	
	@Override
	public String zhuce(User user) {
		//UserCheck userCheck=new UserCheck();
		//userCheck=userDao.findByName(user.getNo());
		//if((userCheck.getNo().equals(user.user_id))&&(userCheck.getPassword().equals(user.password)))
		//{
		//	return "false";
		//}
		//else
		//{
			userDao.add(user);
			return "success";
		//}
	    
	}
	@Override
	public String Login(UserCheck user)
	{
		UserCheck userCheck=new UserCheck();
		userCheck=userDao.findByName(user.getId());
		if((userCheck.getId().equals(user.user_id))&&(userCheck.getPassword().equals(user.password)))
			return "success";
		else 
			return "false";
	}

	public User forget(String user_id)
	 {
		User u=new User();
		
		u=userDao.forget(user_id);
		
		return u;
	 }

}
