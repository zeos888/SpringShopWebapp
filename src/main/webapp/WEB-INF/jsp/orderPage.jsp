<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%--
  Created by IntelliJ IDEA.
  User: ovoyevodin
  Date: 06.09.2016
  Time: 19:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new order</title>
</head>
<body>
<h2>Place an order</h2>
<h3>Choose product category:</h3>
<td>
    <select label="Categories" name="Categories" onselect="">
        <c:forEach items="${categories}" var="cat">
            <option value="${cat.name}">
                <c:out value="${cat.name}"/>
            </option>
        </c:forEach>
    </select>
</td>
</body>
</html>
