<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add specifications</title>
</head>
<body>

    <jsp:include page="../_header.jsp" />
    <jsp:include page="../_menu.jsp" />

    <div>
        <security:authorize  access="hasRole('ROLE_ADMIN')">
            <ul>
                <li><a href="<spring:url value="/admin/products/list" />">Products</a></li>
                <li><a href="<spring:url value="/admin/manufacturers/list" />">Manufacturers</a></li>
            </ul>
        </security:authorize>
    </div>

    <h1>Product specifications</h1>

    <form:form method="post" modelAttribute="spec">

        <ul>
            <c:if test="${spec.cpu != null}">
                <li>
                    <p>CPU:</p>
                    <label for="model">Model: </label>
                    <form:input path="cpu.model" id="model"/>
                    <label for="numberOfCores">Number of cores: </label>
                    <form:input path="cpu.numberOfCores" id="numberOfCores"/>
                    <label for="lowClockSpeed">Low clock speed: </label>
                    <form:input path="cpu.lowClockSpeed" id="lowClockSpeed"/>
                    <label for="highClockSpeed">High clock speed: </label>
                    <form:input path="cpu.highClockSpeed" id="highClockSpeed"/>
                </li>
            </c:if>

            <c:if test="${spec.gpu != null}">
                <li>
                    <p>GPU:</p>
                    <label for="model">Model: </label>
                    <form:input path="gpu.model" id="model"/>
                </li>
            </c:if>

            <c:if test="${spec.ram != null}">
                <li>
                    <p>RAM:</p>
                    <label for="value">Value: </label>
                    <form:input path="ram.value" id="value"/>
                    <label for="type">Type: </label>
                    <form:input path="ram.memoryType.type" id="type"/>
                </li>
            </c:if>

            <c:if test="${spec.storage != null}">
                <li>
                    <p>Storage:</p>
                    <label for="diskMemory">Disk memory: </label>
                    <form:input path="storage.diskMemory" id="diskMemory"/>
                </li>
            </c:if>

            <c:if test="${spec.display != null}">
                <li>
                    <p>Display:</p>
                    <label for="diagonal">Diagonal: </label>
                    <form:input path="display.diagonal" id="diagonal"/>
                    <label for="widthInPixels">Width in pixels: </label>
                    <form:input path="display.displayResolution.widthInPixels" id="widthInPixels"/>
                    <label for="heightInPixels">Height in pixels: </label>
                    <form:input path="display.displayResolution.heightInPixels" id="heightInPixels"/>
                </li>
            </c:if>

            <c:if test="${spec.battery != null}">
                <li>
                    <p>Battery:</p>
                    <label for="capacity">Capacity: </label>
                    <form:input path="battery.capacity" id="capacity"/>
                    <label for="type">Type: </label>
                    <form:input path="battery.batteryType.type" id="type"/>
                </li>
            </c:if>

            <c:if test="${spec.powerSupply != null}">
                <li>
                    <p>Power supply:</p>
                    <form:input path="powerSupply.power"/>
                </li>
            </c:if>

            <c:if test="${spec.os != null}">
                <li>
                    <p>Os:</p>
                    <label for="name">Name: </label>
                    <form:input path="os.name" id="name"/>
                    <label for="version">Version: </label>
                    <form:input path="os.version" id="version"/>
                </li>
            </c:if>

            <c:if test="${spec.camera != null}">
                <li>
                    <p>Camera:</p>
                    <label for="resolutionMainCamera">Main camera: </label>
                    <form:input path="camera.resolutionMainCamera" id="resolutionMainCamera"/>
                    <label for="resolutionFrontCamera">Front camera: </label>
                    <form:input path="camera.resolutionFrontCamera" id="resolutionFrontCamera"/>
                </li>
            </c:if>

            <c:if test="${spec.webcam != null}">
                <li>
                    <p>Webcam:</p>
                    <form:input path="webcam.resolutionWebcam"/>
                </li>
            </c:if>

            <c:if test="${spec.dimensions != null}">
                <li>
                    <p>Dimensions:</p>
                    <label for="thickness">Thickness: </label>
                    <form:input path="dimensions.thickness" id="thickness"/>
                    <label for="width">Width: </label>
                    <form:input path="dimensions.width" id="width"/>
                    <label for="height">Height: </label>
                    <form:input path="dimensions.height" id="height"/>
                </li>
            </c:if>

            <c:if test="${spec.weight != null}">
                <li>
                    <p>Weight:</p>
                    <form:input path="weight.value"/>
                </li>
            </c:if>

            <li>
                <input type="submit" value="Save"/>
            </li>
        </ul>
    </form:form>

    <jsp:include page="../_footer.jsp" />

</body>
</html>
