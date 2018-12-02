package com.atmoon.spring;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;


import com.atmoon.spring.base.customer.model.Customer;
import com.mysql.jdbc.Driver;

public class JdbcUtils {

    // 定义数据库的用户名
    private final String USERNAME = "root";
    // 定义数据库的密码
    private final String PASSWORD = "admin123";
    // 定义数据库的驱动信息(mysql8.0以下)
    //private final String DRIVER = "com.mysql.jdbc.Driver";
    //mysql8.0
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    // 定义访问数据库的地址
    private final String URL = "jdbc:mysql://localhost:3306/test";

    // 定义访问数据库的连接
    private Connection connection;
    // 定义sql语句的执行对象
    private PreparedStatement pstmt;
    // 定义查询返回的结果集合
    private ResultSet resultSet;

    public JdbcUtils() {
        // TODO Auto-generated constructor stub
        try {
            Class.forName(DRIVER);
            System.out.println("注册驱动成功！！");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            System.out.println("注册驱动失败！！");
        }

    }

    // 定义获得数据库的连接
    public Connection getConnection() {

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Connection exception !");
            System.out.println(e);
        }

        return connection;
    }

    public void insert(Customer customer) {
        String sql = "INSERT INTO CUSTOMER " +
                "(CUST_ID, NAME, AGE) VALUES (?, ?, ?)";

        try {
            connection = this.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, customer.getCustId());
            ps.setString(2, customer.getName());
            ps.setInt(3, customer.getAge());
            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);

        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {}
            }
        }

    }

    public static void main(String[] args) {
        JdbcUtils jdbcUtils = new JdbcUtils();
        Customer customer = new Customer(001,"JHT",21);
        jdbcUtils.insert(customer);

    }
}
