<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Account data</title>
</head>
<body>

    <section>
        <security:authorize  access="hasAnyRole('ROLE_USER', 'ROLE_ADMIN')">
            <div>
                <jsp:include page="../_header.jsp" />
                <jsp:include page="../_menu.jsp" />
            </div>
        </security:authorize>
    </section>

    <section>
        <form:form modelAttribute="account" method="post">
            <fieldset>
                <legend>
                    <spring:message code="accounts.messages.accountData" />
                </legend>

                <form:hidden path="id" />

                <div>
                    <label for="username">
                        <spring:message code="account.details.username.label" />
                    </label>
                    <div>
                        <c:choose>
                            <c:when test="${account.username != null}">
                                ${account.username}
                                <form:hidden path="username" id="username" />
                            </c:when>
                            <c:otherwise>
                                <form:input path="username" id="username" />
                                <%--<form:errors path="username" />--%>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>

                <div>
                    <label for="password">
                        <spring:message code="account.details.password.label" />
                    </label>
                    <div>
                        <form:input path="password" id="password" />
                    </div>
                </div>

                <c:if test="${account.enabled != null}">
                    <form:hidden path="enabled" />
                </c:if>

                <div>
                    <label for="email">
                        <spring:message code="account.details.email.label" />
                    </label>
                    <div>
                        <form:input path="email" id="email" />
                    </div>
                </div>

                <c:if test="${account.dateCreated != null}">
                    <div>
                        <label for="dateCreated">
                            <spring:message code="account.details.dateCreated.label" />
                        </label>
                        <div>
                            <c:choose>
                                <c:when test="${account.dateCreated != null}">
                                    ${account.dateCreated}
                                    <form:hidden path="dateCreated" id="dateCreated" />
                                </c:when>
                                <c:otherwise>
                                    <form:input path="dateCreated" id="dateCreated" />
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                </c:if>

                <c:if test="${account.role != null}">
                    <form:hidden path="role" />
                </c:if>

                <c:if test="${account.customer != null}">
                    <form:hidden path="customer.id" />
                </c:if>

                <div>
                    <input type="submit" value="<spring:message code="save" />" />
                </div>

            </fieldset>
        </form:form>
    </section>

    <jsp:include page="../_footer.jsp" />

</body>
</html>
