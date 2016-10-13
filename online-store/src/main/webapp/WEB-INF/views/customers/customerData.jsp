<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer data form</title>
</head>
<body>
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

            <li>
                <input type="submit" value="Save"/>
            </li>
        </ul>

    </form:form>

</body>
</html>
