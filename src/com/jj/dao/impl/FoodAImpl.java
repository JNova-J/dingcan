package com.jj.dao.impl;

import com.jj.bean.Food;
import com.jj.bean.OrderItem;
import com.jj.dao.FoodA;
import com.jj.dao.FoodDao;

import java.util.List;

public class FoodAImpl extends BaseBao implements FoodA {
    @Override
    public int saveFood(Food food) {
        String sql = "insert into food(`name`,`price`,`sid`,`sales`,`stock`,`imgpath`,`suid`)values(?,?,?,?,?,?,?)";

        return update(sql,food.getName(),food.getPrice(),food.getSid(),food.getSales(),food.getStock(),food.getImgPath(),food.getSuid());

    }

    @Override
    public List<Food>queryFoodBySuid(Integer suid) {
        String sql="select * from food where suid=?";
        return queryList(Food.class,sql,suid);
    }
}
