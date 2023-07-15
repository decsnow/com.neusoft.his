<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Login Page</title>
    <link rel="stylesheet" href="static/general.css" type="text/css">
</head>
<body>
<h2>Login</h2>
<form action="user?action=login" method="post" accept-charset="UTF-8">
  <label for="realname">Realname:</label>
  <input type="text" id="realname" name="realname" required><br>

  <label for="password">Password:</label>
  <input type="password" id="password" name="password" required><br>

  <input type="submit" value="Login"><br><br>
  <a href="signup.jsp" class="button">Register</a>
</form>

<span class="status-message">${status}</span>
</body>
</html>
