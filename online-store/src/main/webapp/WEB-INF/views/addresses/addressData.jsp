<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Address data form</title>
</head>
<body>
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

</body>
</html>
