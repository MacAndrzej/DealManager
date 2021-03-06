<%@page contentType="text/html; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	response.setCharacterEncoding("UTF-8");
	request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Active orders</title>
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
	<input type="button" value="Add order"
		onclick="window.location.href='showFormForAddOrder'; return false;"
		class="add-button" />
	<table id="myTable">
		<thead>
			<tr>
				<th>No.</th>
				<th>System name</th>
				<th>Order number</th>
				<th>From</th>
				<th>To</th>
				<th>Amount</th>
				<th>Amount per period</th>
				<th>Operations</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="listDeals" items="${deals}" varStatus="status">
				<c:url var="updateLink" value="/order/showFormForUpdateOrder">
					<c:param name="dealId" value="${listDeals.id}"></c:param>
				</c:url>
				<c:url var="disableLink" value="/order/disableOrder">
					<c:param name="dealId" value="${listDeals.id}"></c:param>
				</c:url>
				<tr>
					<td>${status.count}</td>
					<td>${listDeals.systems.getSystemName()}</td>
					<td>${listDeals.orderNumber}</td>
					<td><fmt:formatDate value="${listDeals.fromDate}" pattern="yyyy-MM-dd"/></td>
					<td><fmt:formatDate value="${listDeals.toDate}"  pattern="yyyy-MM-dd"/></td>
					<td>${listDeals.amount} zł</td>
					<td><c:choose>
							<c:when test="${listDeals.amountPeriod=='YEAR'}">na rok</c:when>
							<c:when test="${listDeals.amountPeriod=='MONTH'}">na miesiąc</c:when>
							<c:when test="${listDeals.amountPeriod=='QUARTER'}">na kwartał</c:when>
							<c:otherwise>nie określono</c:otherwise>
						</c:choose></td>
					<td><a href="${updateLink}">Edit</a> | <a
						href="${disableLink}">Deactive</a></td>
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