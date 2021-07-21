package com.mypackage.util;

import java.sql.*;
public class DBUtil {
    private  static String driverClassName="com.mysql.jdbc.Driver";
    private  static String url="jdbc:mysql://localhost:3306/reimburse?characterEncoding=utf8";
    private  static String username="root";
    private  static String password="123456";

    static{

        try {
            Class.forName(driverClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return  null;
    }

    public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs){
        try {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();

            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void close(Connection conn, PreparedStatement pstmt){
        try {

            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();

            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
