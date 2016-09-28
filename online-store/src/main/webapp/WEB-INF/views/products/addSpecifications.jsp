<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add specifications</title>
</head>
<body>
    <h1>Add specifications to product</h1>

    <form:form method="post" modelAttribute="spec">

        <ul>
            <li>
                <label for="weight">Weight: </label>
                <form:input path="weight.weight" id="weight"/>
            </li>

            <li>
                <input type="submit" value="Save"/>
            </li>
        </ul>
    </form:form>
</body>
</html>
