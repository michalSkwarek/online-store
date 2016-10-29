<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order history</title>
</head>
<body>

    <section>
        <div>
            <jsp:include page="../_header.jsp" />
            <jsp:include page="../_menu.jsp" />
        </div>
    </section>

    <section>
        <c:if test="${empty orders}">
            <h1><spring:message code="orders.message.yourOrderHistoryIsEmpty" /></h1>
        </c:if>

        <c:if test="${not empty orders}">
            <div>
                <h1><spring:message code="orders.message.orderHistory" /></h1>
            </div>

            <div>
                <table>
                    <tr>
                        <td><spring:message code="orders.message.number" /></td>
                        <td><spring:message code="orders.message.orderPrice" /></td>
                        <td><spring:message code="order.details.dateCreated.label" /></td>
                        <td><spring:message code="shippingDetails.details.dateDelivery.label" /></td>
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
    </section>

    <jsp:include page="../_footer.jsp" />

</body>
</html>
