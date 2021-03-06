<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%
	response.setCharacterEncoding("UTF-8");
	request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Dodaj umowę</title>

<link type="text/css" rel="stylesheet" href="/css/inputFormDetails.css">

</head>
<body>
	<div id="container">
		<h3>Wypełnij dane umowy:</h3>
		<form:form action="saveOrder" modelAttribute="order" method="POST">
			<form:hidden path="id" />

			<table>
				<tbody>
					<tr>
						<td><label>Nazwa systemu:</label></td>
						<td><form:select path="systems.id">
								<form:option value="1">Wybierz system</form:option>
								<c:forEach var="system" items="${allSystems}">
									<option value="${system.id}">${system.systemName}</option>
								</c:forEach>
							</form:select></td>
					</tr>
					<tr>
						<td><label>Numer umowy</label></td>
						<td><form:input path="orderNumber" /> <form:errors
								path="orderNumber" class="errorInputValidation" /></td>
					</tr>
					<tr>
						<td><label>Data rozpoczęcia obowiązywania umowy:</label></td>
						<td><form:input type="date" path="fromDate" /> <form:errors
								path="fromDate" class="errorInputValidation" /></td>
					</tr>
					<tr>
						<td><label>Zakończenie obowiązywania:</label></td>
						<td><form:input type="date" path="toDate" /> <form:errors
								path="toDate" class="errorInputValidation" /></td>
					</tr>
					<tr>
						<td><label>Kwota umowy:</label></td>
						<td><form:input path="amount" /> <form:errors path="amount"
								class="errorInputValidation" /></td>
					</tr>
					<tr>
						<td><label>Okres rozliczeniowy:</label></td>
						<td><form:select path="amountPeriod">
								<form:option value="YEAR" label="rocznie"></form:option>
								<form:option value="MONTH" label="miesięcznie"></form:option>
								<form:option value="QUARTER" label="kwartalnie"></form:option>
							</form:select></td>
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Zapisz" class="save" /></td>
					</tr>
				<tbody>
			</table>
		</form:form>
	</div>
</body>
</html>