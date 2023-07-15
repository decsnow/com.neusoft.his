<%--
  Created by IntelliJ IDEA.
  User: chenggangma
  Date: 2023/7/15
  Time: 12:40
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
    <title>Signup page</title>
    <link rel="stylesheet" href="static/general.css" type="text/css">
    <script src="static/crypto.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/4.1.1/crypto-js.min.js"></script>
</head>
<body>
<h2>Register</h2>


<form action="user?action=register" method="post" accept-charset="UTF-8" onsubmit="encryptPassword()">
    <label for="realname">Realname:</label>
    <input type="text" id="realname" name="realname" required><br>

    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required><br>

    <label for="deptment_id">Department ID:</label>
        <select id="deptment_id" name="deptment_id">
            <% while (true) {
                assert rs != null;
                try {
                    if (!rs.next()) break;
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } %>
            <option value="<%= rs.getString("id") %>"><%= rs.getString("dept_name") %></option>
            <% } %>
        </select>
    <br>
    <label for="regist_level_id">Regist Level:</label>
    <select id="regist_level_id" name="regist_level_id">
        <option value="1">专家号</option>
        <option value="2">普通号</option>
        <option value="3">主任医生号</option>
    </select><br>
    <label for="scheduling_id">Scheduling:</label>
    <select id="scheduling_id" name="scheduling_id">
        <option value="1">星期一三五上午</option>
        <option value="2">星期一三五下午</option>
        <option value="3">星期二四六上午</option>
        <option value="4">星期二四六下午</option>
        <option value="5">周六周日全天</option>
    </select><br>
    <input type="hidden" id="encryptedPassword" name="encryptedPassword">
    <input type="submit" value="Register"><br><br>
    <a href="index.jsp" class="button">Login</a>
</form>

<span class="status-message">${status}</span>
</body>
</html>
