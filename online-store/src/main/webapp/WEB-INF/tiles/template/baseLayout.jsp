<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html>
<head>
    <link rel="stylesheet" href="../../../resources/css/styles.css" type="text/css" />
    <title><tiles:insertAttribute name="title" /></title>
</head>
<body>
    <section>
        <div>
            <h1>Online store</h1>
        </div>

        <div>
            <tiles:insertAttribute name="headerMenuUserAdmin" />
        </div>

        <div>
            <tiles:insertAttribute name="header" />
        </div>

        <div>
            <tiles:insertAttribute name="menu" />
        </div>

        <div>
            <tiles:insertAttribute name="menuAdmin" />
        </div>

        <div>
            <tiles:insertAttribute name="content" />
        </div>

        <div>
            <tiles:insertAttribute name="footer" />
        </div>
    </section>
</body>
</html>
