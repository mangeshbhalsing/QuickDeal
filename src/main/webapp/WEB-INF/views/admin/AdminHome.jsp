<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Insert title here</title>
</head>
<body>

	<a href="manage_Categories">Manage Category</a>
	<a href="manage_Products">Manage Products</a>
	<a href="manage_Suppliers">Manage supplier</a>
	<!-- moving to category page -->
	<c:if test="${isUserClickedCategories==true}">
		<jsp:include page="Category.jsp"></jsp:include>
	</c:if>
	
	<c:if test="${isAdminClickedCategories==true}">
		<jsp:include page="Category.jsp"></jsp:include>
	</c:if>

	<c:if test="${isUserClickedProducts==true}">
		<jsp:include page="Product.jsp"></jsp:include>
	</c:if>

<c:if test="${isAdminClickedProducts==true}">
		<jsp:include page="Product.jsp"></jsp:include>
	</c:if>
	
	<c:if test="${isUserClickedSupplier==true}">
		<jsp:include page="Supplier.jsp"></jsp:include>
	</c:if>
	
	<c:if test="${isAdminClickedSuppliers==true}">
		<jsp:include page="Supplier.jsp"></jsp:include>
	</c:if>
	
</body>
</html>