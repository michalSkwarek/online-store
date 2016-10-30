<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<section>
    <div>
        <a href="<spring:url value="/admin/products/new" />"><spring:message code="products.message.addNewProducts" /></a>
    </div>

    <div>
        <h1><spring:message code="products.message.allProducts" /></h1>
    </div>

    <div>
        <table>
            <tr>
                <td><spring:message code="product.details.model.label" /></td>
                <td><spring:message code="product.details.unitPrice.label" /></td>
                <td><spring:message code="product.details.category.label" /></td>
                <td><spring:message code="manufacturer.details.brand.label" /></td>
                <td><spring:message code="product.details.specifications.label" /></td>
                <td><spring:message code="products.message.addSpecifications" /></td>
                <td><spring:message code="edit" /></td>
                <td><spring:message code="delete" /></td>
            </tr>
            <c:forEach items="${products}" var="product">
                <tr>
                    <td>${product.model}</td>
                    <td>${product.unitPrice}</td>
                    <td>${product.category.name}</td>
                    <td>${product.manufacturer.brand}</td>
                    <td><a href="/products/${product.id}"><spring:message code="product.details.specifications.label" /></a></td>
                    <td>
                        <c:if test="${product.productSpecifications == null}">
                            <a href="<c:url value="/admin/products/spec/${product.id}"/>"><spring:message code="products.message.add" /></a>
                        </c:if>
                    </td>
                    <td><a href="/admin/products/edit/${product.id}"><spring:message code="edit" /></a></td>
                    <td><a href="/admin/products/delete/${product.id}"><spring:message code="delete" /></a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</section>
