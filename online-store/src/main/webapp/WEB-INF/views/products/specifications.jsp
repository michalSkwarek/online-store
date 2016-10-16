<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product specifications</title>
</head>
<body>

    <jsp:include page="../_header.jsp" />
    <jsp:include page="../_menu.jsp" />

    <h1>Product specifications</h1>

    <ul>
        <li>Image:
            <img src="/productImages/${product.id}" alt="product" style="width: 10%" />
        </li>
        <li>Name: ${product.model}</li>
        <li>Unit price: ${product.unitPrice}</li>
        <li>Category: ${product.category.name}</li>
        <li>Manufacturer: ${product.manufacturer.brand}</li>
        <li>Units in magazine: ${product.unitsInMagazine}</li>
        <li>Availability: ${product.isAvailability()}</li>
    </ul>

    <h1>Details:</h1>

    <ul>
        <c:if test="${product.productSpecifications.id != null}">
            <li>Id: ${product.productSpecifications.id}</li>
        </c:if>

        <c:if test="${product.productSpecifications.cpu != null}">
            <li>CPU: ${product.productSpecifications.cpu}</li>
        </c:if>

        <c:if test="${product.productSpecifications.gpu != null}">
            <li>GPU: ${product.productSpecifications.gpu}</li>
        </c:if>

        <c:if test="${product.productSpecifications.ram != null}">
            <li>RAM: ${product.productSpecifications.ram}</li>
        </c:if>

        <c:if test="${product.productSpecifications.storage != null}">
            <li>Storage: ${product.productSpecifications.storage}</li>
        </c:if>

        <c:if test="${product.productSpecifications.display != null}">
            <li>Display: ${product.productSpecifications.display}</li>
        </c:if>

        <c:if test="${product.productSpecifications.battery != null}">
            <li>Battery: ${product.productSpecifications.battery}</li>
        </c:if>

        <c:if test="${product.productSpecifications.powerSupply != null}">
            <li>Power supply: ${product.productSpecifications.powerSupply}</li>
        </c:if>

        <c:if test="${product.productSpecifications.os != null}">
            <li>OS: ${product.productSpecifications.os}</li>
        </c:if>

        <c:if test="${product.productSpecifications.camera != null}">
            <li>Camera: ${product.productSpecifications.camera}</li>
        </c:if>

        <c:if test="${product.productSpecifications.webcam != null}">
            <li>Webcam: ${product.productSpecifications.webcam}</li>
        </c:if>

        <c:if test="${product.productSpecifications.dimensions != null}">
            <li>Dimensions: ${product.productSpecifications.dimensions}</li>
        </c:if>

        <c:if test="${product.productSpecifications.weight != null}">
            <li>Weight: ${product.productSpecifications.weight}</li>
        </c:if>

    </ul>

    <jsp:include page="../_footer.jsp" />

</body>
</html>
