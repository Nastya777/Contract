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

<a href="<c:url value="/logout" />">
	<spring:message code="label.logout" />
</a>
<div id="minfin-informer-m1Fn-nbu"><a href="http://minfin.com.ua/currency/" target="_blank"></a></a></div>
<script type="text/javascript">
var iframe = '<ifra'+'me width="100" height="42" fram'+'eborder="0" src="http://informer.minfin.com.ua/gen/nbu/?color=yellow" vspace="0" scrolling="no" hspace="0" allowtransparency="true"style="width:100px;height:42px;ove'+'rflow:hidden;"></iframe>';var cl = 'minfin-informer-m1Fn-nbu';document.getElementById(cl).innerHTML = iframe; </script><noscript><img src="http://informer.minfin.com.ua/gen/img.png" width="1" height="1" alt="minfin.com.ua: курсы валют" title="Курс валют" border="0" /></noscript>

<h2><spring:message code="label.title" /></h2>

<form:form name="form_add" method="post" action="add" commandName="contract" onsubmit="return validate_form();">

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
			<td><form:input path="summa" value="0.0" required="required"/></td>
		</tr>
		<tr>
			<td><form:label path="currency">
				Курс доллара
			</form:label></td>
			<td><input path="currency" value="<%= new org.odessa.contract.entities.NBU().getCurrency() %> " disabled/></td>
		</tr>
		
		<tr>
			<td colspan="2"><input type="submit"
				value="<spring:message code="label.addcontract"/>" /></td>
		</tr>
	</table>
</form:form>
 <script type="text/javascript">
    var value = 0.0;
  </script>
<h3><spring:message code="label.contracts" /></h3>
<c:if test="${!empty contractList}">
	<table class="data">
		<tr>
			<th>ID</th>
			<th><spring:message code="label.firstname" /></th>
			<th><spring:message code="label.email" /></th>
			<th><spring:message code="label.telephone" /></th>
			<th>Сумма USD</th>
			<th>Курс доллара</th>
			<th>Сумма UAH</th>
			<th>&nbsp;</th>
			<th>&nbsp;</th>
		</tr>
		<c:forEach items="${contractList}" var="contract">
			<tr>
				<td>${contract.id}</td>
				<td>${contract.lastname} ${contract.firstname}</td>
				<td>${contract.email}</td>
				<td>${contract.telephone}</td>
				<td>${contract.summa}</td>
				<td>${contract.currency}</td>
				<td style="text-align:right;">${contract.summa_nbu}</td>
				<td><a href="delete/${contract.id}"><spring:message code="label.delete" /></a></td>
				<td><a href="get/${contract.id}">Редактировать</a></td>
				<script type="text/javascript">
    				value +=${contract.summa_nbu};
  				</script>
			</tr>
		</c:forEach>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td style="text-align:right;"><span style='color:blue; font-weight:bold;' id='itog'></span></td>
				<td></td>
				<td></td>
			</tr>
	</table>
</c:if>

<h3><a href="downloadPDF">Download PDF Document</a></h3>
<script type="text/javascript">
document.getElementById('itog').innerHTML= "Итогo:"+ value.toFixed(2);
</script>
</body>
</html>