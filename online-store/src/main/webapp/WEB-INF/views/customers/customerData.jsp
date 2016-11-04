<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<section class="form">
    <form:form modelAttribute="customer" method="post">
        <fieldset>
            <legend>
                <spring:message code="customers.messages.customerData" />
            </legend>

            <form:hidden path="id" />

            <div class="box">
                <div class="error">
                    <form:errors path="firstName" />
                </div>
                <label for="firstName" class="title">
                    <spring:message code="customer.details.firstName.label" />
                </label>
                <div>
                    <form:input path="firstName" id="firstName" cssClass="field" />
                </div>
            </div>

            <div class="box">
                <div class="error">
                    <form:errors path="lastName" />
                </div>
                <label for="lastName" class="title">
                    <spring:message code="customer.details.lastName.label" />
                </label>
                <div>
                    <form:input path="lastName" id="lastName" cssClass="field" />
                </div>
            </div>

            <div class="box">
                <div class="error">
                    <form:errors path="birthDate" />
                </div>
                <label for="birthDate" class="title">
                    <spring:message code="customer.details.birthDate.label" />
                </label>
                <div>
                    <form:input path="birthDate" id="birthDate" cssClass="field" />
                </div>
            </div>

            <c:if test="${customer.billingAddress != null}">
                <form:hidden path="billingAddress.id" />
            </c:if>

            <div class="box">
                <label for="phoneNumber" class="title">
                    <spring:message code="customer.details.phoneNumber.label" />
                </label>
                <div>
                    <form:input path="phoneNumber" id="phoneNumber" cssClass="field" />
                </div>
            </div>

            <c:if test="${customer.numberOfOrders != null}">
                <form:hidden path="numberOfOrders" cssClass="field" />
            </c:if>

            <div>
                <input type="submit" value="<spring:message code="save" />" />
            </div>

        </fieldset>
    </form:form>
</section>