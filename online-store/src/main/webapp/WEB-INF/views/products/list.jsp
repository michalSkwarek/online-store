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
            <%--<td>ID</td>--%>
            <%--<td>MODEL</td>--%>
            <%--<td>UNIT_PRICE</td>--%>
            <%--<td>CATEGORY_ID</td>--%>
            <%--<td>NAME</td>--%>
            <%--<td>MANUFACTURER_ID</td>--%>
            <%--<td>BRAND</td>--%>
            <%--<td>WEBSITE</td>--%>
            <%--<td><b>SPECIFICATIONS</b></td>--%>
            <%--<td>ADD SPEC</td>--%>
            <%--<td>UPDATE</td>--%>
            <%--<td>DELETE</td>--%>
        </tr>
        <c:forEach items="${products}" var="product">
            <tr>
                <%--<td>${product.id}</td>--%>
                <%--<td>${product.model}</td>--%>
                <%--<td>${product.unitPrice}</td>--%>
                <%--<td>${product.category.id}</td>--%>
                <%--<td>${product.category.name}</td>--%>
                <%--<td>${product.manufacturer.id}</td>--%>
                <%--<td>${product.manufacturer.brand}</td>--%>
                <%--<td>${product.manufacturer.website}</td>--%>
                <%--<td><a href="/products/${product.id}">Specifications</a></td>--%>
                <%--<td>--%>
                    <%--<c:if test="${product.productSpecifications == null}">--%>
                        <%--<a href="<c:url diskMemory="/products/spec/${product.id}"/>">Add</a>--%>
                    <%--</c:if>--%>
                <%--</td>--%>
                <%--<td><a href="/products/edit/${product.id}">Edit</a></td>--%>
                <%--<td><a href="/products/delete/${product.id}">Delete</a></td>--%>


                <td></td>
                <td></td>
                <td>${product.id}</td>
                <td>${product.model}</td>
                <td>${product.unitPrice}</td>
                <td>${product.category.name}</td>
                <td>${product.manufacturer.brand}</td>
                <td>${product.productSpecifications.id}</td>
                <td>${product.productSpecifications.cpu}</td>
                    <td>${product.productSpecifications.gpu}</td>
                    <td>${product.productSpecifications.ram}</td>
                    <td>${product.productSpecifications.storage}</td>

                    <td>${product.productSpecifications.display}</td>
                    <td>${product.productSpecifications.battery}</td>
                    <td>${product.productSpecifications.os}</td>
                    <td>${product.productSpecifications.camera}</td>
                    <td>${product.productSpecifications.dimensions}</td>
                    <td>${product.productSpecifications.weight}</td>

            </tr>
        </c:forEach>
    </table>


    <br/>
    <a href="<c:url diskMemory="/products/new"/>">Add new product</a>
    <br/>
    <a href="<c:url diskMemory="/"/>">Home page</a>
</body>
</html>