<%@ page import="org.spring.entity.Order" %>
<%@ page import="java.util.List" %>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ page isELIgnored="false" %>
<html>
<body>
<h2>Hello World!</h2>

<%
    List<Order> data =  (List<Order>) request.getAttribute("orders");
%>

<table>
    <%
        for (Order order : data) {
            %>
                <tr><td><%=order.getId()%></td><td><%=order.getQuantity()%></td></tr>
            <%
        }
    %>
</table>

<table>
<%--<c:forEach items="${requestScope.get('orders')}" var="order">--%>
<%--@elvariable id="data" type="java.util.List<Order>"--%>
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
</table>
</body>
</html>