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
                    <c:if test="${product.category == null}">
                        <form:option value="${product.category.id}"> -- select -- </form:option>
                    </c:if>
                    <c:if test="${product.category != null}">
                        <form:option value="${product.category.id}">${product.category.name}</form:option>
                    </c:if>
                    <form:options items="${categories}" itemLabel="name" itemValue="id" />
                </form:select>
            </li>

            <li>
                <label for="manufacturer-select">Manufacturer: </label>
                <form:select path="manufacturer" id="manufacturer-select">
                    <c:if test="${product.manufacturer == null}">
                        <form:option value="${product.manufacturer.id}"> -- select -- </form:option>
                    </c:if>
                    <c:if test="${product.manufacturer != null}">
                        <form:option value="${product.manufacturer.id}">${product.manufacturer.brand}</form:option>
                    </c:if>
                    <form:options items="${manufacturers}" itemLabel="brand" itemValue="id"/>
                </form:select>
            </li>

            <c:if test="${product.productSpecifications.id != null}">
                <li>
                    <label for="productSpecifications">Specifications: </label>
                    <a href="/products/spec/${product.productSpecifications.id}">Edit</a>
                    <form:hidden path="productSpecifications.id" id="productSpecifications"/>
                </li>
            </c:if>

            <li>
                <input type="submit" value="Save"/>
            </li>
        </ul>

    </form:form>

    <br/>
    Go back to <a href="<c:url value="/products/list" />">List of all products</a>
</body>
</html>
