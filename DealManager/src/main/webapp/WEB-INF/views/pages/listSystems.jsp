<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
	response.setCharacterEncoding("UTF-8");
	request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All systems</title>
<spring:url value="/static/javaScript/jquery-1.12.4.js" var="jqueryJs" />
<spring:url value="/static/css/jquery.dataTables.min.css" var="tableCss" />
<spring:url value="/static/javaScript/jquery.dataTables.min.js"
	var="dataTable" />
<script src="${jqueryJs}"></script>
<script src="${dataTable}"></script>
<link href="${tableCss}" rel="stylesheet" />
</head>
<body>
<h2>Lista systemów.</h2>
	<table id="myTable">
		<thead>
			<tr>
				<th>Lp.</th>
				<th>Nazwa systemu</th>
				<th>Opis systemu</th>
				<th>Opis technologii</th>
				<th>Właściciel systemu</th>
				<th>Operacje</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="listSystems" items="${systems}" varStatus="status">
			<c:url var="updateLink" value="/system/showFormForUpdateSystem">
					<c:param name="systemId" value="${listSystems.id}"></c:param>
				</c:url>
				<tr>
					<td>${status.count}</td>
					<td>${listSystems.systemName}</td>
					<td>${listSystems.descriptionOfSystem}</td>
					<td>${listSystems.descriptionOfTechnology}</td>
					<td>${listSystems.systemOwner}</td>
					<td><a href="${updateLink}">Edytuj</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<script type="text/javascript">
		$(document).ready(function() {
			$('#myTable').dataTable();
		});
	</script>
</body>
</html>