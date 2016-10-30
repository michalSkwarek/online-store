<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<section>
    <security:authorize  access="hasRole('ROLE_ADMIN')">
        <div>
            <a href="<spring:url value="/admin/products/list" />"><spring:message code="products" /></a>
            <a href="<spring:url value="/admin/manufacturers/list" />"><spring:message code="manufacturers" /></a>
        </div>
    </security:authorize>
</section>
