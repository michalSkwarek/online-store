<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My cart</title>
</head>
<body>

    <section>
        <div>
            <jsp:include page="../_header.jsp" />
            <jsp:include page="../_menu.jsp" />
        </div>
    </section>

    <section>
        <div>
            <spring:message code="productData.messages.productData" />
        </div>

        <c:if test="${cart.cartTotalPrice == 0}">
            <div>
                <p><spring:message code="orders.message.thisCartIsEmpty" /></p>
            </div>
        </c:if>

        <form:form method="post" modelAttribute="cart">
            <c:forEach items="${cart.items}" var="item" varStatus="varStatus">
                <div>
                    <img src="/productImages/${item.product.id}" alt="product" style="width: 10%" />
                </div>

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
                    <label><spring:message code="manufacturer.details.brand.label" /></label>
                        ${item.product.manufacturer.brand}
                </div>

                <div>
                    <label><spring:message code="item.details.quantity.label" /></label>
                    <input type="text" name="quantity" value="${item.quantity}">
                </div>

                <div>
                    <label><spring:message code="item.details.totalPrice.label" /></label>
                        ${item.itemTotalPrice}
                </div>

                <div>
                    <a href="<spring:url value="/order/deleteProduct?id=${item.product.id}" />"><spring:message code="orders.message.deleteFromCart" /></a>
                </div>
            </c:forEach>

            <c:if test="${cart.cartTotalPrice != 0}">
                <div>
                    <input type="submit" value="<spring:message code="edit" />"/>
                </div>
            </c:if>

            <div>
                <a href="<spring:url value="/products/list" />"><spring:message code="orders.message.continueBuy" /></a>
            </div>
        </form:form>
    </section>


    <h1><spring:message code="cart.details.total.label" />: ${cart.cartTotalPrice} PLN</h1>

    <c:if test="${cart.cartTotalPrice != 0}">
        <div>
            <security:authorize access="!hasRole('ROLE_USER')">
                <div>
                    <a href="<spring:url value="/login" />">
                        <spring:message code="orders.message.enterShippingAddress" />
                        (<spring:message code="orders.message.youMustLoginFirst" />)
                    </a>
                </div>
            </security:authorize>
            <security:authorize access="hasRole('ROLE_USER')">
                <div>
                    <a href="<spring:url value="/order/${pageContext.request.userPrincipal.name}/address" />"><spring:message code="orders.message.enterShippingAddress" /></a>
                </div>
            </security:authorize>
        </div>
    </c:if>

    <jsp:include page="../_footer.jsp" />

</body>
</html>
