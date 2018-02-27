package com.dao;

import java.util.List;

import com.entity.Friend;
import com.entity.User;
import com.entity.UserCheck;

public interface SocialDao {
	public List<Friend> show(String requestId);
	public int countFriend(String requestId);
	public String checkFriend(String user_name,String friendName);
    public User checkPeople(String user_id);
	public void addFriend(Friend friend);
	public int check(String id);
	public boolean deleteFriend(String friendId);
}
