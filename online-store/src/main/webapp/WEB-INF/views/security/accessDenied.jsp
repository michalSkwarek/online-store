<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
	<title>Access denied</title>
</head>
<body>

	<div>
		<jsp:include page="../_header.jsp" />
		<jsp:include page="../_menu.jsp" />
	</div>

	<div>
		<div>
			<h1><spring:message code="security.message.accessIsDenied" /></h1>
		</div>

		<c:choose>
			<c:when test="${empty username}">
				<div>
					<h2><spring:message code="security.message.userPermission" />!</h2>
				</div>
			</c:when>
			<c:otherwise>
				<div>
					<h2><spring:message code="thanks.message.dear" />, ${username}</h2>
					<h2><spring:message code="security.message.userPermission" />!</h2>
				</div>
			</c:otherwise>
		</c:choose>
	</div>

	<jsp:include page="../_footer.jsp" />

</body>
</html>