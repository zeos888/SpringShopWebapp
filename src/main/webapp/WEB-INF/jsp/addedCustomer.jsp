<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%--
  Created by IntelliJ IDEA.
  User: alxev
  Date: 07.09.2016
  Time: 2:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer was added successfully</title>
</head>
<body>
<h2>Customer ${customerName} was added successfully</h2>
<a href="/">Return to main page</a>
<h3>Available customers</h3>
<table>
    <tr>
        <th>Customer name</th>
        <th>Customer email</th>
    </tr>
    <c:forEach items="${customers}" var="cust">
        <tr>
            <td><c:out value="${cust.name}"/></td>
            <td><c:out value="${cust.email}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
