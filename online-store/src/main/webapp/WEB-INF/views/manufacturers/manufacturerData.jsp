<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<section class="form">
    <form:form action="?${_csrf.parameterName}=${_csrf.token}" method="post" modelAttribute="manufacturer" enctype="multipart/form-data">
        <fieldset>
            <legend>
                <spring:message code="manufacturers.messages.manufacturerData" />
            </legend>

            <div class="box">
                <div class="error">
                    <form:errors path="brand" />
                </div>
                <label for="brand" class="title">
                    <spring:message code="manufacturer.details.brand.label" />
                </label>
                <div>
                    <form:input path="brand" id="brand" cssClass="field" />
                </div>
            </div>

            <div class="box">
                <label for="website" class="title">
                    <spring:message code="manufacturer.details.website.label" />
                </label>
                <div>
                    <form:input path="website" id="website" cssClass="field" />
                </div>
            </div>

            <div class="box">
                <c:choose>
                    <c:when test="${manufacturer.logo == null}">
                        <label for="logo" class="title">
                            <spring:message code="manufacturer.details.logo.label" />
                        </label>
                        <div>
                            <input name="fileUpload" id="logo" type="file" />
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="image">
                            <img src="/manufacturerImages/${manufacturer.id}" alt="manufacturer" style="width: 50%" />
                            <form:hidden path="logo.id" />
                        </div>
                    </c:otherwise>
                </c:choose>
            </div>

            <div>
                <input type="submit" value="<spring:message code="save" />" />
            </div>

        </fieldset>
    </form:form>
</section>