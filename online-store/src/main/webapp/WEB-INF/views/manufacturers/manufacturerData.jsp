<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manufacturer data form</title>
</head>
<body>

    <jsp:include page="../_header.jsp" />
    <jsp:include page="../_menu.jsp" />

    <div>
        <security:authorize  access="hasRole('ROLE_ADMIN')">
            <ul>
                <li><a href="<spring:url value="/admin/products/list" />">Products</a></li>
                <li><a href="<spring:url value="/admin/manufacturers/list" />">Manufacturers</a></li>
            </ul>
        </security:authorize>
    </div>

    <h1>Manufacturer data</h1>

    <form:form action="?${_csrf.parameterName}=${_csrf.token}" method="post" modelAttribute="manufacturer" enctype="multipart/form-data">

        <ul>

            <li>
                <label for="brand">Name: </label>
                <form:input path="brand" id="brand"/>
            </li>

            <li>
                <label for="website">Website: </label>
                <form:input path="website" id="website"/>
            </li>

            <c:if test="${manufacturer.logo == null}">
                <li>
                    <label for="logo">Select logo: </label>
                    <input name="fileUpload" id="logo" type="file"/>
                </li>
            </c:if>
            <c:if test="${manufacturer.logo != null}">
                <li>
                    <label>Logo: </label>
                    <img src="/manufacturerImages/${manufacturer.id}" alt="manufacturer" style="width: 10%" />
                    <form:hidden path="logo.id" />
                </li>
            </c:if>

            <li>
                <input type="submit" value="Save"/>
            </li>

        </ul>

    </form:form>

    <jsp:include page="../_footer.jsp" />

</body>
</html>
