<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manufacturer data form</title>
</head>
<body>
    <h1>Manufacturer data</h1>

    <form:form method="post" modelAttribute="manufacturer">

        <ul>
            <li>
                <label for="brand">Name: </label>
                <form:input path="brand" id="brand"/>
            </li>

            <li>
                <label for="website">Website: </label>
                <form:input path="website" id="website"/>
            </li>

            <li>
                <input type="submit" value="Save"/>
            </li>
        </ul>

    </form:form>

    <br/>
    Go back to <a href="<c:url value="/manufacturers/list" />">List of all manufacturers</a>
</body>
</html>
