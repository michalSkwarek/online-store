<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All products</title>
</head>
<body>

    <jsp:include page="../_header.jsp" />
    <jsp:include page="../_menu.jsp" />

    <form:form>

        <div>
            <p>Select categories:</p>
            <c:forEach items="${categories}" var="category" >
                <label>
                    <input type="checkbox" name="category" value="${category.name}">${category.name}
                </label>
            </c:forEach>

            <p>Select manufacturers:</p>
            <c:forEach items="${manufacturers}" var="manufacturer" >
                <label>
                    <input type="checkbox" name="manufacturer" value="${manufacturer.brand}">${manufacturer.brand}
                </label>
            </c:forEach>

            <p>Select price range:</p>
            <label>
                Od: <input type="text" name="fromPriceRange">
                Do: <input type="text" name="toPriceRange">
            </label>

            <p>Select order:</p>
            <label>
                <input type="radio" name="priceOrder" value="asc" checked>Ascending
                <input type="radio" name="priceOrder" value="desc">Descending
            </label>
        </div>

        <br/>
        <input type="submit" value="Submit"/>

    </form:form>

    <div>
        <p>List of all products</p>
        <c:forEach items="${products}" var="product">
            <div>
                <img src="/productImages/${product.id}" alt="product" style="width: 10%" />
                <p>${product.manufacturer.brand} ${product.model}</p>
                <p>${product.unitPrice}</p>
                <p>${product.category.name}</p>
                <a href="<spring:url value="/products/${product.id}" />">Details</a>
                <security:authorize  access="!hasRole('ROLE_ADMIN')">
                    <a href="<spring:url value="/order/addProduct?id=${product.id}" />">Add to cart</a>
                </security:authorize>
            </div>
        </c:forEach>
    </div>

    <jsp:include page="../_footer.jsp" />

</body>
</html>