package com.jj.test;

import com.jj.bean.SUser;
import com.jj.dao.SUserDao;
import com.jj.dao.impl.SUserDaoImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class SUserDaoTest {
    SUserDao userDao=new SUserDaoImpl();
    @Test
    public void queryUserByUsername() {
        if (userDao.queryUserByUsername("id1")==null) {
            System.out.println("用户名可用！");

        }else {
            System.out.println("用户名已存在！");
        }
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        if (userDao.queryUserByUsernameAndPassword("admin","16520")==null){
            System.out.println("用户名或密码错误，登陆失败");
        }else {
            System.out.println("登陆成功");
        }
    }

    @Test
    public void saveUser() {
        System.out.println(userDao.saveUser(new SUser(null,"id10","10010101","南昌","","青山湖12号","12345",2)));
    }
}