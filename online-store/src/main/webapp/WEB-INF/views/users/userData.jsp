<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<section>
    <security:authorize  access="hasAnyRole('ROLE_USER', 'ROLE_ADMIN')">
        <div class="form">
            <fieldset>
                <legend>
                    <spring:message code="accounts.messages.accountData" />
                </legend>

                <div class="box">
                    <label class="title">
                        <spring:message code="account.details.username.label" />
                    </label>
                    <div class="field">
                            ${account.username}
                    </div>
                </div>

                <div class="box">
                    <label class="title">
                        <spring:message code="account.details.password.label" />
                    </label>
                    <div class="field">
                            ${account.password}
                    </div>
                </div>

                <div class="box">
                    <label class="title">
                        <spring:message code="account.details.email.label" />
                    </label>
                    <div class="field">
                            ${account.email}
                    </div>
                </div>

                <div class="box">
                    <label class="title">
                        <spring:message code="account.details.dateCreated.label" />
                    </label>
                    <div class="field">
                            <fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss" value="${account.dateCreated}" />
                    </div>
                </div>

                <div>
                    <a href="<spring:url value="/accounts/edit/${account.username}" />">
                        <button type="button" class="button-edit"><spring:message code="edit" /></button>
                    </a>
                </div>

            </fieldset>
        </div>
    </security:authorize>

    <security:authorize  access="hasRole('ROLE_USER')">
        <div class="form">
            <fieldset>
                <legend>
                    <spring:message code="customers.messages.customerData" />
                </legend>

                <div class="box">
                    <label class="title">
                        <spring:message code="customer.details.firstName.label" />
                    </label>
                    <div class="field">
                            ${account.customer.firstName}
                    </div>
                </div>

                <div class="box">
                    <label class="title">
                        <spring:message code="customer.details.lastName.label" />
                    </label>
                    <div class="field">
                            ${account.customer.lastName}
                    </div>
                </div>

                <div class="box">
                    <label class="title">
                        <spring:message code="customer.details.birthDate.label" />
                    </label>
                    <div class="field">
                            ${account.customer.birthDate}
                    </div>
                </div>

                <div class="box">
                    <label class="title">
                        <spring:message code="customer.details.phoneNumber.label" />
                    </label>
                    <div class="field">
                            ${account.customer.phoneNumber}
                    </div>
                </div>

                <div>
                    <a href="<spring:url value="/customers/edit/${account.username}" />">
                        <button type="button" class="button-edit"><spring:message code="edit" /></button>
                    </a>
                </div>

            </fieldset>
        </div>
    </security:authorize>

    <security:authorize  access="hasRole('ROLE_USER')">
        <div class="form">
            <fieldset>
                <legend>
                    <spring:message code="addresses.messages.addressData" />
                </legend>

                <div class="box">
                    <label class="title">
                        <spring:message code="address.details.street.label" />
                    </label>
                    <div class="field">
                            ${account.customer.billingAddress.street}
                    </div>
                </div>

                <div class="box">
                    <label class="title">
                        <spring:message code="address.details.streetNumber.label" />
                    </label>
                    <div class="field">
                            ${account.customer.billingAddress.streetNumber}
                    </div>
                </div>

                <div class="box">
                    <label class="title">
                        <spring:message code="address.details.doorNumber.label" />
                    </label>
                    <div class="field">
                            ${account.customer.billingAddress.doorNumber}
                    </div>
                </div>

                <div class="box">
                    <label class="title">
                        <spring:message code="address.details.zipCode.label" />
                    </label>
                    <div class="field">
                            ${account.customer.billingAddress.zipCode}
                    </div>
                </div>

                <div class="box">
                    <label class="title">
                        <spring:message code="address.details.city.label" />
                    </label>
                    <div class="field">
                            ${account.customer.billingAddress.city}
                    </div>
                </div>

                <div>
                    <a href="<spring:url value="/addresses/edit/${account.username}" />">
                        <button type="button" class="button-edit"><spring:message code="edit" /></button>
                    </a>
                </div>

            </fieldset>
        </div>
    </security:authorize>
</section>
