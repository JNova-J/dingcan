package com.jj.servlet;

import com.jj.bean.*;
import com.jj.service.OrderService;
import com.jj.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class OrderServlet extends BaseServlet{
    private OrderService orderService=new OrderServiceImpl();
//生成订单
    protected void createOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cart cart = (Cart) request.getSession().getAttribute("cart");
        SUser loginUser = (SUser) request.getSession().getAttribute("suser");
        if (loginUser == null) {
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
            //记得加 return ,不让执行下边代码
            return;
        }
        Integer userId = loginUser.getId();
        String address=loginUser.getAddress();
        String orderId=orderService.createOrder(cart,userId,address);

        request.getSession().setAttribute("orderId",orderId);
//重定向
        response.sendRedirect(request.getContextPath()+"/pages/cart/checkout.jsp");

    }
    /**
     * 查看我的订单
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void showMyOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SUser loginUser = (SUser) request.getSession().getAttribute("suser");
        //判断是否登陆
        if (loginUser == null) {
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
            //记得加 return ,不让执行下边代码
            return;
        }
        Integer userId = loginUser.getId();
        List<Order> myOrders = orderService.showMyOrders(userId);
//        System.out.println(myOrders.get(0).getCreateTime());
        request.setAttribute("myOrders", myOrders);
        request.getRequestDispatcher("/pages/order/order.jsp").forward(request, response);
    }

    /**
     * 查看订单详情
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void showOrderDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orderId = request.getParameter("orderId");
        List<OrderItem> orderItems = orderService.showOrderDetail(orderId);
        request.setAttribute("orderItems", orderItems);
        request.getRequestDispatcher("/pages/order/order_details.jsp").forward(request, response);
    }

    /**
     * 发货
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void sendOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orderId = request.getParameter("orderId");
        orderService.sendOrder(orderId);
        response.sendRedirect(request.getContextPath() + "orderServlet?action=showAllOrders");
    }

    /**
     * 查看所有订单
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void showAllOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Order> allOrders = orderService.showAllOrders();
        request.setAttribute("allOrders", allOrders);
        request.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(request, response);
    }

    /**
     * 签收订单
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void receiverOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SUser loginUser = (SUser) request.getSession().getAttribute("suser");
        //判断是否登陆
        if (loginUser == null) {
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
            //记得加 return ,不让执行下边代码
            return;
        }
        String orderId = request.getParameter("orderId");
        System.out.println("收货成功");
        orderService.receiverOrder(orderId);

        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

}
