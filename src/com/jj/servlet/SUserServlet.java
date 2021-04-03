package com.jj.servlet;

import com.jj.bean.SUser;
import com.jj.bean.User;
import com.jj.service.SUserService;
import com.jj.service.impl.SUserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SUserServlet extends BaseServlet{
    private SUserService sUserService=new SUserServiceImpl();
    /**
     * 处理登陆的功能
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1、获取请求的参数
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        SUser loginUser =  sUserService.login(new SUser(null,username,password,null,null,null,null,1));
        if (loginUser == null){
            req.setAttribute("msg","用户名或密码错误");
            req.setAttribute("username",username);
            req.getRequestDispatcher("/pages/user/Slogin.jsp").forward(req,resp);
        }else {

            req.getSession().setAttribute("suser", loginUser);
            req.getSession().setAttribute("address",loginUser.getAddress());
            req.getRequestDispatcher("/pages/user/Slogin_success.jsp").forward(req,resp);
        }

    }


    protected void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        String pusername=req.getParameter("pusername");
        String email=req.getParameter("email");
        String address=req.getParameter("address");
        String phone=req.getParameter("phone");

        if (sUserService.existsUsername(username)){
            System.out.println("用户名["+username+"]已存在！");
            req.setAttribute("rst","用户名已存在！");
            req.setAttribute("username",username);
            req.setAttribute("email",email);
            req.getRequestDispatcher("/pages/user/Sregist.jsp").forward(req,resp);
        }else {
            sUserService.registUser(new SUser(null,username,password,pusername,email,address,phone,1));
            req.getRequestDispatcher("/pages/user/sregist_success.jsp").forward(req,resp);
        }

    }

    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1、销毁 Session 中用户登录的信息（或者销毁 Session）
        req.getSession().invalidate();
        // 2、跳回登陆界面
        req.getRequestDispatcher("/pages/user/Slogin.jsp").forward(req, resp);

    }
}
