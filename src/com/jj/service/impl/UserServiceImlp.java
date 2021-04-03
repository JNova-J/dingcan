package com.jj.service.impl;

import com.jj.bean.User;
import com.jj.dao.UserDao;
import com.jj.dao.impl.UserDaoImpl;
import com.jj.service.UserService;

public class UserServiceImlp implements UserService {

    // 在userService中保存一个dao的引用。用来操作数据库
    private UserDao userDao=new UserDaoImpl();


    @Override
    public User login(User user) {
        // 调用userdao操作数据库查找用户信息
        return userDao.queryUserByUsernameAndPassword(user.getUsername(),user.getPassword());

    }

    @Override
    public void registUser(User user){
        userDao.saveUser(user);

    }

    @Override
    public boolean existsUsername(String username) {
        // 调用userdao根据用户名搜索用户信息
        User user = userDao.queryUserByUsername(username);
        // 如果用户不存，则返回false
        if (user == null) {
            return false;
        }
        // 用户存在，返回true
        return true;
    }
}

