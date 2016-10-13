<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div>
    <ul>
        <li><a href="<spring:url value="/welcome" />">Home page</a></li>
        <li><a href="<spring:url value="/products/list" />">Products</a></li>
        <li><a href="<spring:url value="/cart" />">Cart</a></li>
        <security:authorize  access="hasRole('ROLE_ADMIN')">
            <li><a href="<spring:url value="/admin/products/list" />">Admin page</a></li>
        </security:authorize>
    </ul>
</div>
