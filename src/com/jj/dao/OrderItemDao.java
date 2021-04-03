package com.jj.dao;

import com.jj.bean.OrderItem;

import java.util.List;

public interface OrderItemDao {
    public int saveOrderItem(OrderItem orderItem);
    /***
     * 根据订单号查询订单
     * @param orderId 订单号
     * @return 订单列表
     */
    List<OrderItem> queryOrderItemByOrderId(String orderId);
}
