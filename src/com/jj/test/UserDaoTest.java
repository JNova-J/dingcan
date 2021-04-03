package com.jj.test;

import com.jj.bean.SUser;
import com.jj.bean.User;
import com.jj.dao.SUserDao;
import com.jj.dao.UserDao;
import com.jj.dao.impl.SUserDaoImpl;
import com.jj.dao.impl.UserDaoImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoTest {
    SUserDao userDao=new SUserDaoImpl();
    @Test
    public void queryUserByUsername() {

        if (userDao.queryUserByUsername("id7")==null) {
            System.out.println("用户名可用！");

        }else {
            System.out.println("用户名已存在！");
        }
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        if (userDao.queryUserByUsernameAndPassword("id8","10010101")==null){
            System.out.println("用户名或密码错误，登陆失败");
        }else {
            System.out.println("登陆成功");
        }

    }

    @Test
    public void saveUser() {
        System.out.println(userDao.saveUser(new SUser(null,"id10","10010101","","","1234567891012","",2)));
    }
}