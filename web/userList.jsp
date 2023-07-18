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
            background-color: #b0dbff;
            color: white;
        }

        /*背景层*/
        #popLayer {
            display: none;
            background-color: #B3B3B3;
            position: absolute;
            top: 0;
            right: 0;
            bottom: 0;
            left: 0;
            z-index: 10;
            -moz-opacity: 0.8;
            opacity:.80;
            filter: alpha(opacity=80);/* 只支持IE6、7、8、9 */
        }

        /*弹出层*/
        #popBox {
            display: none;
            background-color: #ffffff;
            z-index: 11;
            width: 800px;
            height: 600px;
            position:fixed;
            top:0;
            right:0;
            left:0;
            bottom:0;
            margin:auto;
            box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2), 0 6px 20px 0 rgba(0,0,0,0.19);
            border-radius: 8px;
        }

        #popBox .close{
            text-align: right;
            margin-right: 5px;
            background-color: #F8F8F8;
        }

        /*关闭按钮*/
        #popBox .close a {
            text-decoration: none;
            color: #2D2C3B;
        }
    </style>
    <link href="static/css/bootstrap.min.css?v=3.3.5" rel="stylesheet">
    <link href="static/css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
    <link href="static/css/animate.min.css" rel="stylesheet">
    <link href="static/css/style.min.css?v=4.0.0" rel="stylesheet">
</head>
<body>
医生信息
<form class="form-inline" action="user?action=conditionQuery" method="post" accept-charset="UTF-8">
    <div class="form-group">
        <label for="exampleInputName2">姓名</label>
        <input type="text" class="form-control" name="realname" id="exampleInputName2" placeholder="请输入医生姓名">
    </div>
    <div class="form-group">
        <label>
            <select class="form-control" name="deptment_id">
                <option value="0">科室</option>
            <c:forEach items="${deptlist}" var="dept">
                <option value="${dept.id}">${dept.dept_name}</option>
            </c:forEach>
            </select>
        </label>
    </div>
    <button type="submit" class="btn btn-primary">搜索</button>
</form>
<table style="margin: 20px">
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
            <td><br>${user.id}<br><br></td>
            <td>${user.realname}</td>
            <td>${user.dept_name}</td>
            <td>${user.regist_name}</td>
            <td>${user.rule_name}</td>
            <td>
                <button class="btn btn-primary" onclick=updateUser(${user.id})>编辑</button>
                <button class="btn btn-danger" onclick="delUser(${user.id})">删除</button>
            </td>
        </tr>
    </c:forEach>
</table>
<div id="popBox">
    <div class="close">
        <button  class="btn-circle" onclick="closeBox()">关闭</button>
    </div>
    <div class="content">我是弹出层</div>
</div>
<script>
    function delUser(id) {
        if (confirm("确定要删除吗？")){
            location.href = "user?action=delUser&id=" + id;
        }
    }
    function updateUser(id) {
        location.href = "user?action=listUser&id=" + id
    }
    /*点击弹出按钮*/
    function popBox() {
        var popBox = document.getElementById("popBox");
        var popLayer = document.getElementById("popLayer");
        popBox.style.display = "block";
        popLayer.style.display = "block";
    };

    /*点击关闭按钮*/
    function closeBox() {
        var popBox = document.getElementById("popBox");
        var popLayer = document.getElementById("popLayer");
        popBox.style.display = "none";
        popLayer.style.display = "none";
    }
</script>

</body>
</html>
