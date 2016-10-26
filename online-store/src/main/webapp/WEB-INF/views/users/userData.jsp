<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Account data form</title>
</head>
<body>

    <jsp:include page="../_header.jsp" />
    <jsp:include page="../_menu.jsp" />

    <section>
        <security:authorize  access="hasAnyRole('ROLE_USER', 'ROLE_ADMIN')">
            <h1><spring:message code="accountData.messages.accountData" /></h1>

            <div>
                <label>
                    <spring:message code="account.details.username.label" />
                </label>
                    ${account.username}
            </div>

            <div>
                <label>
                    <spring:message code="account.details.password.label" />
                </label>
                    ${account.password}
            </div>

            <div>
                <label>
                    <spring:message code="account.details.email.label" />
                </label>
                    ${account.email}
            </div>

            <div>
                <label>
                    <spring:message code="account.details.dateCreated.label" />
                </label>
                    ${account.dateCreated}
            </div>

            <a href="<spring:url value="/accounts/edit/${account.username}" />"><spring:message code="edit" /></a>
        </security:authorize>
    </section>

    <section>
        <security:authorize  access="hasRole('ROLE_USER')">
            <h1><spring:message code="customerData.messages.customerData" /></h1>

            <div>
                <label>
                    <spring:message code="customer.details.firstName.label" />
                </label>
                    ${account.customer.firstName}
            </div>

            <div>
                <label>
                    <spring:message code="customer.details.lastName.label" />
                </label>
                    ${account.customer.lastName}
            </div>

            <div>
                <label>
                    <spring:message code="customer.details.birthDate.label" />
                </label>
                    ${account.customer.birthDate}
            </div>

            <div>
                <label>
                    <spring:message code="customer.details.phoneNumber.label" />
                </label>
                    ${account.customer.phoneNumber}
            </div>

            <a href="<spring:url value="/customers/edit/${account.username}" />"><spring:message code="edit" /></a>
        </security:authorize>
    </section>

    <section>
        <security:authorize  access="hasRole('ROLE_USER')">
            <h1><spring:message code="addressData.messages.addressData" /></h1>

            <div>
                <label>
                    <spring:message code="address.details.street.label" />
                </label>
                    ${account.customer.billingAddress.street}
            </div>

            <div>
                <label>
                    <spring:message code="address.details.streetNumber.label" />
                </label>
                    ${account.customer.billingAddress.streetNumber}
            </div>

            <div>
                <label>
                    <spring:message code="address.details.doorNumber.label" />
                </label>
                    ${account.customer.billingAddress.doorNumber}
            </div>

            <div>
                <label>
                    <spring:message code="address.details.zipCode.label" />
                </label>
                    ${account.customer.billingAddress.zipCode}
            </div>

            <div>
                <label>
                    <spring:message code="address.details.city.label" />
                </label>
                    ${account.customer.billingAddress.city.name}
            </div>

            <a href="<spring:url value="/addresses/edit/${account.username}" />"><spring:message code="edit" /></a>
        </security:authorize>
    </section>

    <jsp:include page="../_footer.jsp" />

</body>
</html>
