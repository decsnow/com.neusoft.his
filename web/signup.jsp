<%--
  Created by IntelliJ IDEA.
  User: chenggangma
  Date: 2023/7/15
  Time: 12:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Signup page</title>
    <link rel="stylesheet" href="static/general.css" type="text/css">
</head>
<body>
<h2>Register</h2>


<form action="user?action=register" method="post" accept-charset="UTF-8">
    <label for="realname">Realname:</label>
    <input type="text" id="realname" name="realname" required><br>

    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required><br>

    <label for="deptment_id">Department ID:</label>
    <input type="text" id="deptment_id" name="deptment_id" required><br>

    <input type="submit" value="Register"><br><br>
    <a href="index.jsp" class="button">Login</a>
</form>

<span class="status-message">${status}</span>
</body>
</html>
