<%--
  Created by IntelliJ IDEA.
  User: chenggangma
  Date: 2023/7/17
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.ruan.dao.BaseDao" %>
<%
    Connection conn;
    Statement stmt;
    ResultSet rs = null;

    try {
        // 建立数据库连接
        conn = BaseDao.getConnection();

        // 执行SQL查询
        assert conn != null;
        stmt = conn.createStatement();
        String query = "SELECT id, dept_name FROM department";
        rs = stmt.executeQuery(query);
    } catch (Exception e) {
        e.printStackTrace();
    }
%>

<html>
<head>
    <title>编辑医生信息</title>
    <link href="static/css/bootstrap.min.css?v=3.3.5" rel="stylesheet">
    <link href="static/css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
    <link href="static/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="static/css/animate.min.css" rel="stylesheet">
    <link href="static/css/style.min.css?v=4.0.0" rel="stylesheet">
    <link rel="stylesheet" href="static/css/general.css" type="text/css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/4.1.1/crypto-js.min.js"></script>
    <script>if(window.top !== window.self){ window.top.location = window.location;}</script>
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
    </style>
</head>
<body>
<form class="m-t" action="user?action=updateUser" method="post" accept-charset="UTF-8" onsubmit="verify();encryptPassword()">
    <label for="id">编号：</label>
    <div class="form-group">
        <label for="id"><input type="text" id="id" class="form-control" name="id" value="${user.id}" readonly><br>
        </label>
    <div class="form-group">
        <label for="realname"><input type="text" id="realname" class="form-control" name="realname" value="${user.realname}" required><br>
        </label>
    </div>
    <div class="form-group">
        <label for="password"><input type="password" id="password" class="form-control" name="password" placeholder="请输入密码" required><br>
        </label>
    </div>
    <div class="form-group">
        <label>
            <input type="password" id="password2" class="form-control" placeholder="请再次输入密码" required>
        </label>
    </div>
    <label for="deptment_id">科室：</label>
    <div class="select-wrapper">
        <select id="deptment_id" name="deptment_id">
            <option value="none" selected disabled hidden>请选择科室</option>
            <% while (true) {
                assert rs != null;
                try {
                    if (!rs.next()) break;
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } %>
            <option value="<%= rs.getString("id") %>"><%= rs.getString("dept_name") %></option>
            <% } %>
        </select> <br>
    </div>
    <br>
    <label for="regist_level_id">职称：</label>
    <div class="select-wrapper">
        <select id="regist_level_id" name="regist_level_id">
            <option value="none" selected disabled hidden>请选择职称</option>
            <option value="1">专家号</option>
            <option value="2">普通号</option>
            <option value="3">主任医生号</option>
        </select><br>
    </div>
    <br>
    <label for="scheduling_id">排班：</label>
    <div class="select-wrapper">
        <select id="scheduling_id" name="scheduling_id">
            <option value="none" selected disabled hidden>请选择职称</option>
            <option value="1">星期一三五上午</option>
            <option value="2">星期一三五下午</option>
            <option value="3">星期二四六上午</option>
            <option value="4">星期二四六下午</option>
            <option value="5">周六周日全天</option>
        </select><br>
    </div>
    <input type="hidden" id="encryptedPassword" name="encryptedPassword">
    <input type="submit" value="更新"><br><br>
    </div>
</form>
<script src="static/js/crypto.js"></script>
<script>
    function verify(){
        const password = document.getElementById("password").value;
        const password2 = document.getElementById("password2").value;
        const agreementCheck = document.getElementById('agreement_check').checked;
        if (password !== password2) {
            alert("两次输入的密码不一致！");
            event.preventDefault();
        }
    }
    document.getElementById('deptment_id').selectedIndex = ${user.deptmentId};
    document.getElementById('regist_level_id').selectedIndex = ${user.registLevelId};
    document.getElementById('scheduling_id').selectedIndex = ${user.schedulingId};

</script>
</body>
</html>
