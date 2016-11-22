<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<section>
    <div class="table">
        <div>
            <a href="<spring:url value="/admin/products/new" />">
                <button type="button" class="button-edit"><spring:message code="products.message.addNewProduct" /></button>
            </a>
        </div>

        <div>
            <p class="heading"><spring:message code="products.message.allProducts" /></p>
        </div>

        <div>
            <table class="list-table">
                <tr class="head">
                    <th><spring:message code="product.details.model.label" /></th>
                    <th><spring:message code="product.details.unitPrice.label" /></th>
                    <th><spring:message code="product.details.category.label" /></th>
                    <th><spring:message code="manufacturer.details.brand.label" /></th>
                    <th><spring:message code="product.details.specifications.label" /></th>
                    <th><spring:message code="products.message.addSpecifications" /></th>
                    <th><spring:message code="edit" /></th>
                    <th><spring:message code="delete" /></th>
                </tr>
                <c:forEach items="${products}" var="product">
                    <tr>
                        <td>${product.model}</td>
                        <td class="text-right">${product.unitPrice} PLN</td>
                        <td>${product.category.name}</td>
                        <td>${product.manufacturer.brand}</td>
                        <td class="option"><a href="/products/${product.id}"><spring:message code="product.details.specifications.label" /></a></td>
                        <td class="option">
                            <c:if test="${product.productSpecifications == null}">
                                <a href="<c:url value="/admin/products/spec/${product.id}"/>"><spring:message code="products.message.add" /></a>
                            </c:if>
                        </td>
                        <td class="option"><a href="/admin/products/edit/${product.id}"><spring:message code="edit" /></a></td>
                        <td class="option"><a href="/admin/products/delete/${product.id}"><spring:message code="delete" /></a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</section>
