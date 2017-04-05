<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
	<h2>this is login page</h2>
	<center>${msg}</center>
	<center>${mesg}</center>
	<%--  <form action="validation">

		USER ID:<input type="text" name="username"> <br> PASSWORD:<input
			type="password" name="password"> <br> <input
			type="submit" value="login">

	</form> 
 --%>

	<c:url var="addAction" value="j_spring_security_check"></c:url>
	<form action="${addAction}" method="post">

		UserID: <input class="form-control" type="text" name="username"><br>
		<br> Password: <input class="form-control" type="text"
			name="password"> <br> <input type="hidden"
			name="${_csrf.parameterName}" value="${_csrf.token}" />
		<!-- (AFTER ADDING THIS IT GOT STARTING GETTING INTO METHOD-->
		<input type="submit" value="LOGIN"> <br>

	</form> 


</body>
</html>
