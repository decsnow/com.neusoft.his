package com.ruan.dao;

import java.sql.*;

public class BaseDao {
    //定义一个连接数据库的地址
    private static final String URL = "jdbc:mysql://relay.decsnow.net:3306/homework";
    //定义一个连接数据库的用户名
    private static final String USERNAME = "homework";
    //定义一个连接数据库的密码
    private static final String PWD = "dFcY3hWs7AmKDLA6";
    //获取一个全局的连接
    private static Connection conn = null;

    static {
        //加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //获取连接
    public static Connection getConnection() {
        try {
            //当第一次获取时才执行
            //if (conn == null){
                return conn = DriverManager.getConnection(URL, USERNAME, PWD);
            //}
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        BaseDao.getConnection();
        String sql = "select * from employee";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ResultSet rs;
        try {
            rs = ps.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        while (true) {
            try {
                if (!rs.next()) break;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                //输出完整返回值
                System.out.println(rs.getString(1) + " " + rs.getString(2)+ " " + rs.getString(3)+ " " + rs.getString(4)+ " " + rs.getString(5)+ " " + rs.getString(6)+ " " + rs.getString(7));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    protected void init() {
    }

    protected void destroy() {
    }
}
