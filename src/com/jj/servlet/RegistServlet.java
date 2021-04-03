package com.jj.servlet;

import com.jj.bean.User;
import com.jj.service.UserService;
import com.jj.service.impl.UserServiceImlp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistServlet extends HttpServlet {

    private UserService userService=new UserServiceImlp();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding( "utf-8" );
        resp.setContentType( "/pages/user/regist_success.jsp;charset=utf-8" );
        //获取请求参数
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        String email=req.getParameter("email");
        String address=req.getParameter("address");
        String phone=req.getParameter("phone");


        //检查用户名是否可用
        if (userService.existsUsername(username)){
            System.out.println("用户名["+username+"]已存在！");
            req.setAttribute("rst","用户名已存在！");
            req.setAttribute("username",username);
            req.setAttribute("email",email);


            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
        }else {
            //if ()
            //可用
            userService.registUser(new User(null,username,password,email,address,phone));

            req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req,resp);
        }

    }
}
