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
		System.out.println("��dao ��mapper��");
		System.out.println("������ID"+friend.getRequestId()+"����������"+friend.getRequestName()+"����ID"+friend.getFriendId()+"��������"+friend.getFriendName());
		return friend;
	}
}