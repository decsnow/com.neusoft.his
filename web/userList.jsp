<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: chenggangma
  Date: 2023/7/16
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>医生信息</title>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        tr:hover {
            background-color: #4CAF50;
            color: white;
        }
    </style>
    <link href="static/css/bootstrap.min.css?v=3.3.5" rel="stylesheet">
    <link href="static/css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
    <link href="static/css/animate.min.css" rel="stylesheet">
    <link href="static/css/style.min.css?v=4.0.0" rel="stylesheet">
</head>
<body>
医生信息
<table>
    <tr>
        <td>编号</td>
        <td>姓名</td>
        <td>科室</td>
        <td>职称</td>
        <td>排班</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${userlist}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.realname}</td>
            <td>${user.dept_name}</td>
            <td>${user.regist_name}</td>
            <td>${user.rule_name}</td>
            <td>
                <button class="btn btn-danger" onclick="delUser(${user.id})">删除</button>
            </td>
        </tr>
    </c:forEach>
</table>
<script>
    function delUser(id) {
        if (confirm("确定要删除吗？")){
            location.href = "user?action=delUser&id=" + id;
        }
    }
</script>

</body>
</html>
