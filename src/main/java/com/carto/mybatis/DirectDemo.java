package com.carto.mybatis;

import java.sql.*;

public class DirectDemo {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://120.78.206.231:3306/larry";
    static final String USER = "root";
    static final String PASS = "xhy520";


    public static void main(String[] args) throws Exception {
        Connection con = null;
        try {
            Class.forName(JDBC_DRIVER);
            con = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String sql = "select * from product_comment";
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            System.out.println(rs.getString("content"));
        }
        rs.close();
        con.close();
    }
}
