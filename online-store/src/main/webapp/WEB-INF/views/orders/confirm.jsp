<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Confirm order</title>
</head>
<body>

    <jsp:include page="../_header.jsp" />
    <jsp:include page="../_menu.jsp" />

    <h1>Confirm order</h1>

    <form:form method="post">

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
                        ${shippingAddress.street}
                </li>

                <li>
                    <label>Street number: </label>
                        ${shippingAddress.streetNumber}
                </li>

                <li>
                    <label>Door number: </label>
                        ${shippingAddress.doorNumber}
                </li>

                <li>
                    <label>Zip code: </label>
                        ${shippingAddress.zipCode}
                </li>

                <li>
                    <label>City: </label>
                        ${shippingAddress.city.name}
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

        <h3><input type="submit" value="Confirm"></h3>

    </form:form>

    <h3><a href="<spring:url value="/cart/cancel" />">Cancel</a></h3>

    <jsp:include page="../_footer.jsp" />

</body>
</html>
