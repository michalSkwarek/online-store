<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All manufacturers</title>
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
        <a href="<spring:url value="/admin/manufacturers/new" />">Add new manufacturer</a>
    </div>

    <h1>List of all manufacturers</h1>

    <div>
        <table>
            <tr>
                <td>Brand</td>
                <td>Website</td>
                <td>Update</td>
                <td>Delete</td>
            </tr>
            <c:forEach items="${manufacturers}" var="manufacturer">
                <tr>
                    <td>${manufacturer.brand}</td>
                    <td><a href="${manufacturer.website}">${manufacturer.website}</a></td>
                    <td><a href="/admin/manufacturers/edit/${manufacturer.id}">Edit</a></td>
                    <td><a href="/admin/manufacturers/delete/${manufacturer.id}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <jsp:include page="../_footer.jsp" />

</body>
</html>
