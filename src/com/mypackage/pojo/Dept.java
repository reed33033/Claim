package com.mypackage.pojo;

public class Dept {
    private int id;
    private String deptname;

    public Dept() {
    }

    public Dept(int id, String deptname) {
        this.id = id;
        this.deptname = deptname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "id=" + id +
                ", deptname='" + deptname + '\'' +
                '}';
    }
}
