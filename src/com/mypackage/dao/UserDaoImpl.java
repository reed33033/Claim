package com.mypackage.dao;

import com.mypackage.pojo.User;
import com.mypackage.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao{

    @Override
    public User queryOneUser(User user)  {
        //1.加载驱动
        String sql="select * from user where username=? and password=?";

        User u=null;
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;

        try {
            //2.获取连接

            conn= DBUtil.getConnection();
            //3.创建PreparedStatement
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            //4.执行操作
            rs = pstmt.executeQuery();
            //5.处理结果集
            if (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String pass = rs.getString(3);
                String photo=rs.getString(4);

                u = new User(id, name, pass,photo);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        //6. 关闭资源
        DBUtil.close(conn,pstmt,rs);
        return u;
    }

    @Override
    public int insertUser(User user) {
        String sql="INSERT INTO user (username, password,photo) VALUES ( ?, ?,?)";
        Connection conn = DBUtil.getConnection();
        PreparedStatement pstmt=null;
        int row=0;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getPhoto());
            row = pstmt.executeUpdate();
        }catch(SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(conn,pstmt);
        }
        return row;
    }
}
