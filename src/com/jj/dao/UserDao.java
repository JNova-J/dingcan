package com.jj.dao;


import com.jj.bean.User;

public interface UserDao {

    /**
     * 根据用户名查询用户信息;根据用户名和密码查询用户信息
     * @param username 用户名
     * @return 如果返回null，说明没有该用户
     */
    public User queryUserByUsername(String username);

    public User queryUserByUsernameAndPassword(String username,String password);
    /**
     * 保存用户信息
     * @param user
     * @return
     */
    public int saveUser(User user);
    
}
