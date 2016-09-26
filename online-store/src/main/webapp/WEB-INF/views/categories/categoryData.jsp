<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Category data form</title>
</head>
<body>
    <h1>Category data</h1>

    <form:form method="post" modelAttribute="category">

        <ul>
            <li>
                <label for="name">Name: </label>
                <form:input path="name" id="name"/>
            </li>

            <li>
                <input type="submit" value="Save"/>
            </li>
        </ul>

    </form:form>

    <br/>
    Go back to <a href="<c:url value="/categories/list" />">List of all categories</a>
</body>
</html>
