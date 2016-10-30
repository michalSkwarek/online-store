<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<section>
    <div>
        <security:authorize  access="hasAnyRole('ROLE_USER', 'ROLE_ADMIN')">
            <div>
                <a href="<spring:url value="/users/${pageContext.request.userPrincipal.name}" />"><spring:message code="header.message.userData" /></a>
            </div>
        </security:authorize>
        <security:authorize  access="hasRole('ROLE_USER')">
            <div>
                <a href="<spring:url value="/order/${pageContext.request.userPrincipal.name}/list" />"><spring:message code="header.message.myOrders" /></a>
            </div>
        </security:authorize>
        <security:authorize  access="!hasAnyRole('ROLE_USER', 'ROLE_ADMIN')">
            <div>
                <a href="<spring:url value="/login" />"><spring:message code="header.message.signIn" /></a>
            </div>
        </security:authorize>
        <security:authorize  access="hasAnyRole('ROLE_USER', 'ROLE_ADMIN')">

            <c:url value="/logout" var="logoutUrl" />
            <form action="${logoutUrl}" method="post" id="logoutForm">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            </form>
            <script>
                function formSubmit() {
                    document.getElementById("logoutForm").submit();
                }
            </script>

            <div>
                <a href="javascript:formSubmit()"><spring:message code="header.message.logout" /></a>
            </div>
        </security:authorize>

        <div>
            <a href="?language=pl" >pl</a> | <a href="?language=en">en</a>
        </div>
    </div>
</section>
