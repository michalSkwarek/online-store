<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<section>
	<div class="info-view">
		<c:if test="${pageContext.request.userPrincipal.name != null}">
			<div>
				<h1><spring:message code="orders.message.dear" />, ${pageContext.request.userPrincipal.name}</h1>
			</div>

			<sec:authorize access="hasRole('ROLE_USER')">
				<div>
					<h2><spring:message code="homePage.message.welcomeToOurOnlineStore" /></h2>
				</div>
			</sec:authorize>

			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<div>
					<h2><spring:message code="security.message.adminPermission" />!</h2>
				</div>
			</sec:authorize>
		</c:if>
	</div>
</section>