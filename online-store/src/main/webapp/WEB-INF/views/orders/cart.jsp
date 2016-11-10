<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<section>
    <div class="content-frame">
        <div class="heading">
            <h1><spring:message code="orders.message.myCart" /></h1>
        </div>

        <div class="total-cart">
            <h1><spring:message code="cart.details.total.label" />: ${cart.cartTotalPrice} PLN</h1>
        </div>

        <c:if test="${cart.cartTotalPrice == 0}">
            <div class="info-view">
                <p><spring:message code="orders.message.thisCartIsEmpty" /></p>
            </div>
        </c:if>

        <div class="product">
            <form:form method="post" modelAttribute="cart">
                <c:forEach items="${cart.items}" var="item" varStatus="varStatus">
                    <div class="frame">
                        <img src="/productImages/${item.product.id}" alt="product" width="230px" />
                        <p>${item.product.manufacturer.brand} ${item.product.model}</p>
                        <p>${item.product.unitPrice} PLN</p>
                        <p>${item.product.category.name}</p>

                        <div class="box">
                            <%--<div class="error">--%>
                                <%--<form:errors path="quantity" />--%>
                            <%--</div>--%>
                            <label class="title">
                                <spring:message code="item.details.quantity.label" />
                            </label>
                            <div>
                                <input type="text" name="quantity" value="${item.quantity}">
                            </div>
                        </div>

                        <p><spring:message code="item.details.totalPrice.label" />: ${item.itemTotalPrice} PLN</p>

                        <div>
                            <a href="<spring:url value="/order/deleteProduct?id=${item.product.id}" />">
                                <button type="button" class="button-add-to-cart"><spring:message code="orders.message.deleteFromCart" /></button>
                            </a>
                        </div>
                    </div>
                </c:forEach>

                <c:if test="${cart.cartTotalPrice != 0}">
                    <div>
                        <input type="submit" class="button-edit" value="<spring:message code="edit" />"/>
                    </div>
                </c:if>

                <div>
                    <a href="<spring:url value="/products/list" />">
                        <button type="button" class="button-save"><spring:message code="orders.message.continueBuy" /></button>
                    </a>
                </div>

                <c:if test="${cart.cartTotalPrice != 0}">
                    <security:authorize access="!hasRole('ROLE_USER')">
                        <div>
                            <a href="<spring:url value="/login" />">
                                <button type="button" class="button-save">
                                    <spring:message code="orders.message.enterShippingAddress" />
                                    (<spring:message code="orders.message.youMustLoginFirst" />)
                                </button>
                            </a>
                        </div>
                    </security:authorize>
                    <security:authorize access="hasRole('ROLE_USER')">
                        <div>
                            <a href="<spring:url value="/order/${pageContext.request.userPrincipal.name}/address" />">
                                <button type="button" class="button-save"><spring:message code="orders.message.enterShippingAddress" /></button>
                            </a>
                        </div>
                    </security:authorize>
                </c:if>
            </form:form>
        </div>
    </div>
</section>