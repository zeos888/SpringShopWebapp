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
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Create new order</title>
</head>
<body>
<h2>Place an order</h2>
<h3>Choose product category:</h3>
<form>
    <select name="Categories" title="Categories">
        <c:forEach items="${categories}" var="cat">
            <option value="${cat.name}">
                <c:out value="${cat.name}"/>
            </option>
        </c:forEach>
    </select>
    <p><input type="submit" value="submit"></p>
</form>
<%
    String[] c = request.getParameterValues("Categories");
    if(c != null)
    {
%>
<p><b>Select product</b></p>
<ul>
    <%
        for(int i=0; i<c.length; i++)
        {
    %>
    <li><%=c[i]%></li>
    <%
        }
    %>
</ul>
<%
    }
%>
</body>
</html>
