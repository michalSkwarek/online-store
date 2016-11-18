<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<section>
    <div class="form">
        <form:form modelAttribute="spec" method="post">
            <fieldset>
                <legend>
                    <spring:message code="products.message.specificationsData" />
                </legend>

                <div class="error">
                    <c:forEach items="${errors}" var="error">
                        ${error} <br>
                    </c:forEach>
                </div>

                <c:if test="${spec.cpu != null}">
                    <div class="box">
                        <p><spring:message code="specifications.details.cpu.label" /></p>
                        <label for="model" class="title"><spring:message code="specifications.details.cpu.model.label" /></label>
                        <div><form:input path="cpu.model" id="model" cssClass="input-field" /></div>
                        <label for="numberOfCores" class="title"><spring:message code="specifications.details.cpu.numberOfCores.label" /></label>
                        <div><form:input path="cpu.numberOfCores" id="numberOfCores" cssClass="input-field" /></div>
                        <label for="lowClockSpeed" class="title"><spring:message code="specifications.details.cpu.lowClockSpeed.label" /> (GHz)</label>
                        <div><form:input path="cpu.lowClockSpeed" id="lowClockSpeed" cssClass="input-field" /></div>
                        <label for="highClockSpeed" class="title"><spring:message code="specifications.details.cpu.highClockSpeed.label" /> (GHz)</label>
                        <div><form:input path="cpu.highClockSpeed" id="highClockSpeed" cssClass="input-field" /></div>
                    </div>
                </c:if>

                <c:if test="${spec.gpu != null}">
                    <div class="box">
                        <p><spring:message code="specifications.details.gpu.label" /></p>
                        <label for="model" class="title"><spring:message code="specifications.details.gpu.model.label" /></label>
                        <form:input path="gpu.model" id="model" cssClass="input-field" />
                        <label for="memory" class="title"><spring:message code="specifications.details.gpu.memory.label" /> (GB)</label>
                        <form:input path="gpu.memory" id="memory" cssClass="input-field" />
                        <label for="memoryType" class="title"><spring:message code="specifications.details.cpu.memoryType.label" /></label>
                        <form:input path="gpu.type" id="memoryType" cssClass="input-field" />
                    </div>
                </c:if>

                <c:if test="${spec.ram != null}">
                    <div class="box">
                        <p><spring:message code="specifications.details.ram.label" /></p>
                        <label for="value"><spring:message code="specifications.details.ram.value.label" /> (MB / GB)</label>
                        <form:input path="ram.value" id="value" cssClass="input-field" />
                        <label for="type"><spring:message code="specifications.details.ram.memoryType.label" /></label>
                        <form:input path="ram.type" id="type" cssClass="input-field" />
                    </div>
                </c:if>

                <c:if test="${spec.storage != null}">
                    <div class="box">
                        <p><spring:message code="specifications.details.storage.label" /></p>
                        <label for="diskMemory"><spring:message code="specifications.details.storage.diskMemory.label" /> (GB)</label>
                        <form:input path="storage.diskMemory" id="diskMemory" cssClass="input-field" />
                        <label for="type"><spring:message code="specifications.details.storage.diskType.label" /></label>
                        <form:input path="storage.type" id="type" cssClass="input-field" />
                    </div>
                </c:if>

                <c:if test="${spec.display != null}">
                    <div class="box">
                        <p><spring:message code="specifications.details.display.label" /></p>
                        <label for="diagonal"><spring:message code="specifications.details.display.diagonal.label" /> (")</label>
                        <form:input path="display.diagonal" id="diagonal" cssClass="input-field" />
                        <label for="widthInPixels"><spring:message code="specifications.details.display.widthInPixels.label" /></label>
                        <form:input path="display.widthInPixels" id="widthInPixels" cssClass="input-field" />
                        <label for="heightInPixels"><spring:message code="specifications.details.display.heightInPixels.label" /></label>
                        <form:input path="display.heightInPixels" id="heightInPixels" cssClass="input-field" />
                    </div>
                </c:if>

                <c:if test="${spec.battery != null}">
                    <div class="box">
                        <p><spring:message code="specifications.details.battery.label" /></p>
                        <label for="capacity"><spring:message code="specifications.details.battery.capacity.label" /> (mAh)</label>
                        <form:input path="battery.capacity" id="capacity" cssClass="input-field" />
                        <label for="type"><spring:message code="specifications.details.battery.batteryType.label" /></label>
                        <form:input path="battery.type" id="type" cssClass="input-field" />
                    </div>
                </c:if>

                <c:if test="${spec.powerSupply != null}">
                    <div class="box">
                        <p><spring:message code="specifications.details.powerSupply.label" /> (W)</p>
                        <form:input path="powerSupply.power" cssClass="input-field" />
                    </div>
                </c:if>

                <c:if test="${spec.os != null}">
                    <div class="box">
                        <p><spring:message code="specifications.details.os.label" /></p>
                        <label for="name"><spring:message code="specifications.details.os.name.label" /></label>
                        <form:input path="os.name" id="name" cssClass="input-field" />
                        <label for="version"><spring:message code="specifications.details.os.version.label" /></label>
                        <form:input path="os.version" id="version" cssClass="input-field" />
                    </div>
                </c:if>

                <c:if test="${spec.camera != null}">
                    <div class="box">
                        <p><spring:message code="specifications.details.camera.label" /> (MP)</p>
                        <label for="resolutionMainCamera"><spring:message code="specifications.details.os.mainCamera.label" /></label>
                        <form:input path="camera.resolutionMainCamera" id="resolutionMainCamera" cssClass="input-field" />
                        <label for="resolutionFrontCamera"><spring:message code="specifications.details.os.frontCamera.label" /></label>
                        <form:input path="camera.resolutionFrontCamera" id="resolutionFrontCamera" cssClass="input-field" />
                    </div>
                </c:if>

                <c:if test="${spec.webcam != null}">
                    <div class="box">
                        <p><spring:message code="specifications.details.webcam.label" /> (MP)</p>
                        <form:input path="webcam.resolutionWebcam" cssClass="input-field" />
                    </div>
                </c:if>

                <c:if test="${spec.dimensions != null}">
                    <div class="box">
                        <p><spring:message code="specifications.details.dimensions.label" /> (mm)</p>
                        <label for="thickness"><spring:message code="specifications.details.dimensions.thickness.label" /></label>
                        <form:input path="dimensions.thickness" id="thickness" cssClass="input-field" />
                        <label for="width"><spring:message code="specifications.details.dimensions.width.label" /></label>
                        <form:input path="dimensions.width" id="width" cssClass="input-field" />
                        <label for="height"><spring:message code="specifications.details.dimensions.height.label" /></label>
                        <form:input path="dimensions.height" id="height" cssClass="input-field" />
                    </div>
                </c:if>

                <c:if test="${spec.weight != null}">
                    <div class="box">
                        <p><spring:message code="specifications.details.weight.label" /> (g / kg)</p>
                        <form:input path="weight.value" cssClass="input-field" />
                    </div>
                </c:if>

                <div>
                    <input type="submit" class="button-save" value="<spring:message code="save" />" />
                </div>

            </fieldset>
        </form:form>
    </div>
</section>