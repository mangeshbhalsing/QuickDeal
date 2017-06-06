

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Supplier Page</title>

<jsp:include page="../linking.jsp"></jsp:include><!--   means it is out of its current directory -->
<style type="text/css">
.panel-default>.panel-heading {
    color: #f7f4f4;
    background-color: #3c48a5;
    border-color: #118ef9;
}

</style>

</head>
<body>
<h3 style="background-color:#83BAC9">
	<center>${msg}</center>
	<br>
	<center> ${message}</center>
</h3>
	<br>
	<div class="container">

		<div class="panel panel-default col-sm-8 col-sm-offset-2">

			<div class="row panel-heading">
				<h3>
				<center>	<span class="glyphicon glyphicon-dashboard"></span> <b>Supplier
						Details</b></center>
				</h3>
			</div>

			<div class="panel-body">
				<c:url var="addAction" value="/add_Supplier_Value"></c:url>

				<form:form action="${addAction}" commandName="supplier"
					method="post">

					<div class="row">
						<div class="col-sm-3">
							<form:label path="">
								<spring:message text="Supplier Id" />
							</form:label>
						</div>
						<div class="col-sm-9">
							<form:input path="id" class="form-control" pattern=".{5,20}"
								required="true" title="id should contains 5 to 20 characters" />
						</div>
					</div>
					<br>
					<div class="row">
						<div class="col-sm-3">
							<form:label path="">Supplier Name</form:label>
						</div>
						<div class="col-sm-9">
							<form:input path="name" cssClass="form-control" required="" />
							<span><form:errors path="name" cssClass="error" /></span>
						</div>
					</div>
					<br>
					<div class="row">
						<div class="col-sm-3">
							<form:label path="">Address</form:label>
						</div>
						<div class="col-sm-9">
							<form:input path="address" cssClass="form-control" required="" />
							<span><form:errors path="address" cssClass="error" /></span>
						</div>
					</div>
					<br>
					<input type="submit" name=action value="save"
						class="btn btn-primary" />

					<!-- <input type="Submit" name=action value="renew"
						class="btn btn-primary" /> -->

				</form:form>
			</div>
		</div>
		
		
		
		<table class="table table-striped">
			<thead>
				<tr>
					<td>ID</td>
					<td>Name</td>
					<td>Address</td>
					<td>Action</td>

				</tr>
			</thead>

			<c:forEach var="supplier" items="${supplierList}">
				<tr>
					<td>${supplier.id}</td>
					<td>${supplier.name}</td>
					<td>${supplier.address}</td>


					<td><a
						href="<c:url value= '/manage_Supplier_edit/${supplier.id}'/>"
						class="btn btn-primary">Edit <span
							class="glyphicon glyphicon-edit"></span></a> <a
						href="<c:url value='/manage_Supplier_delete/${supplier.id}'/>"
						class="btn btn-primary">Delete <span
							class="glyphicon glyphicon-trash"></span></a></td>

				</tr>

			</c:forEach>


		</table>
	</div>
	<br>
	<br>

</body>

</html>