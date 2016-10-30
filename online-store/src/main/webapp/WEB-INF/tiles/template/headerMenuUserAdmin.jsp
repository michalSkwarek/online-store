<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<section>
    <security:authorize  access="hasAnyRole('ROLE_USER', 'ROLE_ADMIN')">
        <div>
            <jsp:include page="header.jsp" />
            <jsp:include page="menu.jsp" />
        </div>
    </security:authorize>
</section>