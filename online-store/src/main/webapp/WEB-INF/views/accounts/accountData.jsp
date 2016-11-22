<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<section>
    <div class="form">
        <form:form modelAttribute="account" method="post">
            <fieldset>
                <legend>
                    <spring:message code="accounts.messages.accountData" />
                </legend>

                <form:hidden path="id" />

                <div class="box">
                    <div class="error">
                        <form:errors path="username" />
                    </div>
                    <label for="username" class="title">
                        <spring:message code="account.details.username.label" />
                    </label>
                    <c:choose>
                        <c:when test="${account.username != null}">
                            <div class="field">
                                ${account.username}
                            </div>
                            <form:hidden path="username" id="username" />
                        </c:when>
                        <c:otherwise>
                            <div>
                                <form:input path="username" id="username" cssClass="input-field" />
                            </div>
                        </c:otherwise>
                    </c:choose>
                </div>

                <div class="box">
                    <div class="error">
                        <form:errors path="password" />
                    </div>
                    <label for="password" class="title">
                        <spring:message code="account.details.password.label" />
                    </label>
                    <div>
                        <form:input path="password" id="password" cssClass="input-field" />
                    </div>
                </div>

                <c:if test="${account.enabled != null}">
                    <form:hidden path="enabled" />
                </c:if>

                <div class="box">
                    <div class="error">
                        <form:errors path="email" />
                    </div>
                    <label for="email" class="title">
                        <spring:message code="account.details.email.label" />
                    </label>
                    <div>
                        <form:input path="email" id="email" cssClass="input-field" />
                    </div>
                </div>

                <c:if test="${account.dateCreated != null}">
                    <div class="box">
                        <label for="dateCreated" class="title">
                            <spring:message code="account.details.dateCreated.label" />
                        </label>
                        <c:choose>
                            <c:when test="${account.dateCreated != null}">
                                <div class="field">
                                    <fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss" value="${account.dateCreated}" />
                                </div>
                                <form:hidden path="dateCreated" id="dateCreated" />
                            </c:when>
                            <c:otherwise>
                                <div>
                                    <form:input path="dateCreated" id="dateCreated" cssClass="input-field" />
                                </div>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </c:if>

                <c:if test="${account.role != null}">
                    <form:hidden path="role" />
                </c:if>

                <c:if test="${account.customer != null}">
                    <form:hidden path="customer.id" />
                </c:if>

                <div>
                    <input type="submit" class="button-save" value="<spring:message code="save" />" />
                </div>

            </fieldset>
        </form:form>
    </div>
</section>
