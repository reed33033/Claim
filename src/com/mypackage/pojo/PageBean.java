package com.mypackage.pojo;

import java.util.List;
/**
 * 存放分页相关的数据
 *
 */
public class PageBean<T> {
    //基本属性
    private int currentPageNum;//当前页数，由用户指定
    private int pageSize = 2;//每页显示的条数，固定的
    private int totalRecords;//总记录条数，数据库查出来的
    private int totalPageNum;//总页数，计算出来的
    private List<T> list;//已经分好页的结果集


    public int getCurrentPageNum() {
        return currentPageNum;
    }

    public void setCurrentPageNum(int currentPageNum) {
        this.currentPageNum = currentPageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
        //总记录数固定，页面大小固定，计算出总页数
        if(this.totalRecords%this.pageSize==0){
            this.totalPageNum=this.totalRecords/this.pageSize;
        }else{
            this.totalPageNum=this.totalRecords/this.pageSize+1;
        }
    }

    public int getTotalPageNum() {
        return totalPageNum;
    }

    public void setTotalPageNum(int totalPageNum) {
        this.totalPageNum = totalPageNum;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "currentPageNum=" + currentPageNum +
                ", pageSize=" + pageSize +
                ", totalRecords=" + totalRecords +
                ", totalPageNum=" + totalPageNum +
                ", list=" + list +
                '}';
    }
}
