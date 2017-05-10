<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
  
<head>
<title>Product Page</title>

<jsp:include page="../linking.jsp"></jsp:include><!--   means it is out of its current directory -->

<spring:url value="/resources/images/" var="imag"></spring:url>
<style type="text/css">
.panel-default>.panel-heading {
    color: #f7f4f4;
    background-color: #3c48a5;
    border-color: #118ef9;
}

</style>


</head>
<body>
${msg}<br>
${message}<br>

<div class="container">

	<div class="panel panel-default col-sm-8 col-sm-offset-2">

		<div class="row panel-heading"><h3><span class="glyphicon glyphicon-dashboard"></span>  <b>ProDuct DeTaiLs</b></h3></div>

		<div class="panel-body">
		
		 <c:url var="addAction" value="/add_Product_Value?${_csrf.parameterName}=${_csrf.token}"></c:url> 
		  
			<form:form method="post" action="${addAction}"  modelAttribute="product" enctype="multipart/form-data" >

				
					<div class="row">
						<div class="col-sm-3">
							<form:label path="">
								<spring:message text="Product Id" />
							</form:label>
						</div>
						<div class="col-sm-9">
							<form:input path="id"  class="form-control" />
							
						</div>
					</div>
				
				<br>
				<div class="row">
					<div class="col-sm-3">
						<form:label path="">Product Name</form:label>
					</div>
					<div class="col-sm-9">
						<form:input path="name" cssClass="form-control" required="" />
						<span><form:errors path="name" cssClass="error" /></span>
					</div>
				</div>
				<br>
				<div class="row">
					<div class="col-sm-3">
						<form:label path="description">Product Description</form:label>
					</div>
					<div class="col-sm-9">
						<form:input path="description" class="form-control" />
						<span><form:errors path="description" cssClass="error" /></span>
					</div>
				</div>
				<br>
				<div class="row">
					<div class="col-sm-3">
						<form:label path="">Product Suppliers</form:label>
					</div>
					<div class="col-sm-9">
						<form:select path="supplier_id" cssClass="form-control">

							<c:forEach items="${supplierList}" var="supplier">

								<form:option value="${supplier.id }">${supplier.id}</form:option>

							</c:forEach>

						</form:select>
					</div>
				</div>
				
				<br>

				
				<div class="row">
					<div class="col-sm-3">
						<form:label path="">Product Category</form:label>
					</div>
					<div class="col-sm-9">
						<form:select path="category_id" cssClass="form-control">

							<c:forEach items="${categoryList}" var="category">

								<form:option value="${category.id }">${category.id}</form:option>

							</c:forEach>

						</form:select>
					</div>
				</div>
				<br>
				<div class="row">
					<div class="col-sm-3">
						<form:label path="">Product Price</form:label>
					</div>
					<div class="col-sm-9">
						<form:input path="price" class="form-control" />
						<span><form:errors path="price" cssClass="error" /></span>
					</div>
				</div>
				<br>
				<div class="row">
					<div class="col-sm-3">
						<form:label path="file">
							<spring:message text="Choose Image" />
						</form:label>
					</div>
					<div class="col-sm-9">
						<form:input path="file" type="file" cssClass="form-control"
							required="required" />
					</div>
				</div>
				<br>
					
					
					<input type="submit" name=action value="save" class="btn btn-primary"/>
					
					 <input type="Submit" name=action value="renew" class="btn btn-primary"/> 
					 
			</form:form>
		</div>
	</div>
	
	
	
	<table class="table table-striped">
		<tr>
			<th>ID</th>
			<th>Product Name</th>
			<th>Category</th>
			<th>Description</th>
			<th>Supplier</th>
			<th>Price</th>
			<th>Image</th>
			<th>&#160</th>
		</tr>

		<c:forEach items="${productList}" var="product">
			<tr>
				<td>${product.id }</td>
				<td>${product.name }</td>
				<td>${product.category_id }</td>
				<td>${product.description}</td>
				<td>${product.supplier_id }</td>
				<td>${product.price }</td>
				<td><img
					src="${imag}/${product.id}.jpg"
					height="150" width="150" /></td>

				<td><a href="<c:url value= '/manage_Product_edit/${product.id}'/>"
					class="btn btn-primary">Edit  <span class= "glyphicon glyphicon-edit"></span></a> <a
					href="<c:url value='/manage_Product_delete/${product.id}'/>" class="btn btn-primary">Delete <span class= "glyphicon glyphicon-trash"></span></a></td>
			</tr>
		</c:forEach>
	</table>
</div>
<br>
<br>

</body> 

</html>







<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
  
<head>
<title>Product Page</title>

<jsp:include page="../Linking.jsp"></jsp:include><!--   means it is out of its current directory -->

<spring:url value="/resources/images/" var="imag"></spring:url>

</head>
<body>
${msg}<br>
${message}<br>
	<h1>Add a Product</h1>
	<c:url var="addAction" value="add_Product_Value"></c:url>
	<form:form  action="${addAction}"  commandName="product" method="post">
		<table>
			<tr>
				<td><form:label path="id"> <spring:message text="id" />	</form:label></td>
				
						<td><form:input path="id" pattern=".{5,20}" required="true"
								title="id should contains 5 to 20 characters" /></td>
			</tr>					
			<tr>
			
				<td><form:label path="name">	<spring:message text="Name" /> </form:label></td>
				
				<td><form:input path="name" required="true" /></td>
			
			</tr>
			
			<tr>
			
				<td><form:label path="price">	<spring:message text="Price" /> </form:label></td>
				
				<td><form:input path="price" required="true" /></td>
			
			</tr>
			
			
			<tr>
			
				<td><form:label path="description"> <spring:message text="Description"/></form:label></td>
		
				<td><form:input path="description" required="true" /></td>
			</tr>
			
			<tr>
			
				<td><form:label path="category_id"> <spring:message text="Category_id"/></form:label></td>
		
				<td><form:input path="category_id" required="true" /></td>
			</tr>
			
			<tr>
			
				<td><form:label path="supplier_id"> <spring:message text="Supplier_id"/></form:label></td>
		
				<td><form:input path="supplier_id" required="true" /></td>
			</tr>
			
			<tr>
			
				<td><form:label path="file"> <spring:message text="Images"/></form:label></td>
		
				<td><form:input type="file" path="file"  required="true"  /></td>
				
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
	
	<h3>Product List</h3>
	<c:if test="${!empty productList}">
	<table   class="table table-striped" >
		<thead>
			<tr>
				<td>ID</td>
				<td>Name</td>
				<td>Price</td>
				<td>Descriptions</td>
				<td>Images<td>
				<td>Category_id</td>
				<td>Supplier_id</td>
				<td>Action</td>

			</tr>
		</thead>

		<c:forEach var="product" items="${productList}">
			<tr>
				<td>${product.id}</td>
				<td>${product.name}</td>
				<td>${product.price}</td>
				<td>${product.description}</td>
				<td>
				<img
					
					src="${imag}/${product.id}.jpg" height ="50" width="10"/>
				
				
				</td>
				<td>${product.category_id}</td>
				<td>${product.supplier_id}</td>
				
				<td><a href="<c:url value= '/manage_Product_edit/${product.id}'/>">Edit</a></td>
				
				<td> <a href="<c:url value='/manage_Product_delete/${product.id}'/>">Delete</a></td>
			</tr>

		</c:forEach>

	</table>
	</c:if>
</body> 

</html> 

 --%>