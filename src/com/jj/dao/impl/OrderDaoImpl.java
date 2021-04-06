package com.jj.dao.impl;

import com.jj.bean.Order;
import com.jj.dao.OrderDao;

import java.util.List;

public class OrderDaoImpl extends BaseBao implements OrderDao {
    @Override
    public int saveOrder(Order order) {
        String sql="insert into f_order(orderId,createTime,price,status,userId,useraddress) values(?,?,?,?,?,?)";
        return update(sql,order.getOrderId(),order.getCreateTime(),order.getPrice(),order.getStatus(),order.getUserId(),order.getAddress());
    }

    @Override
    public List<Order> queryOrder() {
        String sql = "select `orderId`,`createTime`,`price`,`status`,`userId`,`useraddress` address from f_order " ;
        return queryList(Order.class, sql);
    }

    @Override
    public int changeOrderStatus(String orderId, Integer status) {
        String sql = "update f_order set `status` = ? where `orderId` = ?";
        return update(sql, status,orderId);
    }

    @Override
    public List<Order> queryOrderByUserId(Integer userId) {
        String sql = "select * from f_order where `userId` = ?";
        return queryList(Order.class,sql,userId);
    }
}
