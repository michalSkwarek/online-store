<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Account data form</title>
</head>
<body>

    <security:authorize  access="hasAnyRole('ROLE_USER', 'ROLE_ADMIN')">
        <jsp:include page="../_header.jsp" />
        <jsp:include page="../_menu.jsp" />
    </security:authorize>

    <h1>Account data</h1>

    <form:form method="post" modelAttribute="account">

        <form:hidden path="id"/>

        <ul>
            <li>
                <label for="username">Username: </label>
                <c:choose>
                    <c:when test="${account.username != null}">
                        ${account.username}
                        <form:hidden path="username" id="username"/>
                    </c:when>
                    <c:otherwise>
                        <form:input path="username" id="username"/>
                    </c:otherwise>
                </c:choose>
            </li>

            <li>
                <label for="password">Password: </label>
                <form:input path="password" id="password"/>
            </li>

            <c:if test="${account.enabled != null}">
                <form:hidden path="enabled"/>
            </c:if>

            <li>
                <label for="email">Email: </label>
                <form:input path="email" id="email"/>
            </li>

            <c:if test="${account.dateCreated != null}">
                <li>
                    <label for="dateCreated">Date created: </label>
                    <c:choose>
                        <c:when test="${account.dateCreated != null}">
                            ${account.dateCreated}
                            <form:hidden path="dateCreated" id="dateCreated"/>
                        </c:when>
                        <c:otherwise>
                            <form:input path="dateCreated" id="dateCreated"/>
                        </c:otherwise>
                    </c:choose>
                </li>
            </c:if>

            <c:if test="${account.role != null}">
                <form:hidden path="role"/>
            </c:if>

            <c:if test="${account.customer != null}">
                <form:hidden path="customer.id"/>
            </c:if>

            <li>
                <input type="submit" value="Save"/>
            </li>
        </ul>

    </form:form>

    <jsp:include page="../_footer.jsp" />

</body>
</html>
