package com.entity;

public class User {
		public String user_id;
	    public String password;
		public String user_name;
	    public String sex;
	    public String age;
	    public String Email;
	//���ŵĻ�ȡ�ͳ�ʼ��    
	    public String getId() {
	        return user_id;
	    }
	    public void setId(String id) {
	          this.user_id=id;
	    }
   //�����Ļ�ȡ�ͳ�ʼ��
	    public String getUsername() {
	        return user_name;
	    }
	    public void setUsername(String username) {
	        this.user_name = username;
	    }
   //����Ļ�ȡ�ͳ�ʼ��
	    public String getPassword() {
	        return password;
	    }
	    public void setPassword(String code) {
	        this.password= code;
	    }
  //�Ա�Ļ�ȡ�ͳ�ʼ��
	    public String getSex() {
	        return sex;
	    }
	    public void setSex(String sex) {
	        this.sex = sex;
	    }
  //����Ļ�ȡ�ͳ�ʼ��  
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
