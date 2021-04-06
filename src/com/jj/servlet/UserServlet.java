package com.jj.servlet;
import com.jj.bean.SUser;
import com.jj.service.SUserService;
import com.jj.service.impl.SUserServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

public class  UserServlet extends BaseServlet {

    private SUserService suserService = new SUserServiceImpl();

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
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        // 调用 userService.login()登录处理业务
        SUser loginUser = suserService.login(new SUser(null,username,password,null,null,null,null,null));
        // 如果等于 null,说明登录 失败!
        if (loginUser == null) {
            // 把错误的信息，和回显的表单项信息，保存到 Request 域中
            req.setAttribute("msg", "用户名或密码错误!");
            req.setAttribute("username", username);
            // 跳回登录页面
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        }
        else {
            // 登录 成功
            // 保存用户登陆后的信息到 Session 域中
            req.getSession().setAttribute("suser", loginUser);
            req.getSession().setAttribute("address",loginUser.getAddress());
            //跳到成功页面 login_success.jsp
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
        }
    }

    /**
     * 处理注册的功能
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        String email=req.getParameter("email");
        String address=req.getParameter("address");
        String phone=req.getParameter("phone");


        //检查用户名是否可用
        if (suserService.existsUsername(username)){
            System.out.println("用户名["+username+"]已存在！");
            req.setAttribute("rst","用户名已存在！");
            req.setAttribute("username",username);
            req.setAttribute("email",email);


            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
        }else {
            //if ()
            //可用
            suserService.registUser(new SUser(null,username,password,null,email,address,phone,0));

            req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req,resp);
        }

    }


    /**
     * 注销用户
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */

    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1、销毁 Session 中用户登录的信息（或者销毁 Session）
        req.getSession().invalidate();
        // 2、跳回登陆界面
        req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);

    }
}