package com.service;

import com.entity.LoginMessage;
import com.entity.User;
import com.entity.UserCheck;

public interface UserService {
    public String zhuce(User user);
    public String Login(UserCheck user);
    public User forget(String user_id);
}
