<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html>
<head>
    <link rel="stylesheet" href="../../../resources/css/styles.css" type="text/css" />
    <title><tiles:insertAttribute name="title" /></title>
</head>
<body>
    <section class="wrapper">
        <div class="header">
            <tiles:insertAttribute name="header" />
        </div>

        <div class="content">
            <tiles:insertAttribute name="content" />
        </div>

        <div class="footer">
            <tiles:insertAttribute name="footer" />
        </div>
    </section>
</body>
</html>
