<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<section>
    <div class="logo">
        <h1>Online store</h1>
    </div>

    <div>
        <table class="menu-table">
            <tr>
                <td>
                    <div class="">
                        <a href="<spring:url value="/welcome" />"><spring:message code="menu.message.homePage" /></a>
                    </div>
                </td>
                <td>
                    <div>
                        <a href="<spring:url value="/products/list" />"><spring:message code="products" /></a>
                    </div>
                </td>
                <td>
                    <security:authorize  access="!hasRole('ROLE_ADMIN')">
                        <div>
                            <a href="<spring:url value="/order/myCart" />"><spring:message code="menu.message.cart" /></a>
                        </div>
                    </security:authorize>
                </td>
                <td></td>
                <td>
                    <security:authorize  access="hasRole('ROLE_USER')">
                        <div class="text-right">
                            <a href="<spring:url value="/order/${pageContext.request.userPrincipal.name}/list" />"><spring:message code="header.message.myOrders" /></a>
                        </div>
                    </security:authorize>
                </td>
                <td>
                    <security:authorize  access="hasAnyRole('ROLE_USER', 'ROLE_ADMIN')">
                        <div class="text-right">
                            <a href="<spring:url value="/users/${pageContext.request.userPrincipal.name}" />"><spring:message code="header.message.userData" /></a>
                        </div>
                    </security:authorize>
                </td>
                <td>
                    <div class="text-right">
                        <a href="?language=pl" >pl</a> | <a href="?language=en">en</a>
                    </div>
                </td>
            </tr>
            <tr>
                <td>
                    <security:authorize  access="hasRole('ROLE_ADMIN')">
                        <div>
                            <p><spring:message code="menu.message.adminPages" />:</p>
                        </div>
                    </security:authorize>
                </td>
                <td>
                    <security:authorize  access="hasRole('ROLE_ADMIN')">
                        <div>
                            <a href="<spring:url value="/admin/products/list" />"><spring:message code="products" /></a>
                        </div>
                    </security:authorize>
                </td>
                <td>
                    <security:authorize  access="hasRole('ROLE_ADMIN')">
                        <div>
                            <a href="<spring:url value="/admin/manufacturers/list" />"><spring:message code="manufacturers" /></a>
                        </div>
                    </security:authorize>
                </td>
                <td></td>
                <td></td>
                <td></td>
                <td>
                    <security:authorize  access="!hasAnyRole('ROLE_USER', 'ROLE_ADMIN')">
                        <div class="text-right">
                            <a href="<spring:url value="/login" />"><spring:message code="header.message.signIn" /></a>
                        </div>
                    </security:authorize>
                    <security:authorize  access="hasAnyRole('ROLE_USER', 'ROLE_ADMIN')">
                        <div class="text-right">
                            <a href="/logout"><spring:message code="header.message.logout" /></a>
                        </div>
                    </security:authorize>
                </td>
            </tr>
        </table>
    </div>
</section>
