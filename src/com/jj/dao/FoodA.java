package com.jj.dao;

import com.jj.bean.Food;


import java.util.List;

public interface FoodA {
    public int saveFood(Food food);
    /***
     * 根据商家号查询菜单
     * @param suid 商家号
     * @return 菜品列表
     */
    List<Food> queryFoodBySuid(Integer suid);
}
