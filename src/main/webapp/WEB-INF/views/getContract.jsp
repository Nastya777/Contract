<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf8">
	<title><spring:message code="label.title" /></title>
</head>
<body>
<form:form method="post" action="edit" commandName="contract">

	<table>
		<tr>
			<td><form:label path="firstname">
				<spring:message code="label.firstname" />
			</form:label></td>
			<td><form:input path="firstname" id="firstname" required="required" /></td>
		</tr>
		<tr>
			<td><form:label path="lastname">
				<spring:message code="label.lastname" />
			</form:label></td>
			<td><form:input path="lastname" id="lastname" required="required" /></td>
		</tr>
		<tr>
			<td><form:label path="email">
				<spring:message code="label.email" />
			</form:label></td>
			<td><form:input path="email" type="email" required="required"/></td>
		</tr>
		<tr>
			<td><form:label path="telephone">
				<spring:message code="label.telephone" />
			</form:label></td>
			<td><form:input path="telephone" required="required"/></td>
		</tr>
		<tr>
			<td><form:label path="summa">
				Сумма USD
			</form:label></td>
			<td><form:input path="summa" required="required"/></td>
		</tr>
		<tr>
			<td><form:label path="currency">
				Курс доллара
			</form:label></td>
			<td><input path="currency" value="${contract.currency}" disabled/></td>
		</tr>
		
		<tr>
			<td colspan="2"><input type="submit"
				value="Редактировать" /></td>
		</tr>
	</table>
</form:form>
</body>
</html>