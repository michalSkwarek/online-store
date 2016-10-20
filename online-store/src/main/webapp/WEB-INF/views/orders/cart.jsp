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

    <jsp:include page="../_header.jsp" />
    <jsp:include page="../_menu.jsp" />

    <h1>Product data</h1>

    <c:if test="${cart.cartTotalPrice == 0}">
        <p>This cart is empty</p>
    </c:if>

    <form:form method="post" modelAttribute="cart">

        <c:forEach items="${cart.items}" var="item" varStatus="varStatus" >
            <ul>
                <li>
                    <img src="/productImages/${item.product.id}" alt="product" style="width: 10%" />
                </li>

                <li>
                    <label>Model: </label>
                        ${item.product.model}
                </li>

                <li>
                    <label>Unit price: </label>
                        ${item.product.unitPrice}
                </li>

                <li>
                    <label>Category: </label>
                        ${item.product.category.name}
                </li>

                <li>
                    <label>Manufacturer: </label>
                        ${item.product.manufacturer.brand}
                </li>

                <li>
                    <label for="quantity">Quantity: </label>
                    <form:input path="items[${varStatus.index}].quantity" id="quantity"/>
                </li>

                <li>
                    <label>Total price: </label>
                        ${item.itemTotalPrice}
                </li>

                <li>
                    <a href="<spring:url value="/cart/deleteProduct?id=${item.product.id}" />">Delete from cart</a>
                </li>
            </ul>
        </c:forEach>

        <c:if test="${cart.cartTotalPrice != 0}">
            <li>
                <input type="submit" value="Update"/>
            </li>
        </c:if>

        <li>
            <a href="<spring:url value="/products/list" />">Continue buy</a>
        </li>

    </form:form>

    <h1>Total: ${cart.cartTotalPrice} PLN</h1>

    <div>
        <security:authorize access="!hasRole('ROLE_USER')">
            <ul>
                <li><a href="<spring:url value="/login" />">Enter shipping address (You must login first)</a></li>
            </ul>
        </security:authorize>
        <security:authorize access="hasRole('ROLE_USER')">
            <ul>
                <li><a href="<spring:url value="/cart/${pageContext.request.userPrincipal.name}/address" />">Enter shipping address</a></li>
            </ul>
        </security:authorize>
    </div>

    <jsp:include page="../_footer.jsp" />

</body>
</html>
