package com.jj.dao.impl;

import com.jj.bean.SUser;
import com.jj.dao.SUserDao;

public class SUserDaoImpl extends BaseBao implements SUserDao {
    @Override
    public SUser queryUserByUsername(String susername) {

        String sql = "select `id`,`username`,`password`,`pusername`,`email`,`address`,`phone`,`role` from s_user where username=?";
        return queryOne(SUser.class,sql, susername);

    }

    @Override
    public SUser queryUserByUsernameAndPassword(String susername,String password) {

        String sql = "select `id`,`username`,`password`,`pusername`,`email`,`address`,`phone`,`role` from s_user where username=? and password=?";
        return queryOne(SUser.class,sql,susername,password);
    }

    @Override
    public SUser queryUserByUserid(Integer id) {
        String sql="select * from s_user where id=?";
        return queryOne(SUser.class,sql,id);
    }

    @Override
    public int saveUser(SUser suser) {
        // 要执行的sql

        String sql = "INSERT INTO s_user(username,password,pusername,email,address,phone,role) VALUES ( ?, ?, ?, ? ,?, ?, ?)";
        // 调用baseDaoImpl执行
        return update(sql, suser.getUsername(), suser.getPassword(),suser.getPusername(),
                suser.getEmail(),suser.getAddress(),suser.getPhone(),suser.getRole());
    }


}
