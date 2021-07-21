package com.mypackage.service;

import com.mypackage.dao.AccountDao;
import com.mypackage.dao.AccountDaoImpl;
import com.mypackage.dao.DeptDao;
import com.mypackage.dao.DeptDaoImpl;
import com.mypackage.pojo.Dept;

import java.util.List;

public class DeptServiceImpl implements DeptService{
    private DeptDao deptDao=new DeptDaoImpl();
    @Override
    public List<Dept> queryAllDepts() {
        return deptDao.queryAllDepts();
    }

    @Override
    public int queryDeptsByName(String name) {
        return deptDao.queryDeptByName(name);
    }
}
