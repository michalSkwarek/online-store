<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Confirm order</title>
</head>
<body>

    <section>
        <div>
            <jsp:include page="../_header.jsp" />
            <jsp:include page="../_menu.jsp" />
        </div>
    </section>

    <section>
        <form:form method="post">
            <fieldset>
                <legend>
                    <spring:message code="orders.message.confirmOrder" />
                </legend>

                <security:authorize  access="hasRole('ROLE_USER')">
                    <div>
                        <label><spring:message code="customer.details.firstName.label" /></label>
                            ${account.customer.firstName}
                    </div>

                    <div>
                        <label><spring:message code="customer.details.lastName.label" /></label>
                            ${account.customer.lastName}
                    </div>

                    <div>
                        <label><spring:message code="customer.details.phoneNumber.label" /></label>
                            ${account.customer.phoneNumber}
                    </div>

                    <div>
                        <label><spring:message code="address.details.street.label" /></label>
                            ${shippingAddress.street}
                    </div>

                    <div>
                        <label><spring:message code="address.details.streetNumber.label" /></label>
                            ${shippingAddress.streetNumber}
                    </div>

                    <div>
                        <label><spring:message code="address.details.doorNumber.label" /></label>
                            ${shippingAddress.doorNumber}
                    </div>

                    <div>
                        <label><spring:message code="address.details.zipCode.label" /></label>
                            ${shippingAddress.zipCode}
                    </div>

                    <div>
                        <label><spring:message code="address.details.city.label" /></label>
                            ${shippingAddress.city.name}
                    </div>

                    <div>
                        <c:forEach items="${cart.items}" var="item">
                            <div>
                                <label><spring:message code="product.details.model.label" /></label>
                                    ${item.product.model}
                            </div>

                            <div>
                                <label><spring:message code="product.details.unitPrice.label" /></label>
                                    ${item.product.unitPrice}
                            </div>

                            <div>
                                <label><spring:message code="product.details.category.label" /></label>
                                    ${item.product.category.name}
                            </div>

                            <div>
                                <label><spring:message code="product.details.manufacturer.label" /></label>
                                    ${item.product.manufacturer.brand}
                            </div>

                            <div>
                                <label><spring:message code="item.details.quantity.label" /></label>
                                    ${item.quantity}
                            </div>

                            <div>
                                <label><spring:message code="item.details.totalPrice.label" /></label>
                                    ${item.itemTotalPrice}
                            </div>
                        </c:forEach>
                    </div>
                </security:authorize>

                <div>
                    <h1><spring:message code="cart.details.total.label" />: ${cart.cartTotalPrice} PLN</h1>
                </div>

                <div>
                    <input type="submit" value="<spring:message code="confirm" />">
                </div>
            </fieldset>
        </form:form>

        <div>
            <a href="<spring:url value="/order/cancel" />"><spring:message code="cancel" /></a>
        </div>
    </section>

    <jsp:include page="../_footer.jsp" />

</body>
</html>
