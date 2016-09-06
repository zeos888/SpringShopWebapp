<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%--
  Created by IntelliJ IDEA.
  User: alxev
  Date: 07.09.2016
  Time: 1:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product category was added successfully</title>
</head>
<body>
<h2>Product category ${categoryName} was added successfully</h2>
<a href="/">Return to main page</a>
<h3>Available categories</h3>
<table>
    <tr>
        <th>Product category name</th>
    </tr>
    <c:forEach items="${productCategories}" var="cat">
        <tr>
            <td><c:out value="${cat.name}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
