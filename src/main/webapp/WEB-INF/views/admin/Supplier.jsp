

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

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
	${msg}
	<br> ${message}

	<br>
	<div class="container">

		<div class="panel panel-default col-sm-8 col-sm-offset-2">

			<div class="row panel-heading">
				<h3>
				<center>	<span class="glyphicon glyphicon-dashboard"></span> <b>Supplier Details</b></center>
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
							<form:input path="id" class="form-control" pattern=".{3,20}"
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












<%-- <table>
			<tr>
				<td><form:label path="id"> <spring:message text="id" />	</form:label></td>
				
						<td><form:input path="id"  pattern=".{5,20}" required="true" 
						
						title="id should contains 5 to 20 characters" /></td>
								
			</tr>					
			<tr>
			
				<td><form:label path="name" value="name">	<spring:message text="Name" /> </form:label></td>
				<td><form:input path="name" required="true" /></td>
			
			</tr>
			
			<tr>
			
				<td><form:label path="address" value="address"> <spring:message text="Address"/></form:label></td>
				<td><form:input path="address" required="true" /></td>
				
			</tr>
			
			<tr>
				<td colspan="2">
						<input type="submit" name=action value="save" />
					
						<input type="submit" name=action value="renew" />
				</td>
			</tr>
		</table>
	</form:form>
	<hr> 
	
	<h3>Supplier List</h3>
 	<c:if test="${!empty supplierList}"> 
	<table   class="table table-striped" >
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
				
				<td><a href="<c:url value= '/manage_Supplier_edit/${supplier.id}'/>">Edit</a></td>
				
				<td> <a href="<c:url value='/manage_Supplier_delete/${supplier.id}'/>">Delete</a></td>
			</tr>

		</c:forEach>

	</table>
	</c:if>
</body>
</html> --%>