<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<spring:url value="/static/javaScript/jquery-1.12.4.js" var="jqueryJs" />
<spring:url value="/static/css/jquery.dataTables.min.css" var="tableCss" />
<spring:url value="/static/javaScript/jquery.dataTables.min.js"
	var="dataTable" />
<script src="${jqueryJs}"></script>
<script src="${dataTable}"></script>
<link href="${tableCss}" rel="stylesheet" />
</head>
<body>
<h2>List of all Systems.</h2>
	<table id="myTable">
		<thead>
			<tr>
				<th>No.</th>
				<th>System_name</th>
				<th>Description_of_system</th>
				<th>Description_of_technology</th>
				<th>System_owner</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="listSystems" items="${systems}" varStatus="status">
				<tr>
					<td>${status.count}</td>
					<td>${listSystems.systemName}</td>
					<td>${listSystems.descriptionOfSystem}</td>
					<td>${listSystems.descriptionOfTechnology}</td>
					<td>${listSystems.systemOwner}</td>
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