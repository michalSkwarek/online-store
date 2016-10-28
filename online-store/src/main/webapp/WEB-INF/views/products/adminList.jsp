<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All products</title>
</head>
<body>

    <section>
        <div>
            <jsp:include page="../_header.jsp" />
            <jsp:include page="../_menu.jsp" />
        </div>
        <div>
            <security:authorize  access="hasRole('ROLE_ADMIN')">
                <div>
                    <a href="<spring:url value="/admin/products/list" />"><spring:message code="products" /></a>
                    <a href="<spring:url value="/admin/manufacturers/list" />"><spring:message code="manufacturers" /></a>
                </div>
            </security:authorize>
        </div>
    </section>

    <section>
        <div>
            <a href="<spring:url value="/admin/products/new" />"><spring:message code="productsList.message.addNewProducts" /></a>
        </div>

        <div>
            <h1><spring:message code="productsList.message.allProducts" /></h1>
        </div>

        <div>
            <table>
                <tr>
                    <td><spring:message code="product.details.model.label" /></td>
                    <td><spring:message code="product.details.unitPrice.label" /></td>
                    <td><spring:message code="product.details.category.label" /></td>
                    <td><spring:message code="manufacturer.details.brand.label" /></td>
                    <td><spring:message code="product.details.specifications.label" /></td>
                    <td><spring:message code="adminList.message.addSpecifications" /></td>
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
                                <a href="<c:url value="/admin/products/spec/${product.id}"/>"><spring:message code="adminList.message.add" /></a>
                            </c:if>
                        </td>
                        <td><a href="/admin/products/edit/${product.id}"><spring:message code="edit" /></a></td>
                        <td><a href="/admin/products/delete/${product.id}"><spring:message code="delete" /></a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </section>

    <jsp:include page="../_footer.jsp" />

</body>
</html>
