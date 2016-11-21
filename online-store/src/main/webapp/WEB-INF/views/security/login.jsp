<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="true"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<section>
	<div class="login-page">
		<div class="heading">
			<h1><spring:message code="security.message.accessAuthentication" /></h1>
		</div>

		<div>
			<c:if test="${error == true}">
				<div class="wrong">
					<p><spring:message code="security.message.invalidUsernameAndPassword" /></p>
				</div>
			</c:if>
			<c:if test="${message == true}">
				<div class="info">
					<p><spring:message code="security.message.youHaveBeenLoggedOutSuccessfully" /></p>
				</div>
			</c:if>
		</div>

		<div>
			<form:form method="post" cssClass="login-form">
				<input type="text" name="username" placeholder="<spring:message code="account.details.username.label" />"/>
				<input type="password" name="password" placeholder="<spring:message code="account.details.password.label" />"/>
				<button class="button-save"><spring:message code="submit" /></button>
				<p class="message"><spring:message code="security.message.notRegistered" />?
					<a href="<spring:url value="/accounts/new" />"><spring:message code="security.message.createNewAccount" /></a>
				</p>
			</form:form>
		</div>

		<div>
			<table class="list-table">
				<tr class="head">
					<th>Example</th>
					<th><spring:message code="account.details.username.label" /></th>
					<th><spring:message code="account.details.password.label" /></th>
				</tr>
				<tr>
					<td><spring:message code="user" /></td>
					<td>aaa</td>
					<td>111</td>
				</tr>
				<tr>
					<td><spring:message code="admin" /></td>
					<td>zzz</td>
					<td>999</td>
				</tr>
			</table>
		</div>

	</div>
</section>