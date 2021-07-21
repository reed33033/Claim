<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/7/6
  Time: 13:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.mypackage.pojo.Account" %>
<%@ page import="java.util.List" %>
<%@ page import="com.mypackage.pojo.User" %>
<%@ page import="com.mypackage.pojo.PageBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="app.jsp" %>
<html>
<head>
    <title>$Title$</title>
    <style type="text/css">
        *{ margin: 5px; padding: 5px;text-decoration:none;}
        html,body{ height: 100%; width: 100%;text-decoration:none;}
        html,body{ text-align: left;font-size: 16px; color: #666; font-family: "Microsoft YaHei", Helvetica, Arial, sans-serif;}
        dl,ol,ul{ list-style-type: none;}
        input{ color: #666;}
        table {margin: auto;}

        /* 表 */
        .xt-table{ margin: 20px; border: 1px solid #dcdcdc;}
        .xt-table td,.xt-table th{ background: #fff; padding: 16px 8px;}
        .xt-table th{ background: #eee; border-bottom:1px solid #dcdcdc; }
        .xt-table tr.xt-bg td{ background: #f9fafa;}
        .xt-table tr td{text-align: center;}
        .xt-table tr td a{ padding: 3px 5px; text-decoration: none; border-radius: 5px; display: inline-block; margin: 0 2px;}
        .xt-table tr:hover td{ background: #73cfce; color: #fff;}
        .xt-table tr:hover td a:hover{color: #baa01b; background: #f5e17a;}
        /* 分页 */
        .xt-fenye{ margin: 20px; background: #fff; border: 1px solid #dcdcdc; overflow: hidden; padding: 10px 15px;}
        .xt-fenye-left{ float: left; padding: 5px 0;}
        .xt-fenye-right{ float: right;}
        .xt-fenye-right a,.xt-fenye-right input{ display: inline-block; vertical-align: middle;}
        .xt-fenye-right a{ background: #f8f8f8; border: 1px solid #dcdcdc; padding: 5px 15px; color: #666; text-decoration: none;}
        .xt-fenye-right a:hover{ background: #21b6b4; color: #fff; border: 1px solid #21b6b4;}
        .xt-fenye-right a.xt-link{ background: #21b6b4; color: #fff; border: 1px solid #21b6b4;}
        .xt-fenye-right a:hover.xt-link{ background: #30abaa; color: #fff; border: 1px solid #30abaa;}
        .xt-fenye-right input{ width: 40px; text-align: center; padding: 4px;}

        /* a/input样式 */
        .yellow-xt{ background: #ffb849; color: #fff;}
        .red-xt{ background: #da542e; color: #fff;}
        .blue-xt{ background: #2596d4; color: #fff;}
        .green-xt{ background: #21b6b4; color: #fff;}
        .green-int{ background: #21b6b4; color: #fff; padding: 6px 20px; border: none; border-radius: 8px; font-size: 14px;}
        .yellow-int{ background: #ffb849; color: #fff; padding: 6px 20px; border: none; border-radius: 8px; font-size: 14px;}
        /*body {*/
        /*    font-size: 10pt;*/
        /*}*/
        /*.listView th {*/
        /*    font: bold 12px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;*/
        /*    color: #000000;*/
        /*    border: 1px solid #000000;*/
        /*    letter-spacing: 2px;*/
        /*    text-transform: uppercase;*/
        /*    text-align: left;*/
        /*    padding: 6px 11px;*/
        /*    background: #000000  no-repeat;*/
        /*}*/
        /*.listView td {*/
        /*    border: 1px solid #000000;*/
        /*    font-size:12px;*/
        /*    color: #000000;*/
        /*    padding: 6px 11px;*/
        /*    border-bottom: 1px solid #000000;*/
        /*}*/
    </style>
</head>
<body>
<h1 style="color: red;text-align:center;">报销单列表</h1>
<span style="color: limegreen">
欢迎你：【${user.username}】
</span>
头像:
<img style="width:60px;height: 60px" src="images/${user.photo}"><br>
<div style="border-bottom: 1px solid #dcdcdc;border-top: 1px solid #dcdcdc;">
    <form action="ConditionServlet" method="post">
    姓名：<input type="text" name="name"> 部门：
    <select name="dept">
        <c:forEach var="d" items="${requestScope.dlist}">
            <option value="${d.id}">${d.deptname}</option>
            </option>
        </c:forEach>
    </select>
<%--    <input type="submit" value="搜索"><br/>--%>
        <input type="submit" value="搜索" class="green-int" />
    </form>
</div>
<div style="border-bottom: 1px solid #dcdcdc;padding-bottom: 15px;padding-top: 15px">
    <a href="login.html" class="yellow-int">安全退出</a>
</div>
<div class="xt-table">
<table style="border: 1px solid #000" class="listView" data-options="checkableOptions">
    <thead>
    <tr style="border: 1px solid #000">
        <th><input type="checkbox"></th>
        <th>编号</th>
        <th>报销人</th>
        <th>报销内容</th>
        <th>报销日期</th>
        <th>费用</th>
        <th>部门</th>
        <th><a href="add.jsp" class="blue-xt">添加</a></th>
    </tr>
    </thead>
    <c:if test="${requestScope.page!=null}">
            <c:forEach var="s" items="${requestScope.page.list}">
                <tbody>
                <tr style="border: 1px solid #000">
                    <td><input type="checkbox"></td>
                    <td>${s.id}</td>
                    <td>${s.name}</td>
                    <td>${s.content}</td>
                    <td>${s.bxdate}</td>
                    <td>${s.money}</td>
                    <td>${s.deptname}</td>
                    <td>
                        <a href="load?id=${s.id}" class="yellow-xt">修改</a>
                        <a href="delete?id=${s.id}" class="red-xt">删除</a>
                    </td>
                </tr>
                </tbody>
            </c:forEach>


        </c:if>
<%--        <tr>--%>

<%--        <td colspan="9">--%>
<%--            <input type="button" value="首页" onclick="toFirst()">--%>
<%--            <input type="button" value="上一页" onclick="toPrev()">--%>
<%--            当前页 ${requestScope.page.currentPageNum}| ${requestScope.page.totalPageNum} 总页数--%>
<%--            <input type="button" value="下一页" onclick="toNext()">--%>
<%--            <input type="button" value="末页" onclick="toLast()">--%>
<%--        </td>--%>
<%--    </tr>--%>
</table>
</div>
<div class="xt-fenye">
    <div class="xt-fenye-left">当前：${requestScope.page.currentPageNum}| ${requestScope.page.totalPageNum} 页  总数据量：${requestScope.page.totalRecords}</div>
    <div class="xt-fenye-right">
        <a type="button" value="首页" onclick="toFirst()">首页</a>
        <a type="button" value="上一页" onclick="toPrev()">上一页</a>
        <a type="button" value="下一页" onclick="toNext()">下一页</a>
        <a type="button" value="末页" onclick="toLast()">末页</a>
    </div>
</div>
</body>

<script>
    var currentPage=${requestScope.page.currentPageNum};
    var totalPage=${requestScope.page.totalPageNum};

    function toFirst() {
        location.href="ListPageServlet?currentPage=1";
    }
    function toPrev() {
        //控制页面显示风格
        var url="";
        if(currentPage==1){
            url="ListPageServlet?currentPage=1";
        }else{
            url="ListPageServlet?currentPage="+(currentPage-1);
        }
        location.href=url;

    }
    function toNext() {
        //控制页面显示风格
        var url="";
        if(currentPage==totalPage){
            url="ListPageServlet?currentPage="+totalPage;
        }else{
            url="ListPageServlet?currentPage="+(currentPage+1);
        }
        location.href=url;

    }
    function toLast() {
        location.href="ListPageServlet?currentPage="+${requestScope.page.totalPageNum};
    }
</script>
</html>
