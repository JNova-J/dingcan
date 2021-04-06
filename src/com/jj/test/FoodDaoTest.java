package com.jj.test;

import com.jj.bean.Food;
import com.jj.bean.Page;
import com.jj.bean.SUser;
import com.jj.dao.FoodDao;
import com.jj.dao.impl.FoodDaoImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class FoodDaoTest {
    private FoodDao foodDao=new FoodDaoImpl();

    //@Test
   // public void addFood() {
    //    foodDao.addFood(new Food(null,"炸鸡全家桶",new BigDecimal(198),98,82,null),new SUser("kqzj",3));
   // }

    @Test
    public void deleteFoodById() {
        foodDao.deleteFoodById(2);
    }

    @Test
    public void updateFood() {
        foodDao.updateFood(new Food(41,"北京烤鸭2","空气炸鸡",new BigDecimal(198),98,82,null,3));
    }

    @Test
    public void queryFoodById() {
        System.out.println(foodDao.queryFoodById(2));
    }

    @Test
    public void queryFoodBySuid() {
        System.out.println(foodDao.queryFoodBySuid(1));
    }
    @Test
    public void queryFoods() {
        for(Food queryFood : foodDao.queryFoods()) {
            System.out.println(queryFood);
        }
    }

    @Test
    public void queryForPageTotalCount() {

        System.out.println(foodDao.queryForPageTotalCount());
    }
    @Test
    public void queryForPageTotalCount2() {

        System.out.println(foodDao.queryForPageTotalCount2(3));
    }

    @Test
    public void queryForPageItems() {
        for (Food food : foodDao.queryForPageItems(6, Page.PAGE_SIZE)) {
            System.out.println(food);
            
        }

        }
    @Test
    public void queryForPageItems2() {
        for (Food food : foodDao.queryForPageItems2(0, Page.PAGE_SIZE,3)) {
            System.out.println(food);

        }
    }
    @Test
    public void queryForPageTotalCountByPrice() {

        System.out.println(foodDao.queryForPageTotalCountByPrice(5,30));
    }

    @Test
    public void queryForPageItemsByPrice() {
        for (Food food : foodDao.queryForPageItemsByPrice(0, Page.PAGE_SIZE,10,30)) {
            System.out.println(food);

        }

    }
    @Test
    public void queryFoodsBySuid() {
        System.out.println(foodDao.queryFoodsBySuid(1));
    }
}