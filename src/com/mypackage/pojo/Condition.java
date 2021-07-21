package com.mypackage.pojo;

public class Condition {
    private String name;
    private int deptId;

    public Condition() {

    }

    public Condition(String name, int deptId) {
        this.name = name;
        this.deptId = deptId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    @Override
    public String toString() {
        return "Condition{" +
                "name='" + name + '\'' +
                ", deptId=" + deptId +
                '}';
    }
}
