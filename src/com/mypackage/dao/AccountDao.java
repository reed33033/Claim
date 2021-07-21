package com.mypackage.dao;

import com.mypackage.pojo.Account;
import com.mypackage.pojo.Condition;

import java.util.List;

public interface AccountDao {
    public List<Account> queryAllAccounts();
    //查询总记录数
    public int getTotalRecords();
    //分页查询报销信息 参数为当前页和页面大小
    public List<Account> queryAccountsByPage(int currentPage,int pageSize);

    //条件查询
    List<Account> queryAccountsByCondition(Condition condition);

    public int addAccount(Account account);
    public int deleteAccount(Integer id);
    public int updateAccount(Account account);
    public Account queryOneAccountById(Integer id);
}
