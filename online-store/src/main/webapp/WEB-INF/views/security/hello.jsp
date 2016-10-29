<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Hello</title>
</head>
<body>

	<section>
		<div>
			<jsp:include page="../_header.jsp" />
			<jsp:include page="../_menu.jsp" />
		</div>
	</section>

	<section>
		<div>
			<c:if test="${pageContext.request.userPrincipal.name != null}">
				<div>
					<h1><spring:message code="thanks.message.dear" />, ${pageContext.request.userPrincipal.name}</h1>
				</div>

				<sec:authorize access="hasRole('ROLE_USER')">
					<div>
						<h1><spring:message code="homePage.message.welcomeToOurOnlineStore" /></h1>
					</div>
				</sec:authorize>

				<sec:authorize access="hasRole('ROLE_ADMIN')">
					<div>
						<h1><spring:message code="security.message.adminPermission" />!</h1>
					</div>
				</sec:authorize>
			</c:if>
		</div>
	</section>

	<jsp:include page="../_footer.jsp" />

</body>
</html>