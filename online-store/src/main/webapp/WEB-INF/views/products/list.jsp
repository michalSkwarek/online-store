<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
            <li><a href="<spring:url value="/cart" />">Cart</a></li>
            <li><a href="<spring:url value="/login" />">Sign in</a></li>
        </ul>
    </div>

    <form:form>

        <div>
            <p>Select categories:</p>
            <c:forEach items="${categories}" var="category" >
                <label>
                    <input type="checkbox" name="category" value="${category.name}">${category.name}
                </label>
            </c:forEach>

            <p>Select manufacturers:</p>
            <c:forEach items="${manufacturers}" var="manufacturer" >
                <label>
                    <input type="checkbox" name="manufacturer" value="${manufacturer.brand}">${manufacturer.brand}
                </label>
            </c:forEach>

            <p>Select price range:</p>
            <label>
                Od: <input type="text" name="fromPriceRange">
                Do: <input type="text" name="toPriceRange">
            </label>

            <p>Select order:</p>
            <label>
                <input type="radio" name="priceOrder" value="asc" checked>Ascending
                <input type="radio" name="priceOrder" value="desc">Descending
            </label>
        </div>

        <br/>
        <input type="submit" value="Submit"/>

    </form:form>

    <%--<div>--%>
        <%--<p>Select categories</p>--%>
        <%--<ul>--%>
            <%--<c:forEach items="${categories}" var="category">--%>
                <%--<a href="<spring:url value="/products/category/${category.name}" />">${category.name}</a>--%>
            <%--</c:forEach>--%>
        <%--</ul>--%>
    <%--</div>--%>

    <%--<div>--%>
        <%--<p>Select manufacturers</p>--%>
        <%--<ul>--%>
            <%--<c:forEach items="${manufacturers}" var="manufacturer">--%>
                <%--<a href="<spring:url value="/products/category/${category.name}" />">${manufacturer.brand}</a>--%>
            <%--</c:forEach>--%>
        <%--</ul>--%>
    <%--</div>--%>

    <div>
        <p>List of all products</p>
        <c:forEach items="${products}" var="product">
            <div>
                <%--<img src="<c:url value="/resources/images/my_image.jpg" />" alt="image" style="width: 25%" />--%>
                <p>${product.manufacturer.brand} ${product.model}</p>
                <p>${product.unitPrice}</p>
                <p>${product.category.name}</p>
                <a href="<spring:url value="/products/${product.id}" />">Details</a>
            </div>
        </c:forEach>
    </div>

    <div>
        <p>&copy; Online store 2016</p>
    </div>








    <%------%>
    <%--<table>--%>
        <%--<tr>--%>
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
        <%--</tr>--%>
        <%--<c:forEach items="${products}" var="product">--%>
            <%--<tr>--%>
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
                        <%--<a href="<c:url value="/products/spec/${product.id}"/>">Add</a>--%>
                    <%--</c:if>--%>
                <%--</td>--%>
                <%--<td><a href="/products/edit/${product.id}">Edit</a></td>--%>
                <%--<td><a href="/products/delete/${product.id}">Delete</a></td>--%>
            <%--</tr>--%>
        <%--</c:forEach>--%>
    <%--</table>--%>


    <%--<br/>--%>
    <%--<a href="<c:url value="/products/new"/>">Add new product</a>--%>
    <%--<br/>--%>
    <%--<a href="<c:url value="/"/>">Home page</a>--%>
</body>
</html>