package com.mypackage.service;

import com.mypackage.pojo.Account;
import com.mypackage.pojo.Condition;
import com.mypackage.pojo.PageBean;

import java.util.List;

public interface AccountService {
    public List<Account> queryAllAccounts();
    //分页查询报销信息 参数为当前页和页面大小
    public PageBean<Account> queryAccounttsByPage(int currentPage, int pageSize);
    //条件查询
    public List<Account> queryAccountsByCondition(Condition condition);

    public boolean addAccount(Account account);

    public boolean deleteAccountById(Integer id);

    public boolean updateAccount(Account account);

    public Account queryOneAccountById(Integer id);
}
