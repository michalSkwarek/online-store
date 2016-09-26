<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All products</title>
</head>
<body>
    <h1>List of all products</h1>
    <table>
        <tr>
            <td>ID</td>
            <td>MODEL</td>
            <td>UNIT_PRICE</td>

            <td>UPDATE</td>
            <td>DELETE</td>
        </tr>
        <c:forEach items="${products}" var="product">
            <tr>
                <td>${product.id}</td>
                <td>${product.model}</td>
                <td>${product.unitPrice}</td>

                <td><a href="/products/edit/${product.id}">Edit</a></td>
                <td><a href="/products/delete/${product.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>

    <br/>
    <a href="<c:url value="/products/new"/>">Add new product</a>
    <br/>
    <a href="<c:url value="/"/>">Home page</a>
</body>
</html>