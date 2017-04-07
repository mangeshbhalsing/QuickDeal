<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- -------------------------------------------------Stylesheets and JS------------------------------ -->
<script src="resources/core/js/jquery.js"></script>
<script src="resources/core/js/bootstrap.js"></script>
<script src="resources/core/js/logreg.js"></script>

<link href="resources/core/css/bootstrap.css" rel="stylesheet" />
 <link href="resources/core/css/logreg.css" rel="stylesheet" />
 <link href="resources/core/css/navbar.css" rel="stylesheet" />


</head>



<body>
<jsp:include page="categorymenu.jsp"></jsp:include>


	<c:if test="${thisIsHome==true}">
		<jsp:include page="carousel.jsp"></jsp:include>
	</c:if>

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

	<c:if test="${registred==true}">
		<jsp:include page="login.jsp"></jsp:include>
	</c:if>


<!--  -->

	


	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>