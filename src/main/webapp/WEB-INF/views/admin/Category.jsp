<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<title>Category Page</title>

<jsp:include page="../linking.jsp"></jsp:include><!--   means it is out of its current directory -->

</head>
<body>
${msg}
	<br> ${message }
	<br>
	<div class="container">

		<div class="panel panel-default col-sm-8 col-sm-offset-2">

			<div class="row panel-heading">
				<h3>
					<span class="glyphicon glyphicon-dashboard"></span> <b>CaTeGoRy
						DeTaILs</b>
				</h3>
			</div>

			<div class="panel-body">
				<c:url var="addAction" value="/add_Category_Value"></c:url>

				<form:form action="${addAction}" commandName="category"
					method="post">

					<div class="row">
						<div class="col-sm-3">
							<form:label path="">
								<spring:message text="Category Id" />
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
							<form:label path="">Category Name</form:label>
						</div>
						<div class="col-sm-9">
							<form:input path="name" cssClass="form-control" required="" />
							<span><form:errors path="name" cssClass="error" /></span>
						</div>
					</div>
					<br>
					<div class="row">
						<div class="col-sm-3">
							<form:label path="">Description</form:label>
						</div>
						<div class="col-sm-9">
							<form:input path="description" cssClass="form-control"
								required="" />
							<span><form:errors path="description" cssClass="error" /></span>
						</div>
					</div>
					<br>
					<input type="submit" name=action value="save"
						class="btn btn-primary" />

					<input type="Submit" name=action value="renew"
						class="btn btn-primary" />

				</form:form>
			</div>
		</div>
		<br>
		<br>
		<c:if test="${!empty categoryList}">
			<table class="table table-striped">
				<thead>
					<tr>
						<td>ID</td>
						<td>Name</td>
						<td>Descriptions</td>
						<td>Action</td>

					</tr>
				</thead>

				<c:forEach var="category" items="${categoryList}">
					<tr>
						<td>${category.id}</td>
						<td>${category.name}</td>
						<td>${category.description}</td>
						<td><a
							href="<c:url value= '/manage_category_edit/${category.id}'/>"
							class="btn btn-primary">Edit <span
								class="glyphicon glyphicon-edit"></span></a> <a
							href="<c:url value='/manage_category_delete/${category.id}'/>"
							class="btn btn-primary">Delete <span
								class="glyphicon glyphicon-trash"></span></a></td>
					</tr>

				</c:forEach>

			</table>
		</c:if>
		</div>
</body>
</html>