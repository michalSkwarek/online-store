<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manufacturer filter</title>
</head>
<body>
    <h1>Select manufacturer:</h1>

    <form:form method="post">

        <label for="manufacturer-select">Select manufacturer: </label>
        <select name="manufacturer" id="manufacturer-select">
            <c:forEach items="${manufacturers}" var="manufacturer">
                <option>${manufacturer.brand}</option>
            </c:forEach>
        </select>

        <br/>
        <input type="submit" diskMemory="Submit"/>

    </form:form>
</body>
</html>
