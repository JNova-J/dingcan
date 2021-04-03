package com.jj.servlet;

import com.jj.bean.SUser;
import com.jj.service.SUserService;
import com.jj.service.impl.SUserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SRegistServlet extends HttpServlet {
    private SUserService suserService=new SUserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //解决中文乱码问题
        req.setCharacterEncoding( "utf-8" );
        resp.setContentType( "/pages/user/sregist_success.jsp;charset=utf-8" );
        //获取请求参数
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        String pusername=req.getParameter("pusername");
        String email=req.getParameter("email");
        String address=req.getParameter("address");
        String phone=req.getParameter("phone");

        if (suserService.existsUsername(username)){
            System.out.println("用户名["+username+"]已存在！");
            req.setAttribute("rst","用户名已存在！");
            req.setAttribute("username",username);
            req.setAttribute("email",email);
            req.getRequestDispatcher("/pages/user/Sregist.jsp").forward(req,resp);
        }else {
            suserService.registUser(new SUser(null,username,password,pusername,email,address,phone,2));
            req.getRequestDispatcher("/pages/user/sregist_success.jsp").forward(req,resp);
        }
    }
}
