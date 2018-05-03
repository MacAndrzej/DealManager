<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>No.</th>
				<th>System_name</th>
				<th>Description_of_system</th>
				<th>Description_of_technology</th>
				<th>System_owner</th>
			</tr>
		</thead>
		<c:forEach var="listSystems" items="${systems}" varStatus="status">
			<tr>
				<td>${status.count}</td>
				<td>${listSystems.systemName}</td>
				<td>${listSystems.descriptionOfSystem}</td>
				<td>${listSystems.descriptionOfTechnology}</td>
				<td>${listSystems.systemOwner}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>