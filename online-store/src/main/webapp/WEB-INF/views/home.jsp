<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome to my app</title>
</head>
<body>
<h1>${welcome}</h1>
<ul>
    <li><a href="${pageContext.request.contextPath}/products/list">List of all products</a></li>
    <li><a href="${pageContext.request.contextPath}/manufacturers/list">List of all manufacturers</a></li>
    <li><a href="${pageContext.request.contextPath}/categories/list">List of all categories</a></li>
</ul>
</body>
</html>
