<%@ page isELIgnored="false"%>

<nav class="nav">
	<a href="${pageContext.request.contextPath}/"></a>
	<ul id="menu">
		<li><a href="${pageContext.request.contextPath}/order/list">ListAllOrders</a></li>
		<li><a href="${pageContext.request.contextPath}/order/listActive">ListActiveOrders</a></li>
		<li><a href="${pageContext.request.contextPath}/order/showImportOrdersForm">ImportOrders</a></li>
		<li><a href="${pageContext.request.contextPath}/order/showExportOrdersForm">ExportOrders</a></li>
		<li><a href="${pageContext.request.contextPath}/system/list">ListSystems</a></li>
		<li><a href="${pageContext.request.contextPath}/">About</a></li>
	</ul>
</nav>