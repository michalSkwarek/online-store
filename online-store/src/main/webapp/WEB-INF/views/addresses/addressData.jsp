<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<section>
    <div class="form">
        <form:form modelAttribute="address" method="post">
            <fieldset>
                <legend>
                    <spring:message code="addresses.messages.addressData" />
                </legend>

                <form:hidden path="id" />

                <div class="box">
                    <div class="error">
                        <form:errors path="street" />
                    </div>
                    <label for="street" class="title">
                        <spring:message code="address.details.street.label" />
                    </label>
                    <div>
                        <form:input path="street" id="street" cssClass="input-field" />
                    </div>
                </div>

                <div class="box">
                    <div class="error">
                        <form:errors path="streetNumber" />
                    </div>
                    <label for="streetNumber" class="title">
                        <spring:message code="address.details.streetNumber.label" />
                    </label>
                    <div>
                        <form:input path="streetNumber" id="streetNumber" cssClass="input-field" />
                    </div>
                </div>

                <div class="box">
                    <label for="doorNumber" class="title">
                        <spring:message code="address.details.doorNumber.label" />
                    </label>
                    <div>
                        <form:input path="doorNumber" id="doorNumber" cssClass="input-field" />
                    </div>
                </div>

                <div class="box">
                    <div class="error">
                        <form:errors path="zipCode" />
                    </div>
                    <label for="zipCode" class="title">
                        <spring:message code="address.details.zipCode.label" />
                    </label>
                    <div>
                        <form:input path="zipCode" id="zipCode" cssClass="input-field" />
                    </div>
                </div>

                <div class="box">
                    <div class="error">
                        <form:errors path="city.name" />
                    </div>
                    <label for="city" class="title">
                        <spring:message code="address.details.city.label" />
                    </label>
                    <div>
                        <form:input path="city.name" id="city" cssClass="input-field" />
                    </div>
                </div>

                <div>
                    <input type="submit" class="button-save" value="<spring:message code="save" />" />
                </div>

            </fieldset>
        </form:form>
    </div>
</section>