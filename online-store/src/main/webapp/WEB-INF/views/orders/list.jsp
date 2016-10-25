<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order history</title>
</head>
<body>

    <jsp:include page="../_header.jsp" />
    <jsp:include page="../_menu.jsp" />

    <c:if test="${empty orders}">
        <h1>Your order history is empty</h1>
    </c:if>

    <c:if test="${not empty orders}">
        <h1>Order history</h1>

        <div>
            <table>
                <tr>
                    <td>Number</td>
                    <td>Order price</td>
                    <td>Date created</td>
                    <td>Date delivery</td>
                </tr>

                <c:set var="count" value="0" />
                <c:forEach items="${orders}" var="order">
                    <c:set var="count" value="${count + 1}" />
                    <tr>
                        <td>${count}</td>
                        <td>${order.cart.cartTotalPrice}</td>
                        <td>${order.dateCreated}</td>
                        <td>${order.shippingDetail.dateDelivery}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>

    </c:if>

    <jsp:include page="../_footer.jsp" />

</body>
</html>
