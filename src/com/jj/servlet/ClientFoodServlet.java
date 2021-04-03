package com.jj.servlet;

import com.jj.bean.Food;
import com.jj.bean.Page;
import com.jj.service.FoodService;
import com.jj.service.impl.FoodServiceImpl;
import com.jj.utils.Utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClientFoodServlet extends BaseServlet{

    private FoodService foodService=new FoodServiceImpl();
    private Food food =new Food();
    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 1.获取请求参数 pageNo 和 pageSize
        int pageNo = Utils.parseInt(request.getParameter("pageNo"),1);
        int pageSize = Utils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);

        Page<Food> page = foodService.page(pageNo, pageSize);

        page.setUrl("client/foodServlet?action=page");

        // 3.保存 page 对象到 Request 域中
        request.setAttribute("page",page);
        request.getRequestDispatcher("/pages/client/index.jsp").forward(request,response);

    }

    /**
     * 根据价格分页
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void pageByPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.获取请求参数 pageNo 和 pageSize
        int pageNo = Utils.parseInt(request.getParameter("pageNo"),1);
        int pageSize = Utils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        int min = Utils.parseInt(request.getParameter("min"),0);
        int max = Utils.parseInt(request.getParameter("max"),Integer.MAX_VALUE);


        // 2.调用 FoodService.pageByPrice(pageNo, pageSize, min, max) : 返回 page 对象
        Page<Food> page = foodService.pageByPrice(pageNo, pageSize, min, max);

        StringBuilder sb = new StringBuilder("client/foodServlet?action=pageByPrice");

        // 如果有最小价格的参数，追加到分页条的地址参数中
        if (request.getParameter("min") != null) {
            sb.append("&min=").append(request.getParameter("min"));
        }
        // 如果有最大价格的参数，追加到分页条的地址参数中
        if (request.getParameter("max") != null) {
            sb.append("&max=").append(request.getParameter("max"));
        }

        page.setUrl(sb.toString());

        // 3.保存 page 对象到 Request 域中
        request.setAttribute("page",page);
        // 4.请求转发到 pages/manager/food_manager.jsp 页面
        request.getRequestDispatcher("/pages/client/index.jsp").forward(request,response);
    }
}
