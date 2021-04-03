package com.jj.dao.impl;

import com.jj.bean.OrderItem;
import com.jj.dao.OrderItemDao;

import java.util.List;

public class OrderItemDaoImpl extends BaseBao implements OrderItemDao {
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql="insert into f_order_item(name,count,price,totalPrice,orderId) values(?,?,?,?,?)";
        return update(sql,orderItem.getName(),orderItem.getCount(),orderItem.getPrice(),orderItem.getTotalPrice(),orderItem.getOrderId());
    }

    @Override
    public List<OrderItem> queryOrderItemByOrderId(String orderId) {
        String sql ="select * from f_order_item where orderId=?";
        return queryList(OrderItem.class,sql,orderId);

    }
}
