<html>
<body>
<h2>Hello World!</h2>
<c:forEach items="${orders}" var="order">
  <tr>
   <td><c:out value="${order.id}" /></td>
   <td><c:out value="${order.customerId}" /></td>
   <td><c:out value="${order.productId}" /></td>
   <td><c:out value="${order.quantity}" /></td>
   <td><c:out value="${order.orderPrice}" /></td>
   <td><c:out value="${order.orderDate}" /></td>
  </tr>
 </c:forEach>
</body>
</html>
