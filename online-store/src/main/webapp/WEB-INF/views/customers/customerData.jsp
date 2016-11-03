<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<section>
    <form:form modelAttribute="customer" method="post">
        <fieldset>
            <legend>
                <spring:message code="customers.messages.customerData" />
            </legend>

            <form:hidden path="id" />

            <div>
                <label for="firstName">
                    <spring:message code="customer.details.firstName.label" />
                </label>
                <div>
                    <form:input path="firstName" id="firstName" />
                    <form:errors path="firstName" />
                </div>
            </div>

            <div>
                <label for="lastName">
                    <spring:message code="customer.details.lastName.label" />
                </label>
                <div>
                    <form:input path="lastName" id="lastName" />
                    <form:errors path="lastName" />
                </div>
            </div>

            <div>
                <label for="birthDate">
                    <spring:message code="customer.details.birthDate.label" />
                </label>
                <div>
                    <form:input path="birthDate" id="birthDate" />
                    <form:errors path="birthDate" />
                </div>
            </div>

            <c:if test="${customer.billingAddress != null}">
                <form:hidden path="billingAddress.id" />
            </c:if>

            <div>
                <label for="phoneNumber">
                    <spring:message code="customer.details.phoneNumber.label" />
                </label>
                <div>
                    <form:input path="phoneNumber" id="phoneNumber" />
                </div>
            </div>

            <c:if test="${customer.numberOfOrders != null}">
                <form:hidden path="numberOfOrders" />
            </c:if>

            <div>
                <input type="submit" value="<spring:message code="save" />" />
            </div>

        </fieldset>
    </form:form>
</section>