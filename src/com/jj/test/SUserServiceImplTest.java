package com.jj.test;

import com.jj.bean.SUser;
import com.jj.bean.User;
import com.jj.dao.SUserDao;
import com.jj.dao.impl.SUserDaoImpl;
import com.jj.service.SUserService;
import com.jj.service.impl.SUserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class SUserServiceImplTest {
    SUserService sUserService=new SUserServiceImpl();
    @Test
    public void login() {
        System.out.println(sUserService.login(new SUser(null,"id8","10010101","grf","","","12345",2)));
    }

    @Test
    public void registUser() {
        sUserService.registUser(new SUser(null,"9dfjn4","wqdfoekf","wjfoosd","wdijoef","","12345",2));
    }

    @Test
    public void existsUsername() {
        if (sUserService.existsUsername("id4")){
            System.out.println("用户名存在！");
        }else {
            System.out.println("用户名可用！");
        }
    }
}