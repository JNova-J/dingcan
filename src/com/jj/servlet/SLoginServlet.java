package com.jj.servlet;

import com.jj.bean.SUser;
import com.jj.bean.User;
import com.jj.service.SUserService;
import com.jj.service.UserService;
import com.jj.service.impl.SUserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private SUserService sUserService=new SUserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        SUser loginUser =  sUserService.login(new SUser(null,username,password,null,null,null,null,2));
        if (loginUser == null){
            request.setAttribute("msg","用户名或密码错误");
            request.setAttribute("username",username);
            request.getRequestDispatcher("/pages/user/Slogin.jsp").forward(request,response);
        }else {
            request.getSession().setAttribute("suser",loginUser);
            request.getSession().setAttribute("userType",1);
            request.getRequestDispatcher("/pages/user/Slogin_success.jsp").forward(request,response);
        }

    }
}
