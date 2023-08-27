<%--
  Created by IntelliJ IDEA.
  User: tyleroneal
  Date: 8/26/23
  Time: 10:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Guess Results</title>
</head>
<body>

<c:choose>
    <c:when test="${guess == 2}">
        <h1>You Win!</h1>
    </c:when>
    <c:otherwise>
        <h1>You Lose!</h1>
    </c:otherwise>
</c:choose>



</body>
</html>
