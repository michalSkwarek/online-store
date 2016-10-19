<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Confirm order</title>
</head>
<body>

    <jsp:include page="../_header.jsp" />
    <jsp:include page="../_menu.jsp" />

    <div>
        <security:authorize access="hasRole('ROLE_ADMIN')">
            <ul>
                <li><a href="<spring:url value="/admin/products/list" />">Products</a></li>
                <li><a href="<spring:url value="/admin/manufacturers/list" />">Manufacturers</a></li>
            </ul>
        </security:authorize>
    </div>

    <h1>Confirm order</h1>

    <security:authorize  access="hasRole('ROLE_USER')">

        <ul>
            <li>
                <label>First name: </label>
                    ${account.customer.firstName}
            </li>

            <li>
                <label>Last name: </label>
                    ${account.customer.lastName}
            </li>

            <li>
                <label>Phone number: </label>
                    ${account.customer.phoneNumber}
            </li>

            <li>
                <label>Street: </label>
                    ${account.customer.billingAddress.street}
            </li>

            <li>
                <label>Street number: </label>
                    ${account.customer.billingAddress.streetNumber}
            </li>

            <li>
                <label>Door number: </label>
                    ${account.customer.billingAddress.doorNumber}
            </li>

            <li>
                <label>Zip code: </label>
                    ${account.customer.billingAddress.zipCode}
            </li>

            <li>
                <label>City: </label>
                    ${account.customer.billingAddress.city.name}
            </li>
        </ul>

        <c:forEach items="${cart.items}" var="item" varStatus="varStatus" >
            <ul>
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
                    <label>Quantity: </label>
                        ${item.quantity}
                </li>

                <li>
                    <label>Total price: </label>
                        ${item.itemTotalPrice}
                </li>
            </ul>
        </c:forEach>

    </security:authorize>

    <h1>Total: ${cart.cartTotalPrice} PLN</h1>

    <h3><a href="<spring:url value="/cart/${account.username}/confirm" />">Confirm</a></h3>
    <h3><a href="<spring:url value="/cart/${account.username}/confirm/cancel" />">Cancel</a></h3>

    <jsp:include page="../_footer.jsp" />

</body>
</html>
