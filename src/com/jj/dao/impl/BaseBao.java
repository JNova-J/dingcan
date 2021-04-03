package com.jj.dao.impl;

import com.jj.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseBao {

    //使用DbUtils操作数据库
    QueryRunner queryRunner=new QueryRunner();
        // 创建一个QueryRunner对象实例


    //update()用来执行insert,update,delete语句
    public int update(String sql, Object... params) {
        Connection connection = JDBCUtils.getConnection();
        try {
            return queryRunner.update(connection, sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public<T> T queryOne(Class<T> type,String sql, Object... params) {
        Connection con = JDBCUtils.getConnection();
        try {
            return queryRunner.query(con, sql, new BeanHandler<T>(type), params);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    /**
     * 执行查询语句，返回查询后的对象实例集合
     *
     * @param sql
     *            要执行的sql语句
     * @param params
     *            sql语句的参数
     * @return 返回的是查找到的对象集合<br/>
     *         查询失败返回null
     */
    public<T> List<T> queryList(Class<T> type,String sql, Object... params) {
        Connection con = JDBCUtils.getConnection();
        try {
            return queryRunner.query(con, sql, new BeanListHandler<T>(type), params);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    public Object queryForSingleValue(String sql,Object ... args){
        Connection conn=JDBCUtils.getConnection();
        try {
            return queryRunner.query(conn, sql, new ScalarHandler(), args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
