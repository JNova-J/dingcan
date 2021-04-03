package com.jj.service.impl;

import com.jj.bean.*;
import com.jj.dao.FoodDao;
import com.jj.dao.OrderDao;
import com.jj.dao.OrderItemDao;
import com.jj.dao.impl.FoodDaoImpl;
import com.jj.dao.impl.OrderDaoImpl;
import com.jj.dao.impl.OrderItemDaoImpl;
import com.jj.service.OrderService;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao =new OrderDaoImpl();
    private OrderItemDao orderItemDao=new OrderItemDaoImpl();
    private FoodDao foodDao = new FoodDaoImpl();
    @Override
    public String createOrder(Cart cart, Integer userId,String address) {
        //订单号唯一
        String orderId=System.currentTimeMillis()+""+userId;
        Order order =new Order(orderId,new Date(),cart.getTotalPrice(),0,userId,address);
        //保存订单
        orderDao.saveOrder(order);
        //遍历购物车中每个商品项转化为订单项保存到数据库
        for (Map.Entry<Integer, CartItem>entry:cart.getItems().entrySet()){
            //获取每个购物车中的商品项
            CartItem cartItem= entry.getValue();
            //转化为每一个订单项
            OrderItem orderItem =new OrderItem(null,cartItem.getName(),cartItem.getCount(),cartItem.getPrice(),cartItem.getTotalPrice(),orderId);
            //保存到数据库
            orderItemDao.saveOrderItem(orderItem);
            //更新库存和销量
            Food food =foodDao.queryFoodById(cartItem.getId());
            food.setSales(food.getSales()+cartItem.getCount());
            food.setStock(food.getStock()+cartItem.getCount());
        }

        //清空购物车
        cart.clear();
        return orderId;
    }

    @Override
    public List<Order> showAllOrders() {
        return orderDao.queryOrder();
    }

    @Override
    public void sendOrder(String orderId) {

        orderDao.changeOrderStatus(orderId,1);
    }

    @Override
    public List<OrderItem> showOrderDetail(String orderId) {
        return orderItemDao.queryOrderItemByOrderId(orderId);
    }

    @Override
    public List<Order> showMyOrders(Integer userId) {
        return orderDao.queryOrderByUserId(userId);
    }

    @Override
    public void receiverOrder(String orderId) {
        orderDao.changeOrderStatus(orderId,2);

    }
}
