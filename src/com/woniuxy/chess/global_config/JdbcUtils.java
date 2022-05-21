package com.woniuxy.chess.global_config;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JdbcUtils {
    private static ThreadLocal<Connection> conns = new ThreadLocal<>();
    private static String jdbcUrl;
    private static String user;
    private static String password;
    private static Properties properties = new Properties();

    static{
        // 读取类路径下的properties文件；
        InputStream is = JdbcUtils.class.getClassLoader().getResourceAsStream("Database_Config.properties");
        try {
            properties.load(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        jdbcUrl = properties.getProperty("jdbcUrl");
        user = properties.getProperty("user");
        password = properties.getProperty("password");
    }

    /**
     * 通用数据库连接；
     */
    public static Connection getConnection() throws Exception {

        // 使用类的全限定名获取该类对象；
        Connection connection = DriverManager.getConnection(jdbcUrl, user,
                password);
        System.out.println(connection);
        return connection;
    }

    /**
     * 提交事务
     */
    public static void commit(Connection conn) {
        if (conn != null) { // 如果不等于null，说明 之前使用过连接，操作过数据库
            try {
                conn.commit(); // 提交事务
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 回滚事务
     */
    public static void rollback(Connection conn) {
        if (conn != null) { // 如果不等于null，说明 之前使用过连接，操作过数据库
            try {
                conn.rollback();//回滚事务
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 设置事务的手动提交
     */
    public static void disableAutocommit(Connection conn) {
        if (conn != null) {
            try {
                conn.setAutoCommit(false);
            } catch (SQLException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭数据库连接
     */
    public static void close(Connection conn) {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                conns.remove();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭资源
     */
    public static void closeResource(Connection conn, Statement st) {
        try {
            if (st != null) {
                st.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null) {
                conn.close();
                conns.remove();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭资源
     */
    public static void closeResource(Connection conn, Statement st, ResultSet rs) {
        try {
            if (st != null) {
                st.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null) {
                conn.close();
                conns.remove();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        JdbcUtils.getConnection();
    }
}


