<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>

	<jsp:include page="../_header.jsp" />
	<jsp:include page="../_menu.jsp" />

	<h1>Access is denied</h1>

	<c:choose>
		<c:when test="${empty username}">
			<h2>You do not have permission to access this page!</h2>
		</c:when>
		<c:otherwise>
			<h2>Dear ${username}</h2>
			<p>You do not have permission to access this page!</p>
		</c:otherwise>
	</c:choose>

	<jsp:include page="../_footer.jsp" />

</body>
</html>