<%--
  Created by IntelliJ IDEA.
  User: tyleroneal
  Date: 8/27/23
  Time: 1:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>List Ads</title>
</head>
<body>
      <h1>Here are all the ads!</h1>
          <c:forEach var="ad" items="${ads}">
            <div class="ads">
              <h2>${ad.title}</h2>
              <p>${ad.description}</p>
            </div>
          </c:forEach>
</body>
</html>
