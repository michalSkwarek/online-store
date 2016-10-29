<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cancel order</title>
</head>
<body>

    <div>
        <jsp:include page="../_header.jsp" />
        <jsp:include page="../_menu.jsp" />
    </div>

    <div>
        <h1><spring:message code="orders.message.yourOrderWasCancelled" /></h1>
    </div>

    <jsp:include page="../_footer.jsp" />

</body>
</html>
