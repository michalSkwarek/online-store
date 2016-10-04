<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Account data form</title>
</head>
<body>
    <h1>Account data</h1>

    <form:form method="post" modelAttribute="account">

        <ul>
            <li>
                <label for="username">Username: </label>
                <form:input path="username" id="username"/>
            </li>

            <li>
                <label for="password">Password: </label>
                <form:input path="password" id="password"/>
            </li>

            <li>
                <label for="email">Email: </label>
                <form:input path="email" id="email"/>
            </li>

            <li>
                <input type="submit" value="Save"/>
            </li>
        </ul>

    </form:form>

</body>
</html>
