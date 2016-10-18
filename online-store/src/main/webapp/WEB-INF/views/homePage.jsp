<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Online store</title>
</head>
<body>

    <jsp:include page="_header.jsp" />
    <jsp:include page="_menu.jsp" />

    <div>
        <h1>${welcome}</h1>
    </div>

    <div>
        <p>Categories</p>
        <ul>
            <c:forEach items="${categories}" var="category">
                <a href="<spring:url value="/products/category/${category.name}" />">${category.name}</a>
            </c:forEach>
        </ul>
    </div>

    <div>
        <p>Recommended for you</p>
        <c:forEach items="${products}" var="product">
            <div>
                <img src="/productImages/${product.id}" alt="product" style="width: 10%" />
                <p>${product.manufacturer.brand} ${product.model}</p>
                <p>${product.unitPrice}</p>
                <a href="<spring:url value="/products/${product.id}" />">Details</a>
                <security:authorize  access="!hasRole('ROLE_ADMIN')">
                    <a href="<spring:url value="/cart/buy?id=${product.id}" />">Add to cart</a>
                </security:authorize>
            </div>
        </c:forEach>
    </div>

    <div>
        <p>Go to the manufacturer's store</p>
        <c:forEach items="${manufacturers}" var="manufacturer">
            <img src="/manufacturerImages/${manufacturer.id}" alt="manufacturer" style="width: 5%" />
            <a href="<spring:url value="${manufacturer.website}" />">${manufacturer.brand}</a>
        </c:forEach>
    </div>

    <jsp:include page="_footer.jsp" />

</body>
</html>
