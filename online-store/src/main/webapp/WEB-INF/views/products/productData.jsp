<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<section>
    <div class="form">
        <form:form action="?${_csrf.parameterName}=${_csrf.token}" method="post" modelAttribute="product" enctype="multipart/form-data">
            <fieldset>
                <legend>
                    <spring:message code="products.messages.productData" />
                </legend>

                <div class="box">
                    <div class="error">
                        <form:errors path="model" />
                    </div>
                    <label for="model" class="title">
                        <spring:message code="product.details.model.label" />
                    </label>
                    <div>
                        <form:input path="model" id="model" cssClass="input-field" />
                    </div>
                </div>

                <div class="box">
                    <div class="error">
                        <form:errors path="unitPrice" />
                    </div>
                    <label for="unitPrice" class="title">
                        <spring:message code="product.details.unitPrice.label" />
                    </label>
                    <div>
                        <form:input path="unitPrice" id="unitPrice" cssClass="input-field" />
                    </div>
                </div>

                <div class="box">
                    <div class="error">
                        <form:errors path="category" />
                    </div>
                    <label for="category-select" class="title">
                        <spring:message code="product.details.category.label" />
                    </label>
                    <div>
                        <form:select path="category" id="category-select">
                            <c:if test="${product.category == null}">
                                <form:option value="${product.category.id}"> -- <spring:message code="products.message.select" /> -- </form:option>
                            </c:if>
                            <form:options items="${categories}" itemLabel="name" itemValue="id" />
                        </form:select>
                    </div>
                </div>

                <div class="box">
                    <div class="error">
                        <form:errors path="manufacturer" />
                    </div>
                    <label for="manufacturer-select" class="title">
                        <spring:message code="product.details.manufacturer.label" />
                    </label>
                    <div>
                        <form:select path="manufacturer" id="manufacturer-select">
                            <c:if test="${product.manufacturer == null}">
                                <form:option value="${product.manufacturer.id}"> -- <spring:message code="products.message.select" /> -- </form:option>
                            </c:if>
                            <form:options items="${manufacturers}" itemLabel="brand" itemValue="id"/>
                        </form:select>
                    </div>
                </div>

                <div class="box">
                    <c:choose>
                        <c:when test="${product.productImage == null}">
                            <label for="productImage" class="title">
                                <spring:message code="product.details.productImage.label" />
                            </label>
                            <div>
                                <input name="fileUpload" id="productImage" type="file" />
                            </div>
                        </c:when>
                        <c:otherwise>
                            <div class="image">
                                <img src="/productImages/${product.id}" alt="product" width="50%" />
                                <form:hidden path="productImage.id" />
                            </div>
                        </c:otherwise>
                    </c:choose>
                </div>

                <div class="box">
                    <div class="error">
                        <form:errors path="unitsInMagazine" />
                    </div>
                    <label for="unitsInMagazine" class="title">
                        <spring:message code="product.details.unitsInMagazine.label" />
                    </label>
                    <div>
                        <form:input path="unitsInMagazine" id="unitsInMagazine" cssClass="input-field"/>
                    </div>
                </div>

                <c:if test="${product.productSpecifications != null}">
                    <div>
                        <a href="/admin/products/spec/edit/${product.productSpecifications.id}">
                            <button type="button" class="button-edit"><spring:message code="products.message.editSpecifications" /></button>
                        </a>
                        <form:hidden path="productSpecifications.id"/>
                    </div>
                </c:if>

                <div>
                    <input type="submit" class="button-save" value="<spring:message code="save" />" />
                </div>

            </fieldset>
        </form:form>
    </div>
</section>