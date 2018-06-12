<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>404 Error Page</title>
</head>
<body>
	<h2>400 - Bad Request.</h2>
	<h5>${exc.getMessage()}</h5>
</body>
</html>