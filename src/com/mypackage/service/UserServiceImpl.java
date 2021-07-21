package com.mypackage.service;

import com.mypackage.dao.UserDao;
import com.mypackage.dao.UserDaoImpl;
import com.mypackage.pojo.User;

public class UserServiceImpl implements UserService{

    private UserDao userDao=new UserDaoImpl();

    @Override
    public User login(User user) {
        return userDao.queryOneUser(user);
    }

    @Override
    public boolean register(User user) {
        int row = userDao.insertUser(user);
        if(row>0){
            return true;
        }
        return false;
    }
}
