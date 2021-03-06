package com.jj.utils;


import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class JDBCUtils {

    private static ComboPooledDataSource dataSource = new ComboPooledDataSource("ordering");
    /**
     * 使用ThreadLocal保存Connection对象
     */
    private static ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<Connection>();

    private JDBCUtils() {
    }

    /**
     * 获取数据库连接
     *
     * @return 如果获取连接成功，返回数据的连接对象。
     *         如果获取数据库连接失败，则返回null
     */
    public static Connection getConnection() {
        // 先从ThreadLocal中获取
        Connection connection = connectionThreadLocal.get();
        try {
            if (connection == null||connection.isClosed()) {
                // 从c3p0中获取数据库连接
                connection = dataSource.getConnection();
                //设置事务手动提交
                connection.setAutoCommit(false);
                connectionThreadLocal.set(connection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 释放数据库连接
     */
   /* public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
*/
    /**
     * 释放数据库连接
     */
    public static void commitAndClose() {
        // 从线程ThreadLocal中获取
        Connection conn = connectionThreadLocal.get();
        if (conn != null) {
            try {
                // 事务提交
                conn.commit();
                // 事务关闭
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        // 移除
        connectionThreadLocal.remove();
    }

    public static void rollback() {
        // 从线程ThreadLocal中获取
        Connection conn = connectionThreadLocal.get();
        if (conn != null) {
            try {
                // 事务回滚
                conn.rollback();
                // 关闭连接
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        // 移除
        connectionThreadLocal.remove();
    }


}