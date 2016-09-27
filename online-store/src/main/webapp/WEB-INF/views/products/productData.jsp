<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product data form</title>
</head>
<body>
    <h1>Product data</h1>

    <form:form method="post" modelAttribute="product">

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
                <label for="category-select">Category: </label>
                <form:select path="category" id="category-select">
                    <form:option value="${product.category}"> -- select -- </form:option>
                    <form:options items="${categories}" itemLabel="name" itemValue="id"/>
                </form:select>
            </li>

            <li>
                <label for="manufacturer-select">Manufacturer: </label>
                <form:select path="manufacturer" id="manufacturer-select">
                    <form:option value="${product.manufacturer}"> -- select -- </form:option>
                    <form:options items="${manufacturers}" itemLabel="brand" itemValue="id"/>
                </form:select>
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
