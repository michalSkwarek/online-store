<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<section>
	<div class="error-view">
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
					<h1><spring:message code="orders.message.dear" />, ${username}</h1>
					<h2><spring:message code="security.message.userPermission" />!</h2>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
</section>