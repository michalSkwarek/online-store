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
        <form:form modelAttribute="spec" method="post">
            <fieldset>
                <legend>
                    <spring:message code="specificationsData.messages.specificationsData" />
                </legend>

                <c:if test="${spec.cpu != null}">
                    <div>
                        <p><spring:message code="specifications.details.cpu.label" /></p>
                        <label for="model"><spring:message code="specifications.details.cpu.model.label" /></label>
                        <form:input path="cpu.model" id="model"/>
                        <label for="numberOfCores"><spring:message code="specifications.details.cpu.numberOfCores.label" /></label>
                        <form:input path="cpu.numberOfCores" id="numberOfCores"/>
                        <label for="lowClockSpeed"><spring:message code="specifications.details.cpu.lowClockSpeed.label" /></label>
                        <form:input path="cpu.lowClockSpeed" id="lowClockSpeed"/>
                        <label for="highClockSpeed"><spring:message code="specifications.details.cpu.highClockSpeed.label" /></label>
                        <form:input path="cpu.highClockSpeed" id="highClockSpeed"/>
                    </div>
                </c:if>

                <c:if test="${spec.gpu != null}">
                    <div>
                        <p><spring:message code="specifications.details.gpu.label" /></p>
                        <label for="model"><spring:message code="specifications.details.gpu.model.label" /></label>
                        <form:input path="gpu.model" id="model"/>
                        <label for="memory"><spring:message code="specifications.details.gpu.memory.label" /></label>
                        <form:input path="gpu.memory" id="memory"/>
                        <label for="memoryType"><spring:message code="specifications.details.cpu.memoryType.label" /></label>
                        <form:input path="gpu.type" id="memoryType"/>
                    </div>
                </c:if>

                <c:if test="${spec.ram != null}">
                    <div>
                        <p><spring:message code="specifications.details.ram.label" /></p>
                        <label for="value"><spring:message code="specifications.details.ram.value.label" /></label>
                        <form:input path="ram.value" id="value"/>
                        <label for="type"><spring:message code="specifications.details.ram.memoryType.label" /></label>
                        <form:input path="ram.type" id="type"/>
                    </div>
                </c:if>

                <c:if test="${spec.storage != null}">
                    <div>
                        <p><spring:message code="specifications.details.storage.label" /></p>
                        <label for="diskMemory"><spring:message code="specifications.details.storage.diskMemory.label" /></label>
                        <form:input path="storage.diskMemory" id="diskMemory"/>
                        <label for="type"><spring:message code="specifications.details.storage.diskType.label" /></label>
                        <form:input path="storage.type" id="type"/>
                    </div>
                </c:if>

                <c:if test="${spec.display != null}">
                    <div>
                        <p><spring:message code="specifications.details.display.label" /></p>
                        <label for="diagonal"><spring:message code="specifications.details.display.diagonal.label" /></label>
                        <form:input path="display.diagonal" id="diagonal"/>
                        <label for="widthInPixels"><spring:message code="specifications.details.display.widthInPixels.label" /></label>
                        <form:input path="display.widthInPixels" id="widthInPixels"/>
                        <label for="heightInPixels"><spring:message code="specifications.details.display.heightInPixels.label" /></label>
                        <form:input path="display.heightInPixels" id="heightInPixels"/>
                    </div>
                </c:if>

                <c:if test="${spec.battery != null}">
                    <div>
                        <p><spring:message code="specifications.details.battery.label" /></p>
                        <label for="capacity"><spring:message code="specifications.details.battery.capacity.label" /></label>
                        <form:input path="battery.capacity" id="capacity"/>
                        <label for="type"><spring:message code="specifications.details.battery.batteryType.label" /></label>
                        <form:input path="battery.type" id="type"/>
                    </div>
                </c:if>

                <c:if test="${spec.powerSupply != null}">
                    <div>
                        <p><spring:message code="specifications.details.powerSupply.label" /></p>
                        <form:input path="powerSupply.power"/>
                    </div>
                </c:if>

                <c:if test="${spec.os != null}">
                    <div>
                        <p><spring:message code="specifications.details.os.label" /></p>
                        <label for="name"><spring:message code="specifications.details.os.name.label" /></label>
                        <form:input path="os.name" id="name"/>
                        <label for="version"><spring:message code="specifications.details.os.version.label" /></label>
                        <form:input path="os.version" id="version"/>
                    </div>
                </c:if>

                <c:if test="${spec.camera != null}">
                    <div>
                        <p><spring:message code="specifications.details.camera.label" /></p>
                        <label for="resolutionMainCamera"><spring:message code="specifications.details.os.mainCamera.label" /></label>
                        <form:input path="camera.resolutionMainCamera" id="resolutionMainCamera"/>
                        <label for="resolutionFrontCamera"><spring:message code="specifications.details.os.frontCamera.label" /></label>
                        <form:input path="camera.resolutionFrontCamera" id="resolutionFrontCamera"/>
                    </div>
                </c:if>

                <c:if test="${spec.webcam != null}">
                    <div>
                        <p><spring:message code="specifications.details.webcam.label" /></p>
                        <form:input path="webcam.resolutionWebcam"/>
                    </div>
                </c:if>

                <c:if test="${spec.dimensions != null}">
                    <div>
                        <p><spring:message code="specifications.details.dimensions.label" /></p>
                        <label for="thickness"><spring:message code="specifications.details.dimensions.thickness.label" /></label>
                        <form:input path="dimensions.thickness" id="thickness"/>
                        <label for="width"><spring:message code="specifications.details.dimensions.width.label" /></label>
                        <form:input path="dimensions.width" id="width"/>
                        <label for="height"><spring:message code="specifications.details.dimensions.height.label" /></label>
                        <form:input path="dimensions.height" id="height"/>
                    </div>
                </c:if>

                <c:if test="${spec.weight != null}">
                    <div>
                        <p><spring:message code="specifications.details.weight.label" /></p>
                        <form:input path="weight.value"/>
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
