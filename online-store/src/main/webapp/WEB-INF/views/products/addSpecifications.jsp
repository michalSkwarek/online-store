<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add specifications</title>
</head>
<body>
    <h1>Add specifications to product</h1>

    <form:form method="post" modelAttribute="spec">

        <ul>
            <c:if test="${spec.display != null}">
                <li>
                    <p>Display</p>
                    <label for="diagonal">Diagonal: </label>
                    <form:input path="display.diagonal" id="diagonal"/>
                    <label for="widthInPixels">Width in pixels: </label>
                    <form:input path="display.widthInPixels" id="widthInPixels"/>
                    <label for="heightInPixels">Height in pixels: </label>
                    <form:input path="display.heightInPixels" id="heightInPixels"/>
                </li>
            </c:if>

            <c:if test="${spec.battery != null}">
                <li>
                    <p>Battery</p>
                    <label for="capacity">Capacity: </label>
                    <form:input path="battery.capacity" id="capacity"/>
                    <label for="type">Type: </label>
                    <form:input path="battery.type" id="type"/>
                </li>
            </c:if>

            <c:if test="${spec.powerSupply != null}">
                <li>
                    <p>Power supply</p>
                    <form:input path="powerSupply.power"/>
                </li>
            </c:if>

            <c:if test="${spec.os != null}">
                <li>
                    <p>Os</p>
                    <label for="name">Name: </label>
                    <form:input path="os.name" id="name"/>
                    <label for="version">Version: </label>
                    <form:input path="os.version" id="version"/>
                </li>
            </c:if>

            <c:if test="${spec.weight != null}">
                <li>
                    <p>Weight</p>
                    <form:input path="weight.value"/>
                </li>
            </c:if>

            <li>
                <input type="submit" value="Save"/>
            </li>
        </ul>
    </form:form>
</body>
</html>
