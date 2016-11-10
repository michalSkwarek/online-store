<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<section>
    <div class="admin-table">
        <div>
            <a href="<spring:url value="/admin/manufacturers/new" />">
                <button type="button" class="button-edit"><spring:message code="manufacturers.message.addNewManufacturer" /></button>
            </a>
        </div>

        <div>
            <p class="heading"><spring:message code="manufacturers.message.allManufacturers" /></p>
        </div>

        <div>
            <table class="list-table">
                <tr class="head">
                    <th><spring:message code="manufacturer.details.brand.label" /></th>
                    <th><spring:message code="manufacturer.details.website.label" /></th>
                    <th><spring:message code="edit" /></th>
                    <th><spring:message code="delete" /></th>
                </tr>
                <c:forEach items="${manufacturers}" var="manufacturer">
                    <tr>
                        <td>${manufacturer.brand}</td>
                        <td><a href="${manufacturer.website}">${manufacturer.website}</a></td>
                        <td class="option"><a href="/admin/manufacturers/edit/${manufacturer.id}"><spring:message code="edit" /></a></td>
                        <td class="option"><a href="/admin/manufacturers/delete/${manufacturer.id}"><spring:message code="delete" /></a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</section>