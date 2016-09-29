<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%--
  Created by IntelliJ IDEA.
  User: alxev
  Date: 07.09.2016
  Time: 2:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Place new order</title>
</head>
<body>
<form:form method="post" action="/addOrder/" modelAttribute="newOrder">
    <table>
        <tr>
            <td>Product</td>
            <td><form:select path="product" items="${products}" itemLabel="name" itemValue="id"/></td>
        </tr>
        <tr>
            <td>Customer</td>
            <td><form:select path="customer" items="${customers}" itemLabel="name" itemValue="id"/></td>
        </tr>
        <tr>
            <td><form:label path="quantity">Quantity</form:label></td>
            <td><form:input path="quantity"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="submit"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
