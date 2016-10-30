<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<section>
    <div>
        <div>
            <a href="<spring:url value="/welcome" />"><spring:message code="menu.message.homePage" /></a>
        </div>
        <div>
            <a href="<spring:url value="/products/list" />"><spring:message code="products" /></a>
        </div>
        <security:authorize  access="!hasRole('ROLE_ADMIN')">
            <div>
                <a href="<spring:url value="/order/myCart" />"><spring:message code="menu.message.cart" /></a>
            </div>
        </security:authorize>
        <security:authorize  access="hasRole('ROLE_ADMIN')">
            <div>
                <a href="<spring:url value="/admin/products/list" />"><spring:message code="menu.message.adminPage" /></a>
            </div>
        </security:authorize>
    </div>
</section>
