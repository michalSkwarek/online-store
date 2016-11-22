<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<section>
    <div class="thanks-view">
        <h1><spring:message code="orders.message.dear" />, ${customer}</h1>
        <h1><spring:message code="orders.message.thankYouForOrder" /></h1>
        <h2><spring:message code="orders.message.youMustWait2DaysToDelivery" /></h2>
    </div>
</section>

