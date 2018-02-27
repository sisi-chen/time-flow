package com.service;

import java.util.List;


import com.entity.User;

public interface PeopleService {
    public List<User> findById(String id);
    public int Update(String user_id,String user_name,String age,String sex,String Email);
}
