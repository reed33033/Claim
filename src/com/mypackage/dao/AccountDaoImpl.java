package com.mypackage.dao;

import com.mypackage.pojo.Account;
import com.mypackage.pojo.Condition;
import com.mypackage.util.DBUtil;
import com.mypackage.util.DateUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDaoImpl implements AccountDao{
    private DeptDao deptDao=new DeptDaoImpl();
    @Override
    public List<Account> queryAllAccounts() {
        String sql="select * from account";

        PreparedStatement pstmt=null;
        ResultSet rs=null;
        List<Account> list=new ArrayList<>();

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
                String name = rs.getString(2);
                String content = rs.getString(3);
                Date bxdate = rs.getDate(4);
                float money = rs.getFloat(5);
                int deptId = rs.getInt(6);
                Account a=new Account(id,name,content,bxdate,money,deptId);
                String deptname=deptDao.queryDeptById(a.getId());
                a.setDeptname(deptname);
                list.add(a);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            //6. 关闭资源
            DBUtil.close(conn,pstmt,rs);
        }

        return list;
    }

    @Override
    public int getTotalRecords() {
        String sql="select count(*) from account";

        Connection conn = DBUtil.getConnection();
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        int count=0;
        try {
            pstmt= conn.prepareStatement(sql);
            rs= pstmt.executeQuery();

            if (rs.next()) {
                count = rs.getInt(1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(conn,pstmt,rs);
        }
        return count;
    }

    @Override
    public List<Account> queryAccountsByPage(int currentPage, int pageSize) {
        String sql="select * from account limit ?,?";

        Connection conn = DBUtil.getConnection();
        List<Account> list = new ArrayList<>();
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try {
            pstmt= conn.prepareStatement(sql);
            //注意第一个参数值的写法
            pstmt.setInt(1,(currentPage-1)*pageSize);
            pstmt.setInt(2,pageSize);
            rs= pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String content = rs.getString(3);
                Date bxdate = rs.getDate(4);
                float money = rs.getFloat(5);
                int deptId = rs.getInt(6);
                Account a=new Account(id,name,content,bxdate,money,deptId);
                String deptname=deptDao.queryDeptById(a.getDeptId());
                a.setDeptname(deptname);
                list.add(a);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(conn,pstmt,rs);
        }
        return list;
    }

    @Override
    public List<Account> queryAccountsByCondition(Condition condition) {
        String sql="";

        Connection conn = DBUtil.getConnection();
        List<Account> list = new ArrayList<>();
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try {
            String name = condition.getName();
            System.out.println(condition);
            //判断要不要根据姓名模糊查询
            if(name!=null&&!"".equals(name)){
                sql="select * from account where name like ? and deptId=?";
                pstmt= conn.prepareStatement(sql);
                pstmt.setString(1,"%"+name+"%");
                pstmt.setInt(2,condition.getDeptId());
            }else{
                sql="select * from account where  deptId=?";
                pstmt= conn.prepareStatement(sql);
                pstmt.setInt(1,condition.getDeptId());
            }

            rs= pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                String aname = rs.getString(2);
                String content = rs.getString(3);
                Date bxdate = rs.getDate(4);
                float money = rs.getFloat(5);
                int deptId = rs.getInt(6);
                Account a=new Account(id,aname,content,bxdate,money,deptId);
                String deptname=deptDao.queryDeptById(a.getDeptId());
                a.setDeptname(deptname);
                System.out.println(a);
                list.add(a);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(conn,pstmt,rs);
        }
        return list;
    }

    @Override
    public int addAccount(Account account) {
        String sql="INSERT INTO `account` (`name`,content,bxdate,money,deptId) VALUES (?,?,?,?,?)";

        Connection conn = DBUtil.getConnection();
        PreparedStatement pstmt=null;
        int row=0;
        try {
            pstmt= conn.prepareStatement(sql);
            pstmt.setString(1,account.getName());
            pstmt.setString(2,account.getContent());
            pstmt.setDate(3, DateUtil.toSqlDate(account.getBxdate()));
            pstmt.setFloat(4,account.getMoney());
            pstmt.setInt(5,account.getDeptId());
            row= pstmt.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(conn,pstmt);
        }
        return row;
    }

    @Override
    public int deleteAccount(Integer id) {
        String sql="delete from account where id=?";

        Connection conn = DBUtil.getConnection();

        PreparedStatement pstmt=null;
        int row=0;
        try {
            pstmt= conn.prepareStatement(sql);

            pstmt.setInt(1,id);

            row= pstmt.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(conn,pstmt);
        }
        return row;
    }

    @Override
    public int updateAccount(Account account) {
        String sql="UPDATE account SET name=?,content=?,bxdate=?,money=?,deptId=? WHERE id=?";

        Connection conn = DBUtil.getConnection();
        PreparedStatement pstmt=null;
        int row=0;
        try {
            pstmt= conn.prepareStatement(sql);
            pstmt.setString(1,account.getName());
            pstmt.setString(2,account.getContent());
            pstmt.setDate(3, DateUtil.toSqlDate(account.getBxdate()));
            pstmt.setFloat(4,account.getMoney());
            pstmt.setInt(5,account.getDeptId());
            pstmt.setInt(6,account.getId());
            row= pstmt.executeUpdate();


        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(conn,pstmt);
        }
        System.out.println(sql);
        return row;
    }

    @Override
    public Account queryOneAccountById(Integer id) {
        String sql="select * from account where id=?";

        Connection conn = DBUtil.getConnection();
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        Account account=null;
        try {
            pstmt= conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            rs= pstmt.executeQuery();

            if (rs.next()) {
                int idd = rs.getInt(1);
                String name = rs.getString(2);
                String content = rs.getString(3);
                Date bxdate = rs.getDate(4);
                Float money = rs.getFloat(5);
                int deptId = rs.getInt(6);
                account=new Account(idd,name,content,bxdate,money,deptId);

            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(conn,pstmt,rs);
        }
        return account;
    }
}
