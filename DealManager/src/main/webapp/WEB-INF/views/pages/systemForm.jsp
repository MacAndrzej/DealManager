<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%
	response.setCharacterEncoding("UTF-8");
	request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Aktualizuj dane systemu</title>

<link type="text/css" rel="stylesheet" href="/css/inputFormDetails.css">

</head>
<body>
	<div id="container">
		<h2>Popraw dane systemu:</h2>
		<form:form action="saveSystem" modelAttribute="system" method="POST">
			<form:hidden path="id" />

			<table>
				<tbody>
					<tr>
						<td><label>Nazwa systemu:</label></td>
						<td><form:input path="systemName" /> <form:errors path="systemName"
								class="errorInputValidation" /></td>
					</tr>
					<tr>
						<td><label>Opis systemu:</label></td>
						<td><form:input path="descriptionOfSystem" /> <form:errors path="descriptionOfSystem"
								class="errorInputValidation" /></td>
					</tr>
					<tr>
						<td><label>Opis technologii:</label></td>
						<td><form:input path="descriptionOfTechnology" /> <form:errors path="descriptionOfTechnology"
								class="errorInputValidation" /></td>
					</tr>
					<tr>
						<td><label>Właściciel systemu:</label></td>
						<td><form:input path="systemOwner" /> <form:errors path="systemOwner"
								class="errorInputValidation" /></td>
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