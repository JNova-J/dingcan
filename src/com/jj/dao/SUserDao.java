package com.jj.dao;

import com.jj.bean.SUser;

public interface SUserDao {

    /**
     * 根据用户名查询用户信息;根据用户名和密码查询用户信息
     * @param susername 用户名
     * @return 如果返回null，说明没有该用户
     */
    public SUser queryUserByUsername(String susername);

    public SUser queryUserByUsernameAndPassword(String susername,String password);

    public SUser queryUserByUserid(Integer id);

    /**
     * 保存用户信息
     * @param suser
     * @return
     */
    public int saveUser(SUser suser);


}

