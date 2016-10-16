<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Address data form</title>
</head>
<body>

    <security:authorize  access="hasAnyRole('ROLE_USER', 'ROLE_ADMIN')">
        <jsp:include page="../_header.jsp" />
        <jsp:include page="../_menu.jsp" />
    </security:authorize>

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
                <input type="submit" value="Save"/>
            </li>
        </ul>

    </form:form>

    <jsp:include page="../_footer.jsp" />

</body>
</html>
