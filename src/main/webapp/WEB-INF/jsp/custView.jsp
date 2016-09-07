<%--
  Created by IntelliJ IDEA.
  User: red21
  Date: 9/6/2016
  Time: 2:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<html>
<head>
    <title>Customers</title>
</head>
<body>
<ul>
    <c:forEach var="customer" items="${customers}">
        <li>${customer}</li>
    </c:forEach>
</ul>

<h3>Choose an author:</h3>
<form method="get">
    <input type="checkbox" name="author" value="Tan Ah Teck">Tan
    <input type="checkbox" name="author" value="Mohd Ali">Ali
    <input type="checkbox" name="author" value="Kumar">Kumar
    <input type="submit" value="Query">
</form>

<%
    String[] authors = request.getParameterValues("author");
    if (authors != null) {
%>
<h3>You have selected author(s):</h3>
<ul>
    <%
        for (int i = 0; i < authors.length; ++i) {
    %>
    <li><%= authors[i] %></li>
    <%
        }
    %>
</ul>
<a href="/viewCustM">BACK</a>
<%
    }
%>
</body>
</html>
