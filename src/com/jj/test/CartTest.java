package com.jj.test;

import com.jj.bean.Cart;
import com.jj.bean.CartItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CartTest {

    @Test
    public void addItem() {
        Cart cart =new Cart();
        cart.addItem(new CartItem(1,"黄焖鸡米饭",1,new BigDecimal(15),new BigDecimal(15)));
        cart.addItem(new CartItem(1,"黄焖鸡米饭",1,new BigDecimal(15),new BigDecimal(15)));

        cart.addItem(new CartItem(2,"黄焖鸡米饭(超大份)",1,new BigDecimal(45),new BigDecimal(45)));

        System.out.println(cart);
    }

    @Test
    public void deleteItem() {
        Cart cart =new Cart();
        cart.addItem(new CartItem(1,"黄焖鸡米饭",1,new BigDecimal(15),new BigDecimal(15)));
        cart.addItem(new CartItem(1,"黄焖鸡米饭",1,new BigDecimal(15),new BigDecimal(15)));

        cart.addItem(new CartItem(2,"黄焖鸡米饭(超大份)",1,new BigDecimal(45),new BigDecimal(45)));

        cart.deleteItem(1);
        System.out.println(cart);
    }

    @Test
    public void clear() {
        Cart cart =new Cart();
        cart.addItem(new CartItem(1,"黄焖鸡米饭",1,new BigDecimal(15),new BigDecimal(15)));
        cart.addItem(new CartItem(1,"黄焖鸡米饭",1,new BigDecimal(15),new BigDecimal(15)));

        cart.addItem(new CartItem(2,"黄焖鸡米饭(超大份)",1,new BigDecimal(45),new BigDecimal(45)));

        cart.deleteItem(1);
        cart.clear();
        System.out.println(cart);
    }

    @Test
    public void updateCount() {
        Cart cart =new Cart();
        cart.addItem(new CartItem(1,"黄焖鸡米饭",1,new BigDecimal(15),new BigDecimal(15)));
        cart.addItem(new CartItem(1,"黄焖鸡米饭",1,new BigDecimal(15),new BigDecimal(15)));

        cart.addItem(new CartItem(2,"黄焖鸡米饭(超大份)",1,new BigDecimal(45),new BigDecimal(45)));

        cart.deleteItem(1);

        cart.clear();
        cart.addItem(new CartItem(1,"黄焖鸡米饭",1,new BigDecimal(15),new BigDecimal(15)));
        cart.updateCount(1,10);
        System.out.println(cart);

    }
}