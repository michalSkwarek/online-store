<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All products</title>
</head>
<body>

<div>
    <h1>Online store</h1>
    <ul>
        <li><a href="<spring:url value="/welcome" />">Home page</a></li>
        <li><a href="<spring:url value="/products/list" />">Products</a></li>
        <li><a href="<spring:url value="/login" />">Sign in</a></li>
    </ul>
</div>

    <div>
        <table>
            <tr>
                <td>MODEL</td>
                <td>UNIT_PRICE</td>
                <td>NAME</td>
                <td>BRAND</td>
                <td>WEBSITE</td>
                <td>SPECIFICATIONS</td>
                <td>ADD SPEC</td>
                <td>UPDATE</td>
                <td>DELETE</td>
            </tr>
            <c:forEach items="${products}" var="product">
                <tr>
                    <td>${product.model}</td>
                    <td>${product.unitPrice}</td>
                    <td>${product.category.name}</td>
                    <td>${product.manufacturer.brand}</td>
                    <td>${product.manufacturer.website}</td>
                    <td><a href="/products/${product.id}">Specifications</a></td>
                    <td>
                        <c:if test="${product.productSpecifications == null}">
                            <a href="<c:url value="/admin/products/spec/${product.id}"/>">Add</a>
                        </c:if>
                    </td>
                    <td><a href="/admin/products/edit/${product.id}">Edit</a></td>
                    <td><a href="/admin/products/delete/${product.id}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <div>
        <p>&copy; Online store 2016</p>
    </div>

</body>
</html>