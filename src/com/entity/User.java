package com.entity;

public class User {
		public String user_id;
	    public String password;
		public String user_name;
	    public String sex;
	    public String age;
	    public String Email;
	//工号的获取和初始化    
	    public String getId() {
	        return user_id;
	    }
	    public void setId(String id) {
	          this.user_id=id;
	    }
   //姓名的获取和初始化
	    public String getUsername() {
	        return user_name;
	    }
	    public void setUsername(String username) {
	        this.user_name = username;
	    }
   //密码的获取和初始化
	    public String getPassword() {
	        return password;
	    }
	    public void setPassword(String code) {
	        this.password= code;
	    }
  //性别的获取和初始化
	    public String getSex() {
	        return sex;
	    }
	    public void setSex(String sex) {
	        this.sex = sex;
	    }
  //年龄的获取和初始化  
	    public String getAge() {
	        return age;
	    }	   
	    public void setAge(String years) {
	         this.age=years;
	         
	    }
	    
	    public String getEmail(){ return Email;}
	    public void setEmail(String string)
	    {
	    	this.Email=string;
	    }


}
