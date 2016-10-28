<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product data form</title>
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
        <form:form action="?${_csrf.parameterName}=${_csrf.token}" method="post" modelAttribute="product" enctype="multipart/form-data">
            <fieldset>
                <legend>
                    <spring:message code="productData.messages.productData" />
                </legend>

                <div>
                    <label for="model"><spring:message code="product.details.model.label" /></label>
                    <form:input path="model" id="model"/>
                </div>

                <div>
                    <label for="unitPrice"><spring:message code="product.details.unitPrice.label" /></label>
                    <form:input path="unitPrice" id="unitPrice"/>
                </div>

                <div>
                    <label for="category-select"><spring:message code="product.details.category.label" /></label>
                    <form:select path="category" id="category-select">
                        <c:if test="${product.category == null}">
                            <form:option value="${product.category.id}"> -- <spring:message code="productData.message.select" /> -- </form:option>
                        </c:if>
                        <form:options items="${categories}" itemLabel="name" itemValue="id" />
                    </form:select>
                </div>

                <div>
                    <label for="manufacturer-select"><spring:message code="product.details.manufacturer.label" /></label>
                    <form:select path="manufacturer" id="manufacturer-select">
                        <c:if test="${product.manufacturer == null}">
                            <form:option value="${product.manufacturer.id}"> -- <spring:message code="productData.message.select" /> -- </form:option>
                        </c:if>
                        <form:options items="${manufacturers}" itemLabel="brand" itemValue="id"/>
                    </form:select>
                </div>

                <c:if test="${product.productImage == null}">
                    <div>
                        <label for="productImage"><spring:message code="product.details.productImage.label" /></label>
                        <input name="fileUpload" id="productImage" type="file"/>
                    </div>
                </c:if>
                <c:if test="${product.productImage != null}">
                    <div>
                        <img src="/productImages/${product.id}" alt="product" style="width: 10%" />
                        <form:hidden path="productImage.id" />
                    </div>
                </c:if>

                <div>
                    <label for="unitsInMagazine"><spring:message code="product.details.unitsInMagazine.label" /></label>
                    <form:input path="unitsInMagazine" id="unitsInMagazine"/>
                </div>

                <c:if test="${product.productSpecifications != null}">
                    <div>
                        <label><spring:message code="product.details.specifications.label" /></label>
                        <a href="/admin/products/spec/edit/${product.productSpecifications.id}"><spring:message code="edit" /></a>
                        <form:hidden path="productSpecifications.id"/>
                    </div>
                </c:if>

                <div>
                    <input type="submit" value="<spring:message code="save" />" />
                </div>

            </fieldset>
        </form:form>
    </section>

    <jsp:include page="../_footer.jsp" />

</body>
</html>
