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

	<jsp:include page="../_header.jsp" />
	<jsp:include page="../_menu.jsp" />

	<h1>Access authentication</h1>

	<div>

		<c:if test="${not empty error}">
			<div>
				${error}
			</div>
		</c:if>
		<c:if test="${not empty message}">
			<div>
				${message}
			</div>
		</c:if>

		<form:form method="post">

			<table>
				<tr>
					<td>User: </td>
					<td><input type="text" name="username"></td>
				</tr>
				<tr>
					<td>Password: </td>
					<td><input type="password" name="password" /></td>
				</tr>
				<tr>
					<td>
						<input type="submit" value="Submit"/>
					</td>
				</tr>
			</table>

		</form:form>

	</div>

	<a href="<spring:url value="/accounts/new" />">Create new account</a>

	<jsp:include page="../_footer.jsp" />

</body>
</html>