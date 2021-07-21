package com.mypackage.service;

import com.mypackage.pojo.User;

public interface UserService {
    //登录
    public User login(User user);
    //注册
    public  boolean register(User user);
}
