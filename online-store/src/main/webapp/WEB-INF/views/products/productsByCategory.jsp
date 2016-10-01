<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Category filter</title>
</head>
<body>
    <h1>Select categories:</h1>

    <form:form method="post">

        <label for="category-select">Select categories: </label>
        <select name="category" id="category-select">
            <c:forEach items="${categories}" var="category">
                <option>${category.name}</option>
            </c:forEach>
        </select>

        <br/>
        <input type="submit" value="Submit"/>

    </form:form>
</body>
</html>
