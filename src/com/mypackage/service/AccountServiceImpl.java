package com.mypackage.service;

import com.mypackage.dao.AccountDao;
import com.mypackage.dao.AccountDaoImpl;
import com.mypackage.pojo.Account;
import com.mypackage.pojo.Condition;
import com.mypackage.pojo.PageBean;

import java.util.List;

public class AccountServiceImpl implements AccountService{
    private  AccountDao accountDao=new AccountDaoImpl();
     @Override
    public List<Account> queryAllAccounts() {
        return accountDao.queryAllAccounts();
    }

    @Override
    public PageBean<Account> queryAccounttsByPage(int currentPage, int pageSize) {
        List<Account> accounts = accountDao.queryAccountsByPage(currentPage, pageSize);
        int total = accountDao.getTotalRecords();
        PageBean<Account> pageBean=new PageBean<>();
        pageBean.setPageSize(pageSize);//设置页面大小
        pageBean.setTotalRecords(total);//设置总记录数
        pageBean.setCurrentPageNum(currentPage);//设置当前页
        pageBean.setList(accounts);//设置当前页数据
        return pageBean;
    }

    @Override
    public List<Account> queryAccountsByCondition(Condition condition) {
        return accountDao.queryAccountsByCondition(condition);
    }

    @Override
    public boolean addAccount(Account account) {
        int row = accountDao.addAccount(account);
        if(row>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteAccountById(Integer id) {
        int row = accountDao.deleteAccount(id);
        if(row>0){
            return true;
        }

        return false;
    }

    @Override
    public boolean updateAccount(Account account) {
        int row = accountDao.updateAccount(account);
        if(row>0){
            return true;
        }
        return false;
    }

    @Override
    public Account queryOneAccountById(Integer id) {
        return accountDao.queryOneAccountById(id);
    }

}
