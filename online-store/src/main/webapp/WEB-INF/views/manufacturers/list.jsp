<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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