<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%--
  Created by IntelliJ IDEA.
  User: ovoyevodin
  Date: 06.09.2016
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Little Spring Shop</title>
</head>
<body>
<h1>Little Spring Shop</h1>
<br>
<a href="/newOrder/">Place an order</a>
<a href="/newProduct/">Add new product</a>
<a href="/newProductCategory/">Add new product category</a>
<a href="/newCustomer/">Add new customer</a>
<h3>Available product categories</h3>
<table>
    <tr>
        <th>Category name</th>
    </tr>
    <c:forEach items="${categories}" var="cat">
        <tr>
            <td><c:out value="${cat.name}"></c:out></td>
        </tr>
    </c:forEach>
</table>
<h3>Available products</h3>
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
<h3>Known customers</h3>
<table>
    <tr>
        <th>Customer name</th>
        <th>Email</th>
    </tr>
    <c:forEach items="${customers}" var="cust">
        <tr>
            <td><c:out value="${cust.name}"/></td>
            <td><c:out value="${cust.email}"/></td>
        </tr>
    </c:forEach>
</table>
<h3>Orders placed</h3>
<table>
    <tr>
        <th>Order date</th>
        <th>Customer id</th>
        <th>Product id</th>
        <th>Quantity</th>
        <th>Order price</th>
    </tr>
    <c:forEach items="${orders}" var="ord">
        <tr>
            <td><c:out value="${ord.orderDate}"/></td>
            <td><c:out value="${ord.customerId}"/></td>
            <td><c:out value="${ord.productId}"/></td>
            <td><c:out value="${ord.quantity}"/></td>
            <td><c:out value="${ord.orderPrice}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
