<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All manufacturers</title>
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
        <div>
            <a href="<spring:url value="/admin/manufacturers/new" />"><spring:message code="manufacturers.message.addNewManufacturers" /></a>
        </div>

        <div>
            <h1><spring:message code="manufacturers.message.allManufacturers" /></h1>
        </div>

        <div>
            <table>
                <tr>
                    <td><spring:message code="manufacturer.details.brand.label" /></td>
                    <td><spring:message code="manufacturer.details.website.label" /></td>
                    <td><spring:message code="edit" /></td>
                    <td><spring:message code="delete" /></td>
                </tr>
                <c:forEach items="${manufacturers}" var="manufacturer">
                    <tr>
                        <td>${manufacturer.brand}</td>
                        <td><a href="${manufacturer.website}">${manufacturer.website}</a></td>
                        <td><a href="/admin/manufacturers/edit/${manufacturer.id}"><spring:message code="edit" /></a></td>
                        <td><a href="/admin/manufacturers/delete/${manufacturer.id}"><spring:message code="delete" /></a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </section>

    <jsp:include page="../_footer.jsp" />

</body>
</html>
