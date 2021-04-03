package com.jj.test;

import com.jj.bean.SUser;
import com.jj.bean.User;
import com.jj.service.SUserService;
import com.jj.service.UserService;
import com.jj.service.impl.SUserServiceImpl;
import com.jj.service.impl.UserServiceImlp;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {
    SUserService userService=new SUserServiceImpl();
    @Test
    public void registUser() {
        //userService.registUser(new User(null,"9dfjne","wqdfoekf","wjfoosd","wdijoef","12345"));

        userService.registUser(new SUser(null,"9dfjn4","wqdfoekf","wjfoosd","wdijoef","12345","",2));


    }

    @Test
    public void login() {
       System.out.println(userService.login(new SUser(null,"id3","123456","email@qq.com","vgrbvd","2132454","",1)));
    }

    @Test
    public void existsUsername() {
        if (userService.existsUsername("id4")){
            System.out.println("用户名存在！");
        }else {
            System.out.println("用户名可用！");
        }
    }
}