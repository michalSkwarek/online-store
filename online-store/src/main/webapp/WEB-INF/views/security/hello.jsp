<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>

	<jsp:include page="../_header.jsp" />
	<jsp:include page="../_menu.jsp" />

	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<h1>Dear ${pageContext.request.userPrincipal.name}</h1>

		<sec:authorize access="hasRole('ROLE_USER')">
			<h1>Welcome to our online store!</h1>
		</sec:authorize>

		<sec:authorize access="hasRole('ROLE_ADMIN')">
			<h1>You have admin permission!</h1>
		</sec:authorize>
	</c:if>

	<jsp:include page="../_footer.jsp" />

</body>
</html>