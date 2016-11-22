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
                <a href="<spring:url value="/products/category/${category.name}" />">
                    <button type="button" class="button-category">${category.name}</button>
                </a>
            </c:forEach>
        </div>
    </div>

    <div class="product">
        <p class="heading"><spring:message code="homePage.message.recommendedForYou" /></p>
        <c:forEach items="${products}" var="product">
            <div class="product-frame">
                <img src="/productImages/${product.id}" alt="product" width="230px" />
                <p>${product.manufacturer.brand} ${product.model}</p>
                <p>${product.unitPrice} PLN</p>
                <div>
                    <a href="<spring:url value="/products/${product.id}" />">
                        <button type="button" class="button-details"><spring:message code="products.message.details" /></button>
                    </a>
                </div>
                <security:authorize  access="!hasRole('ROLE_ADMIN')">
                    <div>
                        <a href="<spring:url value="/order/addProduct?id=${product.id}" />">
                            <button type="button" class="button-add-to-cart"><spring:message code="products.message.addToCart" /></button>
                        </a>
                    </div>
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
