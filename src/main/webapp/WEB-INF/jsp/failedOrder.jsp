<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%--
  Created by IntelliJ IDEA.
  User: alxev
  Date: 07.09.2016
  Time: 2:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order was NOT placed. Failed to place an order</title>
</head>
<body>
<h2>Could not place an order: ${orderQuantity} items of product ${productName} is not available. Only available ${productQuantity}</h2>
<a href="javascript:history.back()">Back to order</a>
</body>
</html>
