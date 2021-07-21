<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/7/7
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.js"></script>
    <script type="text/javascript">
        function add() {
            //开始发送数据
            var obj = {
                name: $("#name").val(),
                content: $("#content").val(),
                bxdate: $("#bxdate").val(),
                money:$("#money").val(),
                deptId:$("#deptname").val()
            }
            var s=JSON.stringify(obj)
            $.ajax({
                //几个参数需要注意一下
                type: "POST",//方法类型
                dataType: "text",//预期服务器返回的数据类型
                url: "http://localhost:8081/Claim/AddServlet" ,//url
                data: {info:s},
                success: function (data) {
                    //根据返回值进行状态显示
                    alert("succss");
                    location.href = "ListPageServlet";

                },
                error : function(data) {
                    alert("异常！");
                }
            })
        }
    </script>

</head>
<body>
<h1>添加报销单</h1>
<form action="AddServlet" method="post">
    <table width="50%" height="35%">
        <tr>
            <td>报销人</td>
            <td><input type="text" name="name" id="name"></td>
        </tr>
        <tr>
            <td>报销内容</td>
            <td><input type="text" name="content" id="content"></td>
        </tr>
        <tr>
            <td>报销日期</td>
            <td><input type="date" name="bxdate" id="bxdate"></td>
        </tr>
        <tr>
            <td>费用</td>
            <td><input type="text" name="money" id="money"></td>
        </tr>
        <tr>
            <td>部门</td>
            <td><input type="text" name="deptname" id="deptname"></td>
        </tr>
        <tr>
            <td><input type="button" value="添加" onclick="add()"></td>
            <td><input type="reset" name="重置"></td>
        </tr>

    </table>
</form>

</body>
</html>
