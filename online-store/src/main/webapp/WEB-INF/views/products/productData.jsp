<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product data form</title>
</head>
<body>
    <h1>Product data</h1>

    <form:form method="post"  modelAttribute="product">

        <ul>
            <li>
                <label for="model">Name: </label>
                <form:input path="model" id="model"/>
            </li>

            <li>
                <label for="unitPrice">Unit price: </label>
                <form:input path="unitPrice" id="unitPrice"/>
            </li>

            <li>
                <input type="submit" value="Save"/>
            </li>
        </ul>

    </form:form>

    <br/>
    Go back to <a href="<c:url value="/products/list" />">List of all products</a>
</body>
</html>
