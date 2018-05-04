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
	<h3>List of all active orders.</h3>
	<table id="myTable">
		<thead>
			<tr>
				<th>No.</th>
				<th>Order_number</th>
				<th>From_date</th>
				<th>To_date</th>
				<th>Amount</th>
				<th>Amount_period</th>
				<th>Operations</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="listDeals" items="${deals}" varStatus="status">
				<c:url var="updateLink" value="/deal/showFormForUpdateDeal">
					<c:param name="dealId" value="${listDeals.id}"></c:param>
				</c:url>
				<c:url var="disableLink" value="/deal/disableDeal">
					<c:param name="dealId" value="${listDeals.id}"></c:param>
				</c:url>
				<tr>
					<td>${status.count}</td>
					<td>${listDeals.orderNumber}</td>
					<td>${listDeals.fromDate}</td>
					<td>${listDeals.toDate}</td>
					<td>${listDeals.amount}</td>
					<td>${listDeals.amountPeriod}</td>
					<td><a href="${updateLink}">Edit</a> | <a
						href="${disableLink}">Disable</a></td>
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