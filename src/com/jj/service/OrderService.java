package com.jj.service;

import com.jj.bean.Cart;
import com.jj.bean.Order;
import com.jj.bean.OrderItem;

import java.util.List;

public interface OrderService {
    public String createOrder(Cart cart,Integer userId,String address);
    /**
     * 查询全部订单
     * @return 订单列表
     */
    List<Order> showAllOrders();

    /**
     * 发货（修改订单 status 值）
     * @param orderId 订单编号
     */
    void sendOrder(String orderId);

    /**
     * 查看订单详情
     * @param orderId 订单编号
     * @return 订单项列表
     */
    List<OrderItem> showOrderDetail(String orderId);

    /**
     * 查看我的订单
     * @param userId 用户标号
     * @return 订单列表
     */
    List<Order> showMyOrders(Integer userId);

    /**
     * 签收订单/确认收获
     * @param orderId 用户编号
     */
    void receiverOrder(String orderId);

}
