package com.mypackage.dao;

import com.mypackage.pojo.Account;
import com.mypackage.pojo.Dept;
import com.mypackage.pojo.User;
import com.mypackage.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeptDaoImpl implements DeptDao{
    @Override
    public List<Dept> queryAllDepts() {
        String sql="select * from dept";

        PreparedStatement pstmt=null;
        ResultSet rs=null;
        List<Dept> list=new ArrayList<>();

        //2. 获取连接
        Connection conn = DBUtil.getConnection();
        try {
            //3. 创建PreparedStatement
            pstmt = conn.prepareStatement(sql);

            //4. 执行sql
            rs = pstmt.executeQuery();
            //5. 处理结果集 查询会有结果集
            while (rs.next()) {
                int id = rs.getInt(1);
                String deptname = rs.getString(2);
                Dept d=new Dept(id,deptname);
                list.add(d);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            //6. 关闭资源
            DBUtil.close(conn,pstmt,rs);
        }

        return list;
    }

    public String queryDeptById(int id){
        //1.加载驱动
        String sql="select * from dept where id=?";
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;

        try {
            //2.获取连接

            conn= DBUtil.getConnection();
            //3.创建PreparedStatement
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            //4.执行操作
            rs = pstmt.executeQuery();
            //5.处理结果集
            if (rs.next()) {
                String name = rs.getString(2);
                return name;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        //6. 关闭资源
        DBUtil.close(conn,pstmt,rs);
        return null;
    }

    @Override
    public int queryDeptByName(String name) {
        //1.加载驱动
        String sql="select * from dept where deptname=?";
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;

        try {
            //2.获取连接

            conn= DBUtil.getConnection();
            //3.创建PreparedStatement
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,name);
            //4.执行操作
            rs = pstmt.executeQuery();
            //5.处理结果集
            if (rs.next()) {
                int id = rs.getInt(1);
                return id;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        //6. 关闭资源
        DBUtil.close(conn,pstmt,rs);
        return 0;
    }
}
