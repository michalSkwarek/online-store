<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<section>
    <div class="welcome">
        <p><spring:message code="homePage.message.welcomeToOurOnlineStore" /></p>
    </div>

    <div class="category">
        <p class="heading"><spring:message code="homePage.message.categories" /></p>
        <div>
            <c:forEach items="${categories}" var="category">
                <a href="<spring:url value="/products/category/${category.name}" />">${category.name}</a>
            </c:forEach>
        </div>
    </div>

    <div class="product">
        <p class="heading"><spring:message code="homePage.message.recommendedForYou" /></p>
        <c:forEach items="${products}" var="product">
            <div>
                <img src="/productImages/${product.id}" alt="product" width="230px" />
                <p>${product.manufacturer.brand} ${product.model}</p>
                <p>${product.unitPrice} PLN</p>
                <a href="<spring:url value="/products/${product.id}" />"><spring:message code="products.message.details" /></a>
                <security:authorize  access="!hasRole('ROLE_ADMIN')">
                    <a href="<spring:url value="/order/addProduct?id=${product.id}" />"><spring:message code="products.message.addToCart" /></a>
                </security:authorize>
            </div>
        </c:forEach>
    </div>

    <div class="manufacturer">
        <p class="heading"><spring:message code="homePage.message.goToTheManufacturersStore" /></p>
        <c:forEach items="${manufacturers}" var="manufacturer">
            <a href="<spring:url value="${manufacturer.website}" />">
                <img src="/manufacturerImages/${manufacturer.id}" alt="manufacturer" width="64px" />
            </a>
        </c:forEach>
    </div>
</section>
