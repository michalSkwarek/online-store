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

    <section>
        <div>
            <jsp:include page="../_header.jsp" />
            <jsp:include page="../_menu.jsp" />
        </div>
    </section>

    <section>
        <form:form method="post">

            <div>
                <div>
                    <p><spring:message code="productsList.message.selectCategories" /></p>
                    <c:forEach items="${categories}" var="category">
                        <label>
                            <input type="checkbox" name="category" value="${category.name}">${category.name}
                        </label>
                    </c:forEach>
                </div>

                <div>
                    <p><spring:message code="productsList.message.selectManufacturers" /></p>
                    <c:forEach items="${manufacturers}" var="manufacturer" >
                        <label>
                            <input type="checkbox" name="manufacturer" value="${manufacturer.brand}">${manufacturer.brand}
                        </label>
                    </c:forEach>
                </div>

                <div>
                    <p><spring:message code="productsList.message.selectPriceRange" /></p>
                    <label>
                        <spring:message code="productsList.from" /> <input type="text" name="fromPriceRange">
                        <spring:message code="productsList.to" /> <input type="text" name="toPriceRange">
                    </label>
                </div>

                <div>
                    <p><spring:message code="productsList.message.selectPriceOrder" /></p>
                    <label>
                        <input type="radio" name="priceOrder" value="asc" checked><spring:message code="productsList.message.selectPriceOrder.ascending" />
                        <input type="radio" name="priceOrder" value="desc"><spring:message code="productsList.message.selectPriceOrder.descending" />
                    </label>
                </div>
            </div>

            <div>
                <input type="submit" value="<spring:message code="submit" />" />
            </div>

        </form:form>

        <div>
            <p><spring:message code="productsList.message.allProducts" /></p>
            <c:forEach items="${products}" var="product">
                <div>
                    <img src="/productImages/${product.id}" alt="product" style="width: 10%" />
                    <p>${product.manufacturer.brand} ${product.model}</p>
                    <p>${product.unitPrice}</p>
                    <p>${product.category.name}</p>
                    <a href="<spring:url value="/products/${product.id}" />"><spring:message code="products.details" /></a>
                    <security:authorize  access="!hasRole('ROLE_ADMIN')">
                        <a href="<spring:url value="/order/addProduct?id=${product.id}" />"><spring:message code="products.addToCart" /></a>
                    </security:authorize>
                </div>
            </c:forEach>
        </div>
    </section>

    <jsp:include page="../_footer.jsp" />

</body>
</html>