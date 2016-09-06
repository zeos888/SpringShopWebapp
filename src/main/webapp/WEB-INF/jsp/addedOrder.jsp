<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%--
  Created by IntelliJ IDEA.
  User: alxev
  Date: 07.09.2016
  Time: 2:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order successfully placed</title>
</head>
<body>
<h2>Successfully placed order: ${quantity} items of product ${productName} was sold to customer ${customerName}</h2>
<a href="/">Return to main page</a>
<h3>All orders placed by ${customerName}</h3>
<table>
    <tr>
        <th>Order date</th>
        <th>Customer id</th>
        <th>Product id</th>
        <th>Quantity</th>
        <th>Order price</th>
    </tr>
    <c:forEach items="${ordersByCustomer}" var="ord">
        <tr>
            <td><c:out value="${ord.orderDate}"/></td>
            <td><c:out value="${ord.productId}"/></td>
            <td><c:out value="${ord.quantity}"/></td>
            <td><c:out value="${ord.orderPrice}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
