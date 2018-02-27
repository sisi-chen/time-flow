package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.entity.Friend;

public class FriendRowMapper implements  RowMapper 
{


	@Override
	public Object mapRow(ResultSet rs, int arg1) throws SQLException {
		Friend friend=new Friend();
		friend.setFriendId(rs.getString("friendId"));
		friend.setFriendName(rs.getString("friendName"));
		friend.setRequestId(rs.getString("requestId"));
		friend.setRequestName(rs.getString("requestName"));
		System.out.println("在dao 的mapper中");
		System.out.println("请求者ID"+friend.getRequestId()+"请求者名字"+friend.getRequestName()+"好友ID"+friend.getFriendId()+"好友名字"+friend.getFriendName());
		return friend;
	}
}