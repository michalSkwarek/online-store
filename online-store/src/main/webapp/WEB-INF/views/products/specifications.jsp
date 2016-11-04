<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<section class="specifications">
    <div class="description">
        <spring:message code="product.details.specifications.label" />
    </div>

    <div>
        <div class="image">
            <img src="/productImages/${product.id}" alt="product" style="width: 50%" />
        </div>
        <div class="box">
            <label class="title">
                <spring:message code="product.details.model.label" />
            </label>
            <div class="data">
                ${product.model}
            </div>
        </div>
        <div class="box">
            <label class="title">
                <spring:message code="product.details.unitPrice.label" />
            </label>
            <div class="data">
                ${product.unitPrice} PLN
            </div>
        </div>
        <div class="box">
            <label class="title">
                <spring:message code="product.details.category.label" />
            </label>
            <div class="data">
                ${product.category.name}
            </div>
        </div>
        <div class="box">
            <label class="title">
                <spring:message code="product.details.manufacturer.label" />
            </label>
            <div class="data">
                ${product.manufacturer.brand}
            </div>
        </div>
        <security:authorize  access="hasRole('ROLE_ADMIN')">
            <div class="box">
                <label class="title">
                    <spring:message code="product.details.unitsInMagazine.label" />
                </label>
                <div class="data">
                        ${product.unitsInMagazine}
                </div>
            </div>
        </security:authorize>
        <security:authorize  access="!hasRole('ROLE_ADMIN')">
            <div class="box">
                <label class="title">
                    <spring:message code="product.details.availability.label" />
                </label>
                <div class="data">
                    <c:if test="${product.isAvailability() == true}">
                        <spring:message code="yes" />
                    </c:if>
                    <c:if test="${product.isAvailability() == false}">
                        <spring:message code="no" />
                    </c:if>
                </div>
            </div>
        </security:authorize>
    </div>

    <div class="description">
        <spring:message code="products.message.details" />
    </div>

    <div>
        <c:if test="${product.productSpecifications.cpu != null}">
            <div class="box">
                <label class="title">
                    <spring:message code="specifications.details.cpu.label" />
                </label>
                <div class="data">
                        ${product.productSpecifications.cpu}
                </div>
            </div>
        </c:if>

        <c:if test="${product.productSpecifications.gpu != null}">
            <div class="box">
                <label class="title">
                    <spring:message code="specifications.details.gpu.label" />
                </label>
                <div class="data">
                        ${product.productSpecifications.gpu}
                </div>
            </div>
        </c:if>

        <c:if test="${product.productSpecifications.ram != null}">
            <div class="box">
                <label class="title">
                    <spring:message code="specifications.details.ram.label" />
                </label>
                <div class="data">
                        ${product.productSpecifications.ram}
                </div>
            </div>
        </c:if>

        <c:if test="${product.productSpecifications.storage != null}">
            <div class="box">
                <label class="title">
                    <spring:message code="specifications.details.storage.label" />
                </label>
                <div class="data">
                        ${product.productSpecifications.storage}
                </div>
            </div>
        </c:if>

        <c:if test="${product.productSpecifications.display != null}">
            <div class="box">
                <label class="title">
                    <spring:message code="specifications.details.display.label" />
                </label>
                <div class="data">
                        ${product.productSpecifications.display}
                </div>
            </div>
        </c:if>

        <c:if test="${product.productSpecifications.battery != null}">
            <div class="box">
                <label class="title">
                    <spring:message code="specifications.details.battery.label" />
                </label>
                <div class="data">
                        ${product.productSpecifications.battery}
                </div>
            </div>
        </c:if>

        <c:if test="${product.productSpecifications.powerSupply != null}">
            <div class="box">
                <label class="title">
                    <spring:message code="specifications.details.powerSupply.label" />
                </label>
                <div class="data">
                        ${product.productSpecifications.powerSupply}
                </div>
            </div>
        </c:if>

        <c:if test="${product.productSpecifications.os != null}">
            <div class="box">
                <label class="title">
                    <spring:message code="specifications.details.os.label" />
                </label>
                <div class="data">
                        ${product.productSpecifications.os}
                </div>
            </div>
        </c:if>

        <c:if test="${product.productSpecifications.camera != null}">
            <div class="box">
                <label class="title">
                    <spring:message code="specifications.details.camera.label" />
                </label>
                <div class="data">
                        ${product.productSpecifications.camera}
                </div>
            </div>
        </c:if>

        <c:if test="${product.productSpecifications.webcam != null}">
            <div class="box">
                <label class="title">
                    <spring:message code="specifications.details.webcam.label" />
                </label>
                <div class="data">
                        ${product.productSpecifications.webcam}
                </div>
            </div>
        </c:if>

        <c:if test="${product.productSpecifications.dimensions != null}">
            <div class="box">
                <label class="title">
                    <spring:message code="specifications.details.dimensions.label" />
                </label>
                <div class="data">
                        ${product.productSpecifications.dimensions}
                </div>
            </div>
        </c:if>

        <c:if test="${product.productSpecifications.weight != null}">
            <div class="box">
                <label class="title">
                    <spring:message code="specifications.details.weight.label" />
                </label>
                <div class="data">
                        ${product.productSpecifications.weight}
                </div>
            </div>
        </c:if>
    </div>

    <div>
        <security:authorize  access="hasRole('ROLE_ADMIN')">
            <c:if test="${product.productSpecifications != null}">
                <div>
                    <a href="<spring:url value="/admin/products/spec/edit/${product.productSpecifications.id}" />">
                        <spring:message code="products.message.editSpecifications" />
                    </a>
                </div>
            </c:if>
        </security:authorize>

        <security:authorize  access="!hasRole('ROLE_ADMIN')">
            <div>
                <a href="<spring:url value="/order/addProduct?id=${product.id}" />"><spring:message code="products.message.addToCart" /></a>
            </div>
        </security:authorize>
    </div>
</section>