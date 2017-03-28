<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

</head>
<body>
<body>
	<jsp:include page="categorymenu.jsp"></jsp:include>



	<jsp:include page="carousel.jsp"></jsp:include>

	<h2>${msg}</h2>

	${loginMessage}
	<c:if test="${isAdmin==true}">
		<jsp:include page="admin/AdminHome.jsp"></jsp:include>
		
	</c:if>

	<c:if test="${isUserClickedLogin==true}">
		<jsp:include page="login.jsp"></jsp:include>

	</c:if>
	<c:if test="${isUserClickRegister==true}">
		<jsp:include page="registration.jsp"></jsp:include>
	</c:if>



	
	
	</div>





	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>