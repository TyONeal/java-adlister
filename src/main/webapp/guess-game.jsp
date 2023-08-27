<%--
  Created by IntelliJ IDEA.
  User: tyleroneal
  Date: 8/26/23
  Time: 10:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Guess Game</title>
</head>
<body>

<h1>Let's play a game! Guess a number between 1 and 3!</h1>

<form method="post" action="/guess">
    <input type="text" name="playerGuess">
    <button type="submit">Guess!</button>
</form>



</body>
</html>
