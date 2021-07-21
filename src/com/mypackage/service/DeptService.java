package com.mypackage.service;

import com.mypackage.pojo.Account;
import com.mypackage.pojo.Dept;

import java.util.List;

public interface DeptService {
    public List<Dept> queryAllDepts();
    public int queryDeptsByName(String name);
}
