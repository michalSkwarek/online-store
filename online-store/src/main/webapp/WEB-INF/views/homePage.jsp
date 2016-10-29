<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Online store</title>
</head>
<body>

    <div>
        <jsp:include page="_header.jsp" />
        <jsp:include page="_menu.jsp" />
    </div>

    <div>
        <h1><spring:message code="homePage.message.welcomeToOurOnlineStore" /></h1>
    </div>

    <div>
        <p><spring:message code="products" /></p>
        <ul>
            <c:forEach items="${categories}" var="category">
                <a href="<spring:url value="/products/category/${category.name}" />">${category.name}</a>
            </c:forEach>
        </ul>
    </div>

    <div>
        <p><spring:message code="homePage.message.recommendedForYou" /></p>
        <c:forEach items="${products}" var="product">
            <div>
                <img src="/productImages/${product.id}" alt="product" style="width: 10%" />
                <p>${product.manufacturer.brand} ${product.model}</p>
                <p>${product.unitPrice}</p>
                <a href="<spring:url value="/products/${product.id}" />"><spring:message code="products.details" /></a>
                <security:authorize  access="!hasRole('ROLE_ADMIN')">
                    <a href="<spring:url value="/order/addProduct?id=${product.id}" />"><spring:message code="products.addToCart" /></a>
                </security:authorize>
            </div>
        </c:forEach>
    </div>

    <div>
        <p><spring:message code="homePage.message.goToTheManufacturersStore" /></p>
        <c:forEach items="${manufacturers}" var="manufacturer">
            <img src="/manufacturerImages/${manufacturer.id}" alt="manufacturer" style="width: 5%" />
            <a href="<spring:url value="${manufacturer.website}" />">${manufacturer.brand}</a>
        </c:forEach>
    </div>

    <jsp:include page="_footer.jsp" />

</body>
</html>
