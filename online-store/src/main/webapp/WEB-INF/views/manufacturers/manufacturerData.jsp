<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manufacturer data</title>
</head>
<body>

    <section>
        <div>
            <jsp:include page="../_header.jsp" />
            <jsp:include page="../_menu.jsp" />
        </div>
        <security:authorize  access="hasRole('ROLE_ADMIN')">
            <div>
                <a href="<spring:url value="/admin/products/list" />"><spring:message code="products" /></a>
                <a href="<spring:url value="/admin/manufacturers/list" />"><spring:message code="manufacturers" /></a>
            </div>
        </security:authorize>
    </section>

    <section>
        <form:form action="?${_csrf.parameterName}=${_csrf.token}" method="post" modelAttribute="manufacturer" enctype="multipart/form-data">
            <fieldset>
                <legend>
                    <spring:message code="manufacturerData.messages.manufacturerData" />
                </legend>

                <div>
                    <label for="brand">
                        <spring:message code="manufacturer.details.brand.label" />
                    </label>
                    <div>
                        <form:input path="brand" id="brand" />
                    </div>
                </div>

                <div>
                    <label for="website">
                        <spring:message code="manufacturer.details.website.label" />
                    </label>
                    <div>
                        <form:input path="website" id="website" />
                    </div>
                </div>

                <div>
                    <c:choose>
                        <c:when test="${manufacturer.logo == null}">
                            <label for="logo">
                                <spring:message code="manufacturer.details.logo.label" />
                            </label>
                            <div>
                                <input name="fileUpload" id="logo" type="file" />
                            </div>
                        </c:when>
                        <c:otherwise>
                            <div>
                                <img src="/manufacturerImages/${manufacturer.id}" alt="manufacturer" style="width: 10%" />
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

    <jsp:include page="../_footer.jsp" />

</body>
</html>
