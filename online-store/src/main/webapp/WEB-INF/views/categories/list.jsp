<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All categories</title>
</head>
<body>
    <h1>List of all categories</h1>
    <table>
        <tr>
            <td>ID</td>
            <td>NAME</td>
            <td>UPDATE</td>
            <td>DELETE</td>
        </tr>
        <c:forEach items="${categories}" var="category">
            <tr>
                <td>${category.id}</td>
                <td>${category.name}</td>
                <td><a href="/categories/edit/${category.id}">Edit</a></td>
                <td><a href="/categories/delete/${category.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>

    <br/>
    <a href="<c:url value="/categories/new"/>">Add new category</a>
    <br/>
    <a href="<c:url value="/"/>">Home page</a>
</body>
</html>
