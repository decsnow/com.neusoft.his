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
    </tr>
    <c:forEach items="${userlist}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.realname}</td>
            <td>${user.deptmentId}</td>
            <td>${user.registLevelId}</td>
            <td>${user.schedulingId}</td>
        </tr>
    </c:forEach>
</table>


</body>
</html>
