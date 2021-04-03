package com.jj.dao;

import com.jj.bean.Food;
import com.jj.bean.Order;
import com.jj.bean.SUser;

import java.util.List;

public interface FoodDao {

    public int addFood(Food food,SUser sUser);
    public int deleteFoodById(Integer id);
    public int updateFood(Food food);
    public Food queryFoodById(Integer id);
    public Food queryFoodBySuid(Integer suid);
    public List<Food> queryFoods();

    List<Food> queryFoodsBySuid(Integer suid);

    Integer queryForPageTotalCount();

    Integer queryForPageTotalCount2(Integer suid);
    List<Food> queryForPageItems(int begin, int pageSize);

    List<Food> queryForPageItems2(int begin, int pageSize,Integer suid);
    Integer queryForPageTotalCountByPrice(int min, int max);

    List<Food> queryForPageItemsByPrice(int begin, int pageSize, int min, int max);
}
