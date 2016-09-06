<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%--
  Created by IntelliJ IDEA.
  User: alxev
  Date: 07.09.2016
  Time: 1:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new product category</title>
</head>
<body>
<form:form method="post" action="/addProductCategory/" modelAttribute="newProductCategory">
    <table>
        <tr>
            <td><form:label path="name">Product category name</form:label></td>
            <td><form:input path="name"/></td>
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
