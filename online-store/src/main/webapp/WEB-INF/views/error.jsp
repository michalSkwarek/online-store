<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Error</title>
</head>
<body>

    <jsp:include page="_header.jsp" />
    <jsp:include page="_menu.jsp" />

    <div>
        <h1><spring:message code="error" /></h1>
    </div>

    <jsp:include page="_footer.jsp" />

</body>
</html>
