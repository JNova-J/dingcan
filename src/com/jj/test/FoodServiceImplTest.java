package com.jj.test;

import com.jj.bean.Food;
import com.jj.bean.Page;
import com.jj.bean.SUser;
import com.jj.service.FoodService;
import com.jj.service.impl.FoodServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class FoodServiceImplTest {
    private FoodService foodService =new FoodServiceImpl();


    @Test
    public void deleteFoodById() {
        foodService.deleteFoodById(5);

    }

    @Test
    public void updateFood() {
        foodService.updateFood(new Food(29,"五谷丰登八宝鸭","本帮菜馆",new BigDecimal(288),99,0,null,3));
    }

    @Test
    public void queryFoodById() {
        System.out.println(foodService.queryFoodById(3));
    }

    @Test
    public void queryFoods() {
        for (Food queryFood : foodService.queryFoods()) {
            System.out.println(queryFood);

        }
    }


    @Test
    public void page(){
        System.out.println(foodService.page(3, Page.PAGE_SIZE));
    }
    @Test
    public void page2() {
        System.out.println(foodService.page(1, Page.PAGE_SIZE));
    }



    @Test
    public void pageByPrice(){
        System.out.println(foodService.pageByPrice(1, Page.PAGE_SIZE,10,50));
    }
}