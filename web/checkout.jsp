<%--
  Created by IntelliJ IDEA.
  User: gthacker
  Date: 5/3/19
  Time: 7:03 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Tracksuit Warehouse</title>
    <link rel="stylesheet" href="prettyfly.css" type="text/css">
</head>
<body>
<c:if test="${sessionScope.sender == null}">
    <c:redirect url="index.jsp" />
</c:if>
<table border="1">
    <tr>
        <td colspan="4" align="center">
            <h1>Shopping Cart</h1>
        </td>
    </tr>
    <tr>
        <th>Product ID</th>
        <th>Description</th>
        <th>Price</th>
        <th>Quantity</th>
    </tr>
    <c:forEach items="${thisCart}" var="entry">
    <tr>
        <td>
                ${entry.prodId}
        </td>
        <td>
                ${entry.prodDesc}
        </td>
        <td>
                <fmt:formatNumber pattern="$##,###.00" value="${entry.prodPrice}"/>
        </td>
        <td>
            <form action="cart" method="post">
                <input type="number" name="newQuant" value="${entry.prodQuant}">
                <input type="hidden" name="thisAction" value="update">
                <input type="hidden" name="targetId" value="${entry.prodId}">
                <input type="submit" value="Update">
            </form>
        </td>
        </c:forEach>
    </tr>
</table>
<c:out value="${pageContext.session.id}" /> <%--print session ID--%>
Sending page: <c:out value="${sessionScope.sender}" />
<%--<c:forEach var="c" items="${cookies}">
    <span>${c.name}:${c.value}</span> display name and value for each cookie
</c:forEach> --%>
</body>
</html>
