package com.jj.test;

import com.jj.bean.Cart;
import com.jj.bean.CartItem;
import com.jj.service.OrderService;
import com.jj.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class OrderServiceTest {
    OrderService orderService =new OrderServiceImpl();
    @Test
    public void createOrder() {
        Cart cart =new Cart();
        cart.addItem(new CartItem(1,"黄焖鸡米饭",1,new BigDecimal(15),new BigDecimal(15)));
        cart.addItem(new CartItem(2,"寿司军舰",1,new BigDecimal(10),new BigDecimal(10)));
        cart.addItem(new CartItem(3,"黄焖鸡米饭(超大份)",1,new BigDecimal(45),new BigDecimal(45)));


        System.out.println("订单号是："+orderService.createOrder(cart,1,null));
    }
    @Test
    public void showAllOrders() {
        System.out.println(orderService.showAllOrders());
    }

    @Test
    public void sendOrder() {
        orderService.sendOrder("161279182397311");
    }

    @Test
    public void showOrderDetail() {
        System.out.println(orderService.showOrderDetail("161279182397311"));
    }

    @Test
    public void showMyOrders() {
        System.out.println(orderService.showMyOrders(5));
    }

    @Test
    public void receiverOrder() {
        orderService.receiverOrder("16098572948421");
    }
}