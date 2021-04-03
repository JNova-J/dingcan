package com.jj.service;

import com.jj.bean.Food;
import com.jj.bean.Order;
import com.jj.bean.Page;
import com.jj.bean.SUser;

import java.util.List;

public interface FoodService {
    public void addFood(Food food, SUser sUser);

    public void deleteFoodById(Integer id);

    public void updateFood(Food food);

    public Food queryFoodById(Integer id);

    public List<Food> queryFoods();
    public List<Food> showMyFoods(Integer suid);


    Page<Food> page(int pageNo, int pageSize);

    Page<Food> page2(int pageNo, int pageSize,Integer suid);
    Page<Food> pageByPrice(int pageNo, int pageSize, int min, int max);
}
