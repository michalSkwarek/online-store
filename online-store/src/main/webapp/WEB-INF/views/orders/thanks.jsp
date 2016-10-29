<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thanks</title>
</head>
<body>

    <div>
        <jsp:include page="../_header.jsp" />
        <jsp:include page="../_menu.jsp" />
    </div>

    <div>
        <h1><spring:message code="orders.message.dear" />, ${customer}</h1>
        <h1><spring:message code="orders.message.thankYouForOrder" /></h1>
        <h2><spring:message code="orders.message.youMustWait2DaysToDelivery" /></h2>
    </div>

    <jsp:include page="../_footer.jsp" />

</body>
</html>

