<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
				<th>Id</th>
				<th>Deal_number</th>
				<th>Start_date</th>
				<th>Finish_date</th>
				<th>Sum_of_deal</th>
				<th>Settlement_period</th>
				<th>Active</th>
			</tr>
		</thead>
		<c:forEach var="listDeals" items="${deals}" varStatus="status">
			<tr>
				<td>${listDeals.id}</td>
				<td>${listDeals.dealNumber}</td>
				<td>${listDeals.startDate}</td>
				<td>${listDeals.finishDate}</td>
				<td>${listDeals.sumOfDeal}</td>
				<td>${listDeals.settlementPeriod}</td>
				<td>${listDeals.active}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>