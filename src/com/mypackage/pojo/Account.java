package com.mypackage.pojo;

import java.util.Date;

public class Account {
    private int id;
    private String name;
    private String content;
    private Date bxdate;
    private float money;
    private int deptId;
    private String deptname;

    public Account() {
    }

    public Account(int id, String name, String content, Date bxdate, float money, int deptId) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.bxdate = bxdate;
        this.money = money;
        this.deptId = deptId;
    }

    public Account(int id, String name, String content, Date bxdate, float money, int deptId, String deptname) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.bxdate = bxdate;
        this.money = money;
        this.deptId = deptId;
        this.deptname = deptname;
    }

    public Account(String name, String content, Date bxdate, float money, int deptId) {
        this.name = name;
        this.content = content;
        this.bxdate = bxdate;
        this.money = money;
        this.deptId = deptId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getBxdate() {
        return bxdate;
    }

    public void setBxdate(Date bxdate) {
        this.bxdate = bxdate;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", bxdate=" + bxdate +
                ", money=" + money +
                ", deptId=" + deptId +
                ", deptname='" + deptname + '\'' +
                '}';
    }
}
