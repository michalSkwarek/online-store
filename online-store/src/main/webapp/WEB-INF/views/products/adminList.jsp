<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All products</title>
</head>
<body>

    <jsp:include page="../_header.jsp" />
    <jsp:include page="../_menu.jsp" />

    <div>
        <security:authorize  access="hasRole('ROLE_ADMIN')">
            <ul>
                <li><a href="<spring:url value="/admin/products/list" />">Products</a></li>
                <li><a href="<spring:url value="/admin/manufacturers/list" />">Manufacturers</a></li>
            </ul>
        </security:authorize>
    </div>

    <div>
        <a href="<spring:url value="/admin/products/new" />">Add new product</a>
    </div>

    <h1>List of all products</h1>

    <div>
        <table>
            <tr>
                <td>Model</td>
                <td>Unit price</td>
                <td>Category</td>
                <td>Brand</td>
                <td>Website</td>
                <td>Specifications</td>
                <td>Add specifications</td>
                <td>Update</td>
                <td>Delete</td>
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

    <jsp:include page="../_footer.jsp" />

</body>
</html>
