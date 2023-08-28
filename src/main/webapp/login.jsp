<%--
  Created by IntelliJ IDEA.
  User: tyleroneal
  Date: 8/24/23
  Time: 2:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%! String user_name;%>
<%! String user_pass;%>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form action="/login.jsp" method="post" name="form-one">
    <input type="text" name="userNameInput">
    <input type="text" name="userPassInput">
    <button type="submit" value="check" >Submit</button>
</form>
<c:set var="userInputName" value="${param.userNameInput}"></c:set>
<c:set var="userPassName"  value="${param.userPassInput}"></c:set>
<c:if test="${userInputName.equals('admin') && userPassName.equals('password')}">
    <c:redirect url="profile.jsp">Redirecting...</c:redirect>
</c:if>
</body>
</html>
