<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%--
  Created by IntelliJ IDEA.
  User: alxev
  Date: 07.09.2016
  Time: 1:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product was added successfully</title>
</head>
<body>
<h2>Product ${productName} was added to category ${categoryName} successfully</h2>
<a href="/">Return to main page</a>
<h3>Available products in category ${categoryName}</h3>
<table>
    <tr>
        <th>Product name</th>
        <th>Price</th>
        <th>Items available</th>
    </tr>
    <c:forEach items="${products}" var="prod">
        <tr>
            <td><c:out value="${prod.name}"/></td>
            <td><c:out value="${prod.price}"/></td>
            <td><c:out value="${prod.quantity}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
