<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="true"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Login Page</title>
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
			<h1><spring:message code="security.message.accessAuthentication" /></h1>
		</div>

		<div>
			<div>
				<c:if test="${error == true}">
					<div>
							<p><spring:message code="security.message.invalidUsernameAndPassword" /></p>
					</div>
				</c:if>
				<c:if test="${message == true}">
					<div>
							<p><spring:message code="security.message.youHaveveBeenLoggedOutSuccessfully" /></p>
					</div>
				</c:if>
			</div>

			<div>
				<form:form method="post">
					<table>
						<tr>
							<td><spring:message code="account.details.username.label" />: </td>
							<td><input type="text" name="username"></td>
						</tr>
						<tr>
							<td><spring:message code="account.details.password.label" />: </td>
							<td><input type="password" name="password" /></td>
						</tr>
						<tr>
							<td>
								<input type="submit" value="<spring:message code="submit" />"/>
							</td>
						</tr>
					</table>
				</form:form>
			</div>

			<div>
				<table>
					<p><spring:message code="example" /></p>
					<tr>
						<th></th>
						<th><spring:message code="account.details.username.label" /></th>
						<th><spring:message code="account.details.password.label" /></th>
					</tr>
					<tr>
						<td>User:</td>
						<td>aaa</td>
						<td>111</td>
					</tr>
					<tr>
						<td>Admin:</td>
						<td>zzz</td>
						<td>999</td>
					</tr>
				</table>
			</div>
		</div>

		<div>
			<a href="<spring:url value="/accounts/new" />"><spring:message code="security.message.createNewAccount" /></a>
		</div>
	</section>

	<jsp:include page="../_footer.jsp" />

</body>
</html>