package com.jj.utils;

import com.jj.bean.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class Utils {
    private Utils() {
    }

    // 把map集合中的值，赋值到Object对象中
    public static <T> T copyParameterToBean(Map value, T bean) {
        try{
            System.out.println("注入之前：" +bean);

            BeanUtils.populate(bean,value);
            System.out.println("注入之后" +bean);
        }catch (Exception e){
            e.printStackTrace();
        }
        return bean;

    }

    /**
     * 将字符串转换成int类型
     * @param strInt
     * @param defaultValue
     * @return
     */
    public static int parseInt(String strInt,int defaultValue) {
        try {
            return Integer.parseInt(strInt);
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return  defaultValue;
    }

}