<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Task Management - Login</title>
</head>
<body>
	<h1>
		<strong>Portal Login</strong>
	</h1>

	<c:url value="/login" var="login" />
	<form:form action="" method="post">
		<label>Username: </label>
		<input type="text" name="username" />
		<label>Password: </label>
		<input type="password" name="password" />
		<input type="submit" />
	</form:form>
</body>
</html>