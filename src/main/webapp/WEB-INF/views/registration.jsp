
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


</head>
<body>
	<h2>this is registration page</h2>
	<c:url var="addAction" value="register"></c:url>
	<form:form action="${addAction}" method="post" commandName="form-reg">
		
		

		UserID: <input class="form-control" type="text" name="id">
		<br>
		Name: <input class="form-control" type="text" name="name">
		<br>
		Password: <input class="form-control" type="text" name="password">
		<br>
		
		Contact: <input class="form-control" type="text" name="contact">
		<br>
		<!-- (AFTER ADDING THIS IT GOT STARTING GETTING INTO METHOD-->
		<input type="submit" value="REGISTER">
		<br>

	</form:form>

</body>
</html>