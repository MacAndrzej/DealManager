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
<link type="text/css" rel="stylesheet" href="../css/app.css">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List all orders</title>
<spring:url value="/static/javaScript/jquery-1.12.4.js" var="jqueryJs" />
<spring:url value="/static/css/jquery.dataTables.min.css" var="tableCss" />
<spring:url value="/static/javaScript/jquery.dataTables.min.js"
	var="dataTable" />
<script src="${jqueryJs}"></script>
<script src="${dataTable}"></script>
<link href="${tableCss}" rel="stylesheet" />
</head>
<h3>List of all orders.</h3>
<body>
	<table id="myTable" class="table">
		<thead>
			<tr>
				<th>Lp.</th>
				<th>Nazwa systemu</th>
				<th>Numer umowy</th>
				<th>Od</th>
				<th>Do</th>
				<th>Wpływy</th>
				<th>W skali</th>
				<th>Aktywna</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="listDeals" items="${deals}" varStatus="status">
				<tr>
					<td>${status.count}</td>
					<td>${listDeals.systems.getSystemName()}</td>
					<td>${listDeals.orderNumber}</td>
					<td>${listDeals.fromDate}</td>
					<td>${listDeals.toDate}</td>
					<td>${listDeals.amount} zł</td>
					<td><c:choose>
							<c:when test="${listDeals.amountPeriod=='YEAR'}">na rok</c:when>
							<c:when test="${listDeals.amountPeriod=='MONTH'}">na miesiąc</c:when>
							<c:when test="${listDeals.amountPeriod=='QUARTER'}">na kwartał</c:when>
							<c:otherwise>nie określono</c:otherwise>
						</c:choose></td>
					<td><c:choose>
							<c:when test="${listDeals.active==1}">TAK
					 </c:when>
							<c:otherwise>NIE</c:otherwise>
						</c:choose></td>
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