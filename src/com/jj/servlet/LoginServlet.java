package com.jj.servlet;


import com.jj.bean.SUser;
import com.jj.bean.User;
import com.jj.service.SUserService;
import com.jj.service.UserService;
import com.jj.service.impl.SUserServiceImpl;
import com.jj.service.impl.UserServiceImlp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private SUserService suserService=new SUserServiceImpl();


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       String username=request.getParameter("username");
       String password=request.getParameter("password");
       SUser loginUser = suserService.login(new SUser(null,username,password,null,null,null,null,1));
       if (loginUser == null){
           request.setAttribute("msg","用户名或密码错误");
           request.setAttribute("username",username);
           request.getRequestDispatcher("/pages/user/login.jsp").forward(request,response);
       }else {
           //保存用户登录之后的信息到session
           request.getSession().setAttribute("user",loginUser);
           request.getSession().setAttribute("userType",0);
           request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request,response);
       }

    }

}
