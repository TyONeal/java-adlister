<%--
  Created by IntelliJ IDEA.
  User: tyleroneal
  Date: 8/29/23
  Time: 11:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<h1>Let's register a new account...</h1>
<form action="/register" method="POST">
  <label for="username">Enter your username:</label>
    <input type="text" id="username" name="username" placeholder="Enter a username">
  <label for="email">Enter your email:</label>
    <input type="text" id="email" name="email" placeholder="Enter your email">
  <label for="password">Enter your password:</label>
    <input type="password" id="password" name="password" placeholder="Enter a password">

    <button type="submit">Submit</button>
</form>

</body>
</html>
