<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Address data form</title>
</head>
<body>

    <security:authorize  access="hasAnyRole('ROLE_USER', 'ROLE_ADMIN')">
        <jsp:include page="../_header.jsp" />
        <jsp:include page="../_menu.jsp" />
    </security:authorize>

    <section>
        <form:form modelAttribute="address" method="post">
            <fieldset>
                <legend>
                    <spring:message code="addressData.messages.addressData" />
                </legend>

                <form:hidden path="id" />

                <div>
                    <label for="street">
                        <spring:message code="address.details.street.label" />
                    </label>
                    <div>
                        <form:input path="street" id="street" />
                    </div>
                </div>

                <div>
                    <label for="streetNumber">
                        <spring:message code="address.details.streetNumber.label" />
                    </label>
                    <div>
                        <form:input path="streetNumber" id="streetNumber" />
                    </div>
                </div>

                <div>
                    <label for="doorNumber">
                        <spring:message code="address.details.doorNumber.label" />
                    </label>
                    <div>
                        <form:input path="doorNumber" id="doorNumber" />
                    </div>
                </div>

                <div>
                    <label for="zipCode">
                        <spring:message code="address.details.zipCode.label" />
                    </label>
                    <div>
                        <form:input path="zipCode" id="zipCode" />
                    </div>
                </div>

                <div>
                    <label for="city">
                        <spring:message code="address.details.city.label" />
                    </label>
                    <div>
                        <form:input path="city.name" id="city" />
                    </div>
                </div>

                <div>
                    <input type="submit" value="<spring:message code="save" />" />
                </div>

            </fieldset>
        </form:form>
    </section>

    <jsp:include page="../_footer.jsp" />

</body>
</html>
