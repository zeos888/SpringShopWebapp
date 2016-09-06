<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%--
  Created by IntelliJ IDEA.
  User: alxev
  Date: 07.09.2016
  Time: 0:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new product</title>
</head>
<body>
<form:form method="post" action="/addProduct/" modelAttribute="newProduct">
    <table>
        <tr>
            <td><form:label path="productCategoryId">Product category</form:label></td>
            <td><form:select path="productCategoryId" items="${categories}" itemLabel="name" itemValue="id"/>
                <%--<select name="Categories" title="Categories">--%>
                    <%--<c:forEach items="${categories}" var="cat">--%>
                        <%--<option value="${cat.id}">--%>
                            <%--<c:out value="${cat.name}"/>--%>
                        <%--</option>--%>
                    <%--</c:forEach>--%>
                <%--</select>--%>
            </td>
        </tr>
        <tr>
            <td><form:label path="name">Product name</form:label></td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td><form:label path="description">Product description</form:label></td>
            <td><form:input path="description"/></td>
        </tr>
        <tr>
            <td><form:label path="price">Product description</form:label></td>
            <td><form:input path="price"/></td>
        </tr>
        <tr>
            <td><form:label path="quantity">Product description</form:label></td>
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