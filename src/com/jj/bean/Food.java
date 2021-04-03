package com.jj.bean;

import java.math.BigDecimal;

public class Food {
    private Integer id;
    private String name;
    private String sid;
    private BigDecimal price;
    private Integer sales;
    private Integer stock;
    private String imgPath="static/img/default.jpeg";
    private Integer suid;

    public Food() {
    }

    public Food(Integer id, String name, String sid, BigDecimal price, Integer sales, Integer stock, String imgPath,Integer suid) {
        this.id = id;
        this.name = name;
        this.sid = sid;
        this.price = price;
        this.sales = sales;
        this.stock = stock;
        //要求给定的图片路径不能为空
        if (imgPath !=null&&!"".equals(imgPath)) {
            this.imgPath = imgPath;
        }
        this.suid=suid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        if (imgPath !=null&&!"".equals(imgPath)) {
            this.imgPath = imgPath;
        }
    }

    public Integer getSuid() {
        return suid;
    }

    public void setSuid(Integer suid) {
        this.suid = suid;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sid='" + sid + '\'' +
                ", price=" + price +
                ", sales=" + sales +
                ", stock=" + stock +
                ", imgPath='" + imgPath + '\'' +
                ", suid=" + suid +
                '}';
    }
}
