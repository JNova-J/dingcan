package com.jj.service.impl;

import com.jj.bean.SUser;
import com.jj.dao.SUserDao;
import com.jj.dao.impl.SUserDaoImpl;
import com.jj.service.SUserService;

public class SUserServiceImpl implements SUserService {

    // 在suserService中保存一个dao的引用。用来操作数据库
    private SUserDao userDao=new SUserDaoImpl();


    @Override
    public SUser login(SUser suser) {
        // 调用userdao操作数据库查找用户信息
        return userDao.queryUserByUsernameAndPassword(suser.getUsername(),suser.getPassword());

    }

    @Override
    public void registUser(SUser suser){
        userDao.saveUser(suser);

    }

    @Override
    public boolean existsUsername(String username) {
        // 调用userdao根据用户名搜索用户信息
        SUser suser = userDao.queryUserByUsername(username);
        // 如果用户不存，则返回false
        if (suser == null) {
            return false;
        }
        // 用户存在，返回true
        return true;
    }
}
