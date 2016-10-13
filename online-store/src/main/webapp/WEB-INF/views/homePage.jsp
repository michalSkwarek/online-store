<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
                <img src="<c:url value="/resources/images/my_image.jpg" />" alt="image" style="width: 25%" />
                <p>${product.manufacturer.brand} ${product.model}</p>
                <p>${product.unitPrice}</p>
                <a href="<spring:url value="/products/${product.id}" />">Details</a>
            </div>
        </c:forEach>
    </div>

    <div>
        <p>Go to the manufacturer's store</p>
        <c:forEach items="${manufacturers}" var="manufacturer">
            <img src="<c:url value="/resources/images/my_image.jpg" />" alt="image" style="width: 5%" />
            <a href="<spring:url value="${manufacturer.website}" />">${manufacturer.brand}</a>
        </c:forEach>
    </div>

    <jsp:include page="_footer.jsp" />

</body>
</html>
