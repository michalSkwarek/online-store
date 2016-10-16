<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Account data form</title>
</head>
<body>

    <jsp:include page="../_header.jsp" />
    <jsp:include page="../_menu.jsp" />

    <security:authorize  access="hasAnyRole('ROLE_USER', 'ROLE_ADMIN')">
        <h1>Account data</h1>

            <ul>
                <li>
                    <label>Username: </label>
                    ${account.username}
                </li>

                <li>
                    <label>Password: </label>
                    ${account.password}
                </li>

                <li>
                    <label>Email: </label>
                    ${account.email}
                </li>

                <li>
                    <label>Date created: </label>
                    ${account.dateCreated}
                </li>
            </ul>

            <a href="<spring:url value="/accounts/edit/${account.username}" />">Edit</a>

    </security:authorize>

    <security:authorize  access="hasRole('ROLE_USER')">
        <h1>Customer data</h1>

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
                    <label>Birth date: </label>
                    ${account.customer.birthDate}
                </li>

                <li>
                    <label>Phone number: </label>
                    ${account.customer.phoneNumber}
                </li>
            </ul>

            <a href="<spring:url value="/customers/edit/${account.customer.id}" />">Edit</a>

    </security:authorize>

    <security:authorize  access="hasRole('ROLE_USER')">
        <h1>Address data</h1>

            <ul>
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

            <a href="<spring:url value="/addresses/edit/${account.customer.billingAddress.id}" />">Edit</a>

    </security:authorize>

    <jsp:include page="../_footer.jsp" />

</body>
</html>
