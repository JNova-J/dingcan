package com.jj.dao.impl;

import com.jj.bean.User;
import com.jj.dao.UserDao;

public class UserDaoImpl extends BaseBao implements UserDao {

    @Override
    public User queryUserByUsername(String username) {
        //language=MySQL
        String sql = "select `id`,`username`,`password`,`email`,`address`,`phone` from u_user where username=?";
        return queryOne(User.class,sql, username);

    }

    @Override
    public User queryUserByUsernameAndPassword(String username,String password) {
        //language=MySQL
        String sql = "select `id`,`username`,`password`,`email`,`address`,`phone` from u_user where username=? and password=?";
        return queryOne(User.class,sql, username,password);
    }

    @Override
    public int saveUser(User user) {
        // 要执行的sql
        //language=MySQL
        String sql = "INSERT INTO u_user(username,password,email,address,phone) VALUES ( ?, ?, ?, ?, ?)";
        // 调用baseDaoImpl执行
        return update(sql, user.getUsername(), user.getPassword(),
                user.getEmail(),user.getAddress(),user.getPhone());
    }


}
