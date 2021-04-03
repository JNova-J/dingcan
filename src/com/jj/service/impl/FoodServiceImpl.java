package com.jj.service.impl;

import com.jj.bean.Food;
import com.jj.bean.Page;
import com.jj.bean.SUser;
import com.jj.dao.FoodDao;
import com.jj.dao.impl.FoodDaoImpl;
import com.jj.service.FoodService;
import java.util.List;

public class FoodServiceImpl implements FoodService {

    private FoodDao foodDao = new FoodDaoImpl();
    private Food food=new Food();
    private SUser sUser=new SUser();

    @Override
    public void addFood(Food food,SUser sUser) {
        foodDao.addFood(food,sUser);

    }

    @Override
    public void deleteFoodById(Integer id) {
        foodDao.deleteFoodById(id);

    }

    @Override
    public void updateFood(Food food) {
        foodDao.updateFood(food);

    }

    @Override
    public Food queryFoodById(Integer id) {
        return foodDao.queryFoodById(id);
    }

    @Override
    public List<Food> queryFoods() {
        return foodDao.queryFoods();
    }

    @Override
    public List<Food> showMyFoods(Integer suid){return foodDao.queryFoodsBySuid(suid);}

    @Override
    public Page<Food> page(int pageNo, int pageSize) {
        Page<Food> page = new Page<Food>();

        // 设置当前页码
        page.setPageNo(pageNo);

        // 设置每页显示的数量
        page.setPageSize(pageSize);
        // 求总记录数
        Integer pageTotalCount = foodDao.queryForPageTotalCount();
        // 设置总记录数
        page.setPageTotalCount(pageTotalCount);
        // 求总页码
        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) {
            pageTotal += 1;
        }
        // 设置总页码
        page.setPageTotal(pageTotal);


        // 求当前页数据的开始索引
        int begin = (page.getPageNo() - 1) * pageSize;
        // 求当前页数据
        List<Food> items = foodDao.queryForPageItems(begin, pageSize);
        // 设置当前页数据
        page.setItems(items);

        return page;
    }
    @Override
    public Page<Food> page2(int pageNo, int pageSize,Integer suid) {
        Page<Food> page = new Page<Food>();

        // 设置当前页码
        page.setPageNo(pageNo);

        // 设置每页显示的数量
        page.setPageSize(pageSize);
        // 求总记录数
        Integer pageTotalCount = foodDao.queryForPageTotalCount2(suid);
        // 设置总记录数
        page.setPageTotalCount(pageTotalCount);
        // 求总页码
        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) {
            pageTotal += 1;
        }
        // 设置总页码
        page.setPageTotal(pageTotal);

        // 求当前页数据的开始索引
        int begin = (page.getPageNo() - 1) * pageSize;
        // 求当前页数据
        List<Food> items = foodDao.queryForPageItems2(begin, pageSize,suid);
        // 设置当前页数据
        page.setItems(items);
        return page;
    }

    @Override
    public Page<Food> pageByPrice(int pageNo, int pageSize, int min, int max) {
        Page<Food> page = new Page<Food>();

        // 设置当前页码
        page.setPageNo(pageNo);

        // 设置每页显示的数量
        page.setPageSize(pageSize);
        // 求总记录数
        Integer pageTotalCount = foodDao.queryForPageTotalCountByPrice(min,max);
        // 设置总记录数
        page.setPageTotalCount(pageTotalCount);
        // 求总页码
        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) {
            pageTotal += 1;
        }
        // 设置总页码
        page.setPageTotal(pageTotal);


        // 求当前页数据的开始索引
        int begin = (page.getPageNo() - 1) * pageSize;
        // 求当前页数据
        List<Food> items = foodDao.queryForPageItemsByPrice(begin, pageSize,min,max);
        // 设置当前页数据
        page.setItems(items);

        return page;
    }
}
