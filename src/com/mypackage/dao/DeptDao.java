package com.mypackage.dao;

import com.mypackage.pojo.Account;
import com.mypackage.pojo.Dept;

import java.util.List;

public interface DeptDao {
    public List<Dept> queryAllDepts();
    public String queryDeptById(int id);

    public int queryDeptByName(String name);
}
