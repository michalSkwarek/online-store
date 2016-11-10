<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<section>
    <div class="content-frame">
        <div class="heading">
            <h1><spring:message code="orders.message.orderHistory" /></h1>
        </div>

        <c:if test="${empty orders}">
            <div class="info-view">
                <p><spring:message code="orders.message.yourOrderHistoryIsEmpty" /></p>
            </div>
        </c:if>

        <c:if test="${not empty orders}">
            <div>
                <table class="list-table">
                    <tr class="head">
                        <th><spring:message code="orders.message.number" /></th>
                        <th><spring:message code="orders.message.orderPrice" /></th>
                        <th><spring:message code="order.details.dateCreated.label" /></th>
                        <th><spring:message code="shippingDetails.details.dateDelivery.label" /></th>
                    </tr>
                    <c:set var="count" value="0" />
                    <c:forEach items="${orders}" var="order">
                        <c:set var="count" value="${count + 1}" />
                        <tr>
                            <td>${count}</td>
                            <td class="unit-price">${order.cart.cartTotalPrice} PLN</td>
                            <td><fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss" value="${order.dateCreated}" /></td>
                            <td><fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss" value="${order.shippingDetail.dateDelivery}" /></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </c:if>
    </div>
</section>
