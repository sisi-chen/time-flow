package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dao.PeopleDao;
import com.dao.SocialDao;
import com.entity.Friend;
import com.entity.Page;
import com.entity.User;

@Controller
public class SocialContoller {
	@Autowired
	public SocialDao socialDao;
	@Autowired
	public PeopleDao peopledao;
	//��Ӻ���
	@RequestMapping("/addFriend.do")
	public ModelAndView addFriend(HttpServletRequest request ,HttpSession session)
	{	
		
		ModelAndView mav = new ModelAndView();
		String requestId=(String) session.getAttribute("user_id");
		String friendId=request.getParameter("friendId");
		//����û����Ƿ��������,�����Ƿ��Ѿ��Ǻ���
		
		 String s=socialDao.checkFriend(requestId, friendId);
		 int num=socialDao.check(friendId);
		 if(num==0)
		 {
			 mav.setViewName("/none");
			 return mav;
		 }
		 
		 else if(s.equals("false"))
		 {
			 mav.setViewName("/false");
			 return mav;
		 }
		 //�������������
		 User friend=socialDao.checkPeople(friendId);
		 User requestUser=socialDao.checkPeople(requestId);
		 
		 
		 Friend myfriend=new Friend();
		 myfriend.setRequestId(requestId);
		 myfriend.setRequestName(requestUser.getUsername());
		 myfriend.setFriendId(friendId);
		 myfriend.setFriendName(friend.getUsername());
		
		 socialDao.addFriend(myfriend);
		 mav.setViewName("redirect:/showFriend.do");
		 return mav;
		 
	}
	
	
	//����ʾ���ѣ������з�ҳ
	@RequestMapping("/showFriend.do")
	public ModelAndView show(HttpServletRequest  request,Page page,HttpSession session)
	{
		String requestId=(String) session.getAttribute("user_id");
		List<Friend>  list=socialDao.show(requestId);
		

		ModelAndView mav = new ModelAndView();
		int totalpage = 0;//�ܹ���ҳ��
		int rows = socialDao.countFriend(requestId);//user_id �ͻ��ܼ�¼��
		
		//�ж��ܼ�¼����ÿҳ��ʾ����ȡ��   �㷨
	    if(rows%page.getPageSize() == 0){
		   totalpage=rows/page.getPageSize();//��ֵ����ҳ��
	    }else{
		   totalpage=rows/page.getPageSize()+1;
	    }
	   
		mav.addObject("totalpage", totalpage);
		mav.addObject("courentpage", page.getPage());//��ǰҳ��
		mav.addObject("list",list);
		mav.setViewName("/MyFriend");
		return mav;	
	}
	
	//��ת��������Ϣ����
	@RequestMapping("/friendMessage.do")
	public ModelAndView friendMessage(HttpSession session,HttpServletRequest request)	
	{
		ModelAndView mav=new ModelAndView();
		
		String friendId=request.getParameter("friendId");
		List<User> list=peopledao.findById(friendId);
	    mav.addObject("peopleList",list);
	    mav.setViewName("/friendMessage");
		return mav;
	}
	
	//�˴�����ɾ�����Ѳ����������������б����MyFriend
	@RequestMapping("/deleteFriend.do")
	public ModelAndView deleteFriend(HttpServletRequest request,HttpSession session)
	{
		ModelAndView mav=new ModelAndView();
		String friendId=request.getParameter("friendId");
		socialDao.deleteFriend(friendId);
		mav.setViewName("redirect:/showFriend.do");
		return mav;
	}
}



