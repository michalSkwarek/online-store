<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<section>
    <div>
        <form:form method="post">
            <div class="select-box">
                <p class="heading"><spring:message code="products.message.selectCategories" /></p>
                <c:forEach items="${categories}" var="category">
                    <label>
                        <input type="checkbox" name="category" value="${category.name}">${category.name}
                    </label>
                </c:forEach>
            </div>

            <div class="select-box">
                <p class="heading"><spring:message code="products.message.selectManufacturers" /></p>
                <c:forEach items="${manufacturers}" var="manufacturer" >
                    <label>
                        <input type="checkbox" name="manufacturer" value="${manufacturer.brand}">${manufacturer.brand}
                    </label>
                </c:forEach>
            </div>

            <div class="select-box">
                <p class="heading"><spring:message code="products.message.selectPriceRange" /></p>
                <label>
                    <spring:message code="products.message.from" /> <input type="text" name="fromPriceRange"> PLN
                    <spring:message code="products.message.to" /> <input type="text" name="toPriceRange"> PLN
                </label>
            </div>

            <div class="select-box">
                <p class="heading"><spring:message code="products.message.selectPriceOrder" /></p>
                <label>
                    <input type="radio" name="priceOrder" value="asc" checked><spring:message code="products.message.ascending" />
                    <input type="radio" name="priceOrder" value="desc"><spring:message code="products.message.descending" />
                </label>
            </div>

            <div>
                <input type="submit" class="button-save" value="<spring:message code="submit" />" />
            </div>
        </form:form>
    </div>

    <div class="product">
        <p class="heading"><spring:message code="products.message.allProducts" /></p>
        <c:forEach items="${products}" var="product">
            <div class="product-frame">
                <img src="/productImages/${product.id}" alt="product" width="230px" />
                <p>${product.manufacturer.brand} ${product.model}</p>
                <p>${product.unitPrice} PLN</p>
                <p>${product.category.name}</p>
                <div>
                    <a href="<spring:url value="/products/${product.id}" />">
                        <button type="button" class="button-details"><spring:message code="products.message.details" /></button>
                    </a>
                </div>
                <security:authorize  access="!hasRole('ROLE_ADMIN')">
                    <div>
                        <a href="<spring:url value="/order/addProduct?id=${product.id}" />">
                            <button type="button" class="button-add-to-cart"><spring:message code="products.message.addToCart" /></button>
                        </a>
                    </div>
                </security:authorize>
            </div>
        </c:forEach>
    </div>

    <div class="manufacturer">
        <p class="heading"><spring:message code="homePage.message.goToTheManufacturersStore" /></p>
        <c:forEach items="${manufacturers}" var="manufacturer">
            <a href="<spring:url value="${manufacturer.website}" />">
                <img src="/manufacturerImages/${manufacturer.id}" alt="manufacturer" width="64px" />
            </a>
        </c:forEach>
    </div>
</section>