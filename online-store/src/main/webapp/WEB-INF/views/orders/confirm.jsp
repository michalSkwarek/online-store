<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<section>
    <div class="form">
        <form:form method="post">
            <fieldset>
                <legend>
                    <spring:message code="orders.message.confirmOrder" />
                </legend>

                <security:authorize  access="hasRole('ROLE_USER')">
                    <div class="box">
                        <label class="title">
                            <spring:message code="customer.details.firstName.label" />
                        </label>
                        <div class="field">
                            ${account.customer.firstName}
                        </div>
                    </div>

                    <div class="box">
                        <label class="title">
                            <spring:message code="customer.details.lastName.label" />
                        </label>
                        <div class="field">
                            ${account.customer.lastName}
                        </div>
                    </div>

                    <div class="box">
                        <label class="title">
                            <spring:message code="customer.details.phoneNumber.label" />
                        </label>
                        <div class="field">
                            ${account.customer.phoneNumber}
                        </div>
                    </div>

                    <div class="box">
                        <label class="title">
                            <spring:message code="address.details.street.label" />
                        </label>
                        <div class="field">
                                ${shippingAddress.street}
                        </div>
                    </div>

                    <div class="box">
                        <label class="title">
                            <spring:message code="address.details.streetNumber.label" />
                        </label>
                        <div class="field">
                                ${shippingAddress.streetNumber}
                        </div>
                    </div>

                    <div class="box">
                        <label class="title">
                            <spring:message code="address.details.doorNumber.label" />
                        </label>
                        <div class="field">
                                ${shippingAddress.doorNumber}
                        </div>
                    </div>

                    <div class="box">
                        <label class="title">
                            <spring:message code="address.details.zipCode.label" />
                        </label>
                        <div class="field">
                                ${shippingAddress.zipCode}
                        </div>
                    </div>

                    <div class="box">
                        <label class="title">
                            <spring:message code="address.details.city.label" />
                        </label>
                        <div class="field">
                                ${shippingAddress.city.name}
                        </div>
                    </div>

                    <div class="total-cart">
                        <h1><spring:message code="cart.details.total.label" />: ${cart.cartTotalPrice} PLN</h1>
                    </div>

                    <div class="product-order-confirm">
                        <c:forEach items="${cart.items}" var="item">
                                <div class="frame">
                                    <img src="/productImages/${item.product.id}" alt="product" width="230px" />
                                    <p>${item.product.manufacturer.brand} ${item.product.model}</p>
                                    <p>${item.product.unitPrice} PLN</p>
                                    <p>${item.product.category.name}</p>
                                    <p><spring:message code="item.details.quantity.label" />: ${item.quantity}</p>
                                    <p><spring:message code="item.details.totalPrice.label" />: ${item.itemTotalPrice} PLN</p>
                                </div>
                        </c:forEach>
                    </div>
                </security:authorize>

                <div>
                    <input type="submit" class="button-save" value="<spring:message code="confirm" />">
                </div>

                <div>
                    <a href="<spring:url value="/order/cancel" />">
                        <button type="button" class="button-cancel"><spring:message code="cancel" /></button>
                    </a>
                </div>
            </fieldset>
        </form:form>
    </div>
</section>
