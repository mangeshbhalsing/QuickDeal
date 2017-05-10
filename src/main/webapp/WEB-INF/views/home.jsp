<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- -------------------------------------------------Stylesheets and JS------------------------------ -->
<script src="resources/core/js/jquery.js"></script>

<script src="resources/core/js/logreg.js"></script>

<jsp:include page="linking.jsp"></jsp:include>



<link href="resources/core/css/logreg.css" rel="stylesheet" />



</head>


<body>

	<jsp:include page="categorymenu.jsp"></jsp:include>
	<h2 class="msgs">
	<%-- <center>${msg}</center> --%>
	<center>${errorMessage}</center>
	<center>${loginMessage}</center>
	<center>${successMessage}</center>
</h2>


  <c:if test="${isUserClickContactUs==true}">
		<jsp:include page="contactUs.jsp"></jsp:include>
	</c:if>

	<c:if test="${thisIsProductPage==true}">
		<jsp:include page="productDetails.jsp"></jsp:include>
	</c:if>



	<center>
		<h2>${msg}</h2>
	</center>

	<c:if test="${thisIsHome==true}">
		<jsp:include page="carousel.jsp"></jsp:include>
		<jsp:include page="productList.jsp"></jsp:include>
	</c:if>


	<c:if test="${addaddress==true}">
		<jsp:include page="address.jsp"></jsp:include>
	</c:if>

	<c:if test="${checkout==true}">
		<jsp:include page="checkout.jsp"></jsp:include>
	</c:if>


	<c:if test="${isUserClickedLogin==true}">
		<jsp:include page="login.jsp"></jsp:include>

	</c:if>

	<c:if test="${isUserClickRegister==true}">
		<jsp:include page="registration.jsp"></jsp:include>
	</c:if>


	<c:if test="${displayCart==true}">
		<jsp:include page="cart.jsp"></jsp:include>
	</c:if>


	<%-- <c:if test="${displayCart==true}">
		<jsp:include page="myCart.jsp"></jsp:include>
	</c:if>
 --%>



	<c:if test="${registred==true}">
		<jsp:include page="login.jsp"></jsp:include>
	</c:if>

	<c:if test="${isUserClickedLogin==true}">
		<jsp:include page="carousel.jsp"></jsp:include>
		<jsp:include page="productList.jsp"></jsp:include>
	</c:if>
</body>
</html>
<jsp:include page="footer.jsp"></jsp:include>