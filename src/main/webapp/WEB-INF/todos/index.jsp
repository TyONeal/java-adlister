<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <jsp:include page="/WEB-INF/partials/head.jsp">
    <jsp:param name="title" value="Viewing All The Ads" />
  </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
  <h1>Here Are all the todos!</h1>

  <c:forEach var="todo" items="${todos}">
    <div class="col-md-6">
      <h2 name="name">${todo.name}</h2>
      <form action="${pageContext.request.contextPath}/todos" method="post">
        <input type="hidden" name="name" value="${todo.name}"/>
        <input type="hidden" name="isComplete" value="${todo.isComplete}"/>
      <c:choose>
        <c:when test="${todo.isComplete == false}">
            <input name="status" type="checkbox" value="${todo.isComplete == false}">
        </c:when>
        <c:otherwise>
            <input name="status" type="checkbox" checked value="${todo.isComplete == true}">
        </c:otherwise>
      </c:choose>
        <input type="checkbox" name="toggle" value="true" <c:if test="${todo.isComplete}">checked</c:if>/>
        <button type="submit">Toggle</button>
      </form>
    </div>
  </c:forEach>
</div>

</body>
</html>