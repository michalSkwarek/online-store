<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer data form</title>
</head>
<body>

    <security:authorize  access="hasAnyRole('ROLE_USER', 'ROLE_ADMIN')">
        <jsp:include page="../_header.jsp" />
        <jsp:include page="../_menu.jsp" />
    </security:authorize>

    <h1>Customer data</h1>

    <form:form method="post" modelAttribute="customer">

        <form:hidden path="id"/>

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

            <c:if test="${customer.billingAddress != null}">
                <form:hidden path="billingAddress.id"/>
            </c:if>

            <li>
                <label for="phoneNumber">Phone number: </label>
                <form:input path="phoneNumber" id="phoneNumber"/>
            </li>

            <c:if test="${customer.numberOfOrders != null}">
                <form:hidden path="numberOfOrders"/>
            </c:if>

            <li>
                <input type="submit" value="Save"/>
            </li>
        </ul>

    </form:form>

    <jsp:include page="../_footer.jsp" />

</body>
</html>
