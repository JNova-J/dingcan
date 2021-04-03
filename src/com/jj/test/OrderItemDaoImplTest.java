package com.jj.test;

import com.jj.bean.OrderItem;
import com.jj.dao.OrderItemDao;
import com.jj.dao.impl.OrderItemDaoImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class OrderItemDaoImplTest {
    OrderItemDao orderItemDao =new OrderItemDaoImpl();
    @Test
    public void saveOrderItem() {

        orderItemDao.saveOrderItem(new OrderItem(null,"北京烤鸭",1,new BigDecimal(10),new BigDecimal(10),"1234567890"));
        orderItemDao.saveOrderItem(new OrderItem(null,"南京片皮鸭",1,new BigDecimal(10),new BigDecimal(10),"1234567890"));
        orderItemDao.saveOrderItem(new OrderItem(null,"酸菜鱼",1,new BigDecimal(10),new BigDecimal(10),"1234567890"));
    }

    @Test
    public void queryOrderItemByOrderId() {
        System.out.println(orderItemDao.queryOrderItemByOrderId("16145790720921"));
    }
}