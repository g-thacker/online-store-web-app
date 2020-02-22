<%--
  Created by IntelliJ IDEA.
  User: gthacker
  Date: 5/3/19
  Time: 7:37 PM

  THE INSTRUCTIONS FOR THIS ASSIGNMENT WERE EXTREMELY LACKING AND THE PROJECT SPECS WERE NOT CLEARLY DEFINED.
  I HAVE INCORPORATED EVERYTHING THE PROFESSOR MADE CLEAR THAT HE WANTED, REGARDLESS OF HOW MUCH SENSE IT ACTUALLY MADE.
  THE CART DOES NOT DISPLAY A TOTAL BECAUSE I WAS NOT TOLD TO DISPLAY ONE.
  THE DATABASE STORES QUANTITY, BECAUSE IT WAS INCLUDED ON THE LIST OF THINGS TO STORE.
        (THIS MAKES NO SENSE, AS THE DATABASE DOES NOT TRACK INVENTORY, AND THE CART QUANTITIES ARE STORED IN AN
            ARRAYLIST, SO THE QUANTITY COLUMN IS NEVER USED...)
  THE STYLING IS MINIMAL, AS WE WERE NOT TOLD TO CONCERN OURSELVES WITH THAT. THE SMALL BIT OF CSS I'VE ADDED IS
        INCLUDED FOR EASE OF VIEWING, NOT TO FULFILL ANY STATED REQUIREMENT.
  ANY FUNCTIONALITY OR STYLING THAT SEEMS TO BE MISSING FROM THIS WEB APP WAS ALSO MISSING FROM THE INSTRUCTIONS. I READ
  THEM OVER MULTIPLE TIMES TO VERIFY THAT THIS SATISFIES THEM.

  --get26

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
<table class="productsTable" border="1">
    <tr>
        <td colspan="2" align="center">
            <h1>Tracksuit Warehouse</h1>
        </td>
    </tr>
    <tr>
        <c:forEach items="${productArrayList}" var="thisProduct" varStatus="loopCounter">
        <td>
            <form action="cart" method="post">
                <div class="productListing" align="center">
                    <input type="hidden" name="thisAction" value="add">
                    <input type="hidden" name="thisId" value="${thisProduct.prodId}">
                    <input type="hidden" name="thisDesc" value="${thisProduct.prodDesc}">
                    <input type="hidden" name="thisPrice" value="${thisProduct.prodPrice}">
                    <label for="${thisProduct.prodId}">
                        <img src="${thisProduct.prodPictLocation}" width="200" height="200" alt="${thisProduct.prodDesc}"><br><br>
                        <span>${thisProduct.prodDesc}</span><br><br>
                        <span><fmt:formatNumber pattern="$##,###.00" value="${thisProduct.prodPrice}" /></span><br><br>
                        <input type="number" id="${thisProduct.prodId}" name="thisQuantity" required><br><br>
                        <input type="submit" value="Add">
                    </label><br><br>
                </div>
            </form>
        </td>
        <c:if test="${loopCounter.count % 2 == 0}">
    <tr></tr>
    </c:if>
    </c:forEach>
    </tr>
    <tr>
        <td colspan="2" align="center">
            <form action="cart" method="post">
                <br>
                <input type="hidden" name="thisAction" value="checkout">
                <input type="submit" value="Checkout">
            </form>
        </td>
    </tr>
</table>
</body>
</html>
