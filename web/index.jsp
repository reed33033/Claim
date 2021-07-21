<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/7/6
  Time: 13:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.mypackage.pojo.Account" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="app.jsp" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h1 style="color: red;">报销单列表</h1>
欢迎你：【${user.username}】
头像:
<img style="width:60px;height: 60px" src="images/${user.photo}"><br>
<div style="border-bottom: 1px solid #000;border-top: 1px solid #000;">
    姓名：<input type="text" name="name"> 部门：
    <select>
<c:forEach var="d" items="${requestScope.dlist}">
    <option value="volvo">${d.deptname}</option>
</c:forEach>
    </select>
    <input type="submit" value="搜索"><br/>
</div>
<div style="border-bottom: 1px solid #000;">
    <a href="register.html">安全退出</a>
</div>
<table style="border: 1px solid #000">
  <tr style="border: 1px solid #000">
    <td>编号</td>
    <td>报销人</td>
    <td>报销内容</td>
    <td>报销日期</td>
    <td>费用</td>
    <td>部门</td>
    <td><a href="">添加</a></td>
  </tr>


  <c:forEach var="s" items="${requestScope.list}">
    <tr style="border: 1px solid #000">
      <td>${s.id}</td>
      <td>${s.name}</td>
      <td>${s.content}</td>
      <td>${s.bxdate}</td>
      <td>${s.money}</td>
      <td>${s.deptname}</td>
      <td>
        <a href="">修改</a>
        <a href="">删除</a>
      </td>
    </tr>
  </c:forEach>
</table>
<div>

</div>
</body>
</html>
