package com.jj.dao.impl;

import com.jj.bean.Food;
import com.jj.bean.Order;
import com.jj.bean.SUser;
import com.jj.dao.FoodDao;

import java.util.List;

public class FoodDaoImpl extends BaseBao implements FoodDao {
    @Override
    public int addFood(Food food ,SUser sUser) {

        String sql = "insert into food(`name`,`price`,`sid`,`sales`,`stock`,`imgpath` imgPath,`suid`)values(?,?,?,?,?,?,?)";

        return update(sql,food.getName(),food.getPrice(),sUser.getPusername(),food.getSales(),food.getStock(),food.getImgPath(),sUser.getId());
    }

    @Override
    public int deleteFoodById(Integer id) {
        String sql="delete from food where id=?";
        return update(sql,id);
    }

    @Override
    public int updateFood(Food food) {
        String sql="update food set `name`=?,`price`=?,`sid`=?,`sales`=?,`stock`=?,`imgpath` imgPath =?,`suid`=? where id=?";
        return update(sql,food.getName(),food.getPrice(),food.getSid(),food.getSales(),food.getStock(),food.getImgPath(),food.getSuid(),food.getId());
    }

    @Override
    public Food queryFoodById(Integer id) {
        String sql="select `id`, `name`,`price`,`sid`,`sales`,`stock`,`imgpath` imgPath,`suid` from food where id=?";
        return queryOne(Food.class,sql,id);
    }
    @Override
    public Food queryFoodBySuid(Integer suid) {
        String sql="select `id`, `name`,`price`,`sid`,`sales`,`stock`,`imgpath` imgPath,`suid` from food where suid=?";
        return queryOne(Food.class,sql,suid);
    }

    @Override
    public List<Food> queryFoodsBySuid(Integer suid) {

        String sql = "select * from food where `suid` = ?";
        return queryList(Food.class,sql,suid);
    }

    @Override
    public List<Food> queryFoods() {

        String sql ="select `id`, `name`,`price`,`sid`,`sales`,`stock`,`imgpath` imgPath,`suid` from food";
        return queryList(Food.class,sql);
    }

    @Override
    public Integer queryForPageTotalCount() {
        String sql = "select count(*) from food";
        Number count = (Number) queryForSingleValue(sql);
        return count.intValue();
    }
    @Override
    public Integer queryForPageTotalCount2(Integer suid) {
        String sql = "select `suid`, count(1) as counts from food where `suid`=? ";
        Number count = (Number) queryForSingleValue(sql,suid);
        return count.intValue();
    }

    @Override
    public List<Food> queryForPageItems(int begin, int pageSize) {

        String sql="select `id`, `name`,`price`,`sid`,`sales`,`stock`,`imgpath` imgPath,`suid` from food limit ?,?";
        return queryList(Food.class,sql,begin,pageSize);
    }
    @Override
    public List<Food> queryForPageItems2(int begin, int pageSize,Integer suid) {

        String sql="select `id`, `name`,`price`,`sid`,`sales`,`stock`,`imgpath` imgPath,`suid` from food where suid=? limit ?,?  ";
        return queryList(Food.class,sql,suid,begin,pageSize);
    }

    @Override
    public Integer queryForPageTotalCountByPrice(int min, int max) {
        String sql = "select count(*) from food where price between ? and ?";
        Number count = (Number) queryForSingleValue(sql,min,max);
        return count.intValue();
    }

    @Override
    public List<Food> queryForPageItemsByPrice(int begin, int pageSize, int min, int max) {
        String sql="select `id`, `name`,`price`,`sid`,`sales`,`stock`,`imgpath` imgPath,`suid` from food where price between ? and ? order by price limit ?,?";
        return queryList(Food.class,sql,min,max,begin,pageSize);
    }
}
