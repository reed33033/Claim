package com.mypackage.dao;

import com.mypackage.pojo.User;

public interface UserDao {
    public User queryOneUser(User user);
    public int insertUser(User user);
}
