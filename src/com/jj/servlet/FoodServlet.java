package com.jj.servlet;

import com.jj.bean.Food;
import com.jj.bean.Page;
import com.jj.bean.SUser;
import com.jj.bean.User;
import com.jj.service.FoodService;
import com.jj.service.impl.FoodServiceImpl;
import com.jj.utils.Utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class FoodServlet extends BaseServlet{

    private FoodService foodService=new FoodServiceImpl();
    private Food food=new Food();

    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 1.获取请求参数 pageNo 和 pageSize
        int pageNo = Utils.parseInt(request.getParameter("pageNo"),1);
        int pageSize = Utils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        SUser suser = (SUser) request.getSession().getAttribute("suser");
        System.out.println(suser);
        int usertype = suser.getRole();
        int userid = 0;
        if(usertype == 1){
            SUser loginUser= (SUser) request.getSession().getAttribute("suser");
            userid = loginUser.getId();
            Page<Food> page = foodService.page2(pageNo,pageSize,userid);
            System.out.println("已调用2");

            page.setUrl("manage/foodServlet?action=page");

            // 3.保存 page 对象到 Request 域中
            request.setAttribute("page",page);
            request.getRequestDispatcher("/pages/manager/food_manager.jsp").forward(request,response);
        }else{

            Page<Food> page = foodService.page(pageNo,pageSize);
            System.out.println("已调用1");

            page.setUrl("manage/foodServlet?action=page");
            // 3.保存 page 对象到 Request 域中
            request.setAttribute("page",page);
            request.getRequestDispatcher("/pages/manager/food_manager.jsp").forward(request,response);
        }


    }

    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int pageNo = Utils.parseInt(request.getParameter("pageNo"),0);
        pageNo += 1;
        Food food= Utils.copyParameterToBean(request.getParameterMap(),new Food());
        SUser sUser= (SUser) request.getSession().getAttribute("suser");
        foodService.addFood(food,sUser);
        response.sendRedirect(request.getContextPath() + "/manage/foodServlet?action=page2&action=page2&pageNo=" + pageNo);
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id=Utils.parseInt(request.getParameter("id"),0);

        foodService.deleteFoodById(id);

        response.sendRedirect(request.getContextPath()+"/manage/foodServlet?action=page&pageNo=" + request.getParameter("pageNo"));
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Food food=Utils.copyParameterToBean(request.getParameterMap(),new Food());
        foodService.updateFood(food);
        response.sendRedirect(request.getContextPath()+"/manage/foodServlet?action=page&pageNo=" + request.getParameter("pageNo"));
    }

    protected void getFood(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id=Utils.parseInt(request.getParameter("id"),0);
        Food food=foodService.queryFoodById(id);
        request.setAttribute("food",food);
        request.getRequestDispatcher("/pages/manager/food_edit.jsp").forward(request,response);

    }

    protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Food> foods = foodService.queryFoods();
        request.setAttribute("foods",foods);
        request.getRequestDispatcher("/pages/manager/food_manager.jsp").forward(request,response);



    }
}
