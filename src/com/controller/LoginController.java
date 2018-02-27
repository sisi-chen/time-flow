package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dao.UserDao;
import com.entity.LoginMessage;
import com.entity.User;
import com.entity.UserCheck;
import com.service.PeopleService;
import com.service.UserService;



@Controller
public class LoginController {
	@Autowired
	public UserService userService;
	@Autowired
	public PeopleService peopleService;
	User user=new User();
    UserCheck userCheck=new UserCheck();
	@RequestMapping("/")
	public String index(){
		return "login";
	}

	//用户的注册
	@RequestMapping("/register.do")
	public  String zhucePro(String user_id,String sex,String user_name,String password,String age,String Email){
		
		user.setId(user_id);
		user.setPassword(password);
		user.setUsername(user_name);
		user.setAge(age);
		user.setSex(sex);
		user.setEmail(Email);
		
		
	    String s=userService.zhuce(user);
	    if(s.equals("success"))
	    return "login";
	    else 
	    	return "false";
	}
	

	
	//登陆
	@RequestMapping("/login_do")
	public String Login(String user_id,String password,HttpSession  session)
	{
	  
	    userCheck.setId(user_id);
	    userCheck.setPassword(password);
	    String addre=userService.Login(userCheck);
	     if(addre.equals("success"))
	     {  
	    	 if(!session.isNew())
	    	 {
	    			session.setAttribute("user_id",userCheck.getId());
	    			session.setAttribute("password",userCheck.getPassword());
	    	 }
	        return "index";
	      }
	     
	     else 
	    	 if(addre.equals("false"))
	    	 return "login";
		return "login";
	
	}
	
	

	//把登陆者信息显示到个人信息页面
	@RequestMapping("/PersonMessage")
	public String findByName(Model model2)	
	{
	
		List<User> list=peopleService.findById(userCheck.getId());
		
		  int i;
		  for(i=0;i<list.size();i++)
		  {	 
			  model2.addAttribute("peopleList",list);
			  
		  }
		  return "PersonMessage";
	}
	
	//修改个人信息
	@RequestMapping("/Update")
	public String Update(String user_name,String age,String sex,String Email)
	{
		
		  int i=peopleService.Update(userCheck.getId(),user_name,age,sex,Email);
		  if(i>0)
		      return "index";
		  else
			  return "login";
	}
	
	@RequestMapping("/forget.do")
	public ModelAndView forget(String user_id,String email)
	{
		ModelAndView mav=new ModelAndView();
		User u=new User();
		u=userService.forget(user_id);
		
		if(u.getEmail().equals(email))
		{
			mav.addObject("u",u.getPassword());
			mav.setViewName("/point");
			 return mav;
		}
		
		else{
			mav.setViewName("/f_password");
			return mav;	
		}
	}
	
	
	
	
}
