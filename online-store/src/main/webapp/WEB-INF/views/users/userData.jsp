<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Account data form</title>
</head>
<body>

    <security:authorize  access="hasAnyRole('ROLE_USER', 'ROLE_ADMIN')">
        <h1>Account data</h1>

            <ul>
                <li>
                    <label for="username">Username: </label>
                    ${account}
                </li>

                <li>
                    <label for="password">Password: </label>
                    <form:input path="password" id="password"/>
                </li>

                <li>
                    <label for="email">Email: </label>
                    <form:input path="email" id="email"/>
                </li>
            </ul>

            <a href="<spring:url value="/accounts/edit/${account.id}" />">Edit</a>

    </security:authorize>

    <security:authorize  access="hasRole('ROLE_USER')">
        <h1>Customer data</h1>
        <form:form method="post" modelAttribute="customer">

            <ul>
                <li>
                    <label for="firstName">First name: </label>
                    <form:input path="firstName" id="firstName"/>
                </li>

                <li>
                    <label for="lastName">Last name: </label>
                    <form:input path="lastName" id="lastName"/>
                </li>

                <li>
                    <label for="birthDate">Birth date: </label>
                    <form:input path="birthDate" id="birthDate"/>
                </li>

                <li>
                    <label for="phoneNumber">Phone number: </label>
                    <form:input path="phoneNumber" id="phoneNumber"/>
                </li>
            </ul>

            <a href="<spring:url value="/customers/edit/${customer.id}" />">Edit</a>

        </form:form>
    </security:authorize>

    <security:authorize  access="hasRole('ROLE_USER')">
        <h1>Address data</h1>
        <form:form method="post" modelAttribute="address">

            <ul>
                <li>
                    <label for="street">Street: </label>
                    <form:input path="street" id="street"/>
                </li>

                <li>
                    <label for="streetNumber">Street number: </label>
                    <form:input path="streetNumber" id="streetNumber"/>
                </li>

                <li>
                    <label for="doorNumber">Door number: </label>
                    <form:input path="doorNumber" id="doorNumber"/>
                </li>

                <li>
                    <label for="zipCode">Zip code: </label>
                    <form:input path="zipCode" id="zipCode"/>
                </li>

                <li>
                    <label for="city">City: </label>
                    <form:input path="city.name" id="city"/>
                </li>

                <li>
                    <label for="country">Country: </label>
                    <form:input path="city.country.name" id="country"/>
                </li>
            </ul>

            <a href="<spring:url value="/addresses/edit/${address.id}" />">Edit</a>

        </form:form>
    </security:authorize>

    <a href="<spring:url value="/welcome" />">Go to home page</a>

</body>
</html>
