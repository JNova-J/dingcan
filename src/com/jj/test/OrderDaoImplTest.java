package com.jj.test;

import com.jj.bean.Order;
import com.jj.dao.OrderDao;
import com.jj.dao.impl.OrderDaoImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

public class OrderDaoImplTest {
    OrderDao orderDao =new OrderDaoImpl();
    @Test
    public void saveOrder() {

        orderDao.saveOrder(new Order("12345678902",new Date(),new BigDecimal(100),0,1,"hyl"));
    }

    @Test
    public void queryOrder() {
        for (Order queryOrder : orderDao.queryOrder()) {
            System.out.println(queryOrder);
        }
    }

    @Test
    public void changeOrderStatus() {
        System.out.println(orderDao.changeOrderStatus("1234",1));
    }

    @Test
    public void queryOrderByUserId() {
        System.out.println(orderDao.queryOrderByUserId(5));
    }

}