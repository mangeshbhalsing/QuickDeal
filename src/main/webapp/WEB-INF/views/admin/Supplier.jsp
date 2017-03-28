<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<title>Category Page</title>

</head>
<body>
${msg}
	<h1>Add a Supplier</h1>
	<%-- <c:url var="addAction" value="/manage_supplier_add"></c:url>
	<form:form action="${addAction}" commandName="supplier"  method="post">
		<table>
			<tr>
				<td><form:label path="id"> <spring:message text="ID" />	</form:label></td>
				<c:choose>
					<c:when test="${ not empty supplier.id} ">
						<td><form:input path="id"  readonly="true" /></td>
					</c:when>
					<c:otherwise>
						<td><form:input path="id" pattern=".{1,20}" required="true"
								title="id cant be empty" /></td>
					</c:otherwise>
				</c:choose>
			<tr>
				<td><form:label path="name">	<spring:message text="Name" /> </form:label></td>
				<td><form:input path="name" required="true" /></td>
			</tr>
			<tr>
				<td><form:label path="description"> <spring:message text="Description"/></form:label></td>
				<td><form:input path="description" required="true" /></td>
			</tr>
			
				
			<tr>
				<td colspan="2"><c:if test="${!empty supplier.name}">
						<input type="submit" value="<spring:message text="Update Supplier"/>" />
					</c:if> <c:if test="${empty supplier.name}">
						<input type="submit" value="<spring:message text="Add Supplier"/>" />
					</c:if></td>
			</tr>
		</table>
	</form:form>
	<br>
	<h3>Supplier List</h3>
	<c:if test="${!empty supplierList}">
		<table class="tg">
			<tr>
				<th width="80">Supplier ID</th>
				<th width="120">Supplier Name</th>
				<th width="120">Supplier Description</th>
				<th width="60">Edit</th>
				<th width="60">Delete</th>
			</tr>
			<c:forEach items="${supplierList}" var="supplier">
				<tr>
					<td>${supplier.id}</td>
					<td>${supplier.name}</td>
					<td>${supplier.description}</td>
					<td><a href="<c:url value='/manage_category_edit/${supplier.id}' />">Edit</a></td>
					
					<td><a href="<c:url value='/manage_category_remove/${supplier.id}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if> --%>
</body>
</html>






