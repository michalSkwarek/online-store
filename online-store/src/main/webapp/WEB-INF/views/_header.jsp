<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div>
    <div>
        <h1>Online store</h1>
    </div>

    <ul>
        <security:authorize  access="hasAnyRole('ROLE_USER', 'ROLE_ADMIN')">
            <li><a href="<spring:url value="/accounts/${pageContext.request.userPrincipal.name}" />">Account info</a></li>
        </security:authorize>
        <security:authorize  access="hasRole('ROLE_USER')">
            <li><a href="<spring:url value="/customers/${pageContext.request.userPrincipal.name}" />">Customer info</a></li>
        </security:authorize>
        <security:authorize  access="hasRole('ROLE_USER')">
            <li><a href="<spring:url value="/addresses/${pageContext.request.userPrincipal.name}" />">Address info</a></li>
        </security:authorize>
        <security:authorize  access="!hasAnyRole('ROLE_USER', 'ROLE_ADMIN')">
            <li><a href="<spring:url value="/login" />">Sign in</a></li>
        </security:authorize>
        <security:authorize  access="hasAnyRole('ROLE_USER', 'ROLE_ADMIN')">

            <c:url value="logout" var="logoutUrl" />
            <form action="${logoutUrl}" method="post" id="logoutForm">
                <input type="hidden" name="${_csrf.parameterName}"
                       value="${_csrf.token}" />
            </form>
            <script>
                function formSubmit() {
                    document.getElementById("logoutForm").submit();
                }
            </script>

            <a href="javascript:formSubmit()"> Logout</a>
        </security:authorize>
    </ul>

    <%--<div>--%>
        <%--<c:if test="${pageContext.request.userPrincipal.name != null}">--%>
            <%--Hello--%>
            <%--<a href="${pageContext.request.contextPath}/accountInfo">--%>
                    <%--${pageContext.request.userPrincipal.name} </a>--%>
            <%--<a href="${pageContext.request.contextPath}/logout">Logout</a>--%>

        <%--</c:if>--%>
        <%--<c:if test="${pageContext.request.userPrincipal.name == null}">--%>
            <%--<a href="${pageContext.request.contextPath}/login">Login</a>--%>
        <%--</c:if>--%>
    <%--</div>--%>
</div>
