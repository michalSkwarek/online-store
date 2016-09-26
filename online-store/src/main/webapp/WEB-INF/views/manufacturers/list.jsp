<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All manufacturers</title>
</head>
<body>
    <h1>List of all manufacturers</h1>
    <table>
        <tr>
            <td>ID</td>
            <td>BRAND</td>
            <td>WEBSITE</td>
            <td>UPDATE</td>
            <td>DELETE</td>
        </tr>
        <c:forEach items="${manufacturers}" var="manufacturer">
            <tr>
                <td>${manufacturer.id}</td>
                <td>${manufacturer.brand}</td>
                <td><a href="${manufacturer.website}">${manufacturer.website}</a></td>
                <td><a href="/manufacturers/edit/${manufacturer.id}">Edit</a></td>
                <td><a href="/manufacturers/delete/${manufacturer.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>

    <br/>
    <a href="<c:url value="/manufacturers/new"/>">Add new manufacturer</a>
    <br/>
    <a href="<c:url value="/"/>">Home page</a>
</body>
</html>
