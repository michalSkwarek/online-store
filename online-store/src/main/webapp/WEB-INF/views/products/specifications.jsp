<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product specifications</title>
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
            <h1><spring:message code="product.details.specifications.label" /></h1>
        </div>

        <div>
            <div>
                <img src="/productImages/${product.id}" alt="product" style="width: 10%" />
            </div>
            <div>
                <spring:message code="product.details.model.label" /> ${product.model}
            </div>
            <div>
                <spring:message code="product.details.unitPrice.label" /> ${product.unitPrice}
            </div>
            <div>
                <spring:message code="product.details.category.label" /> ${product.category.name}
            </div>
            <div>
                <spring:message code="product.details.manufacturer.label" /> ${product.manufacturer.brand}
            </div>
            <security:authorize  access="hasRole('ROLE_ADMIN')">
                <div>
                    <spring:message code="product.details.unitsInMagazine.label" /> ${product.unitsInMagazine}
                </div>
            </security:authorize>
            <security:authorize  access="hasRole('ROLE_USER')">
                <div>
                    <spring:message code="menu.message.homePage" /> ${product.isAvailability()}
                </div>
            </security:authorize>
        </div>

        <div>
            <spring:message code="products.details" />
        </div>

        <div>
            <c:if test="${product.productSpecifications.cpu != null}">
                <div>
                    <spring:message code="specifications.details.cpu.label" /> ${product.productSpecifications.cpu}
                </div>
            </c:if>

            <c:if test="${product.productSpecifications.gpu != null}">
                <div>
                    <spring:message code="specifications.details.gpu.label" /> ${product.productSpecifications.gpu}
                </div>
            </c:if>

            <c:if test="${product.productSpecifications.ram != null}">
                <div>
                    <spring:message code="specifications.details.ram.label" /> ${product.productSpecifications.ram}
                </div>
            </c:if>

            <c:if test="${product.productSpecifications.storage != null}">
                <div>
                    <spring:message code="specifications.details.storage.label" /> ${product.productSpecifications.storage}
                </div>
            </c:if>

            <c:if test="${product.productSpecifications.display != null}">
                <div>
                    <spring:message code="specifications.details.display.label" /> ${product.productSpecifications.display}
                </div>
            </c:if>

            <c:if test="${product.productSpecifications.battery != null}">
                <div>
                    <spring:message code="specifications.details.battery.label" /> ${product.productSpecifications.battery}
                </div>
            </c:if>

            <c:if test="${product.productSpecifications.powerSupply != null}">
                <div>
                    <spring:message code="specifications.details.powerSupply.label" /> ${product.productSpecifications.powerSupply}
                </div>
            </c:if>

            <c:if test="${product.productSpecifications.os != null}">
                <div>
                    <spring:message code="specifications.details.os.label" /> ${product.productSpecifications.os}
                </div>
            </c:if>

            <c:if test="${product.productSpecifications.camera != null}">
                <div>
                    <spring:message code="specifications.details.camera.label" /> ${product.productSpecifications.camera}
                </div>
            </c:if>

            <c:if test="${product.productSpecifications.webcam != null}">
                <div>
                    <spring:message code="specifications.details.webcam.label" /> ${product.productSpecifications.webcam}
                </div>
            </c:if>

            <c:if test="${product.productSpecifications.dimensions != null}">
                <div>
                    <spring:message code="specifications.details.dimensions.label" /> ${product.productSpecifications.dimensions}
                </div>
            </c:if>

            <c:if test="${product.productSpecifications.weight != null}">
                <div>
                    <spring:message code="specifications.details.weight.label" /> ${product.productSpecifications.weight}
                </div>
            </c:if>
        </div>
    </section>

    <section>
        <div>
            <security:authorize  access="hasRole('ROLE_ADMIN')">
                <c:if test="${product.productSpecifications != null}">
                    <div>
                        <a href="<spring:url value="/admin/products/spec/edit/${product.productSpecifications.id}" />">
                            <spring:message code="adminList.message.editSpecifications" />
                        </a>
                    </div>
                </c:if>
            </security:authorize>

            <security:authorize  access="!hasRole('ROLE_ADMIN')">
                <div>
                    <a href="<spring:url value="/order/addProduct?id=${product.id}" />"><spring:message code="products.addToCart" /></a>
                </div>
            </security:authorize>
        </div>
    </section>

    <jsp:include page="../_footer.jsp" />

</body>
</html>
