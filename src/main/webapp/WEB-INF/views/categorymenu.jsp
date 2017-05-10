<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<body>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="refresh">QuickDeals</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">

					<c:forEach items="${categoryList}" var="category">

						<li><a href="">${category.name}</a></li>
					</c:forEach>




				</ul>
				<ul class="nav navbar-nav navbar-right">
					<c:if test="${isAdmin==false}">
					
					
					
					<li>	<a href="myCart" class="glyphicon glyphicon-shopping-cart" style="font-size: 35px;"><!-- <img align="right"
							src="resources/images/cart.png" style="width: 50px;"> --></a></li>

					</c:if>
					
					<c:if test="${empty loginMessage}">
						<li><a href="login"><span
								class="glyphicon glyphicon-user"></span>My Account</a></li>
					</c:if>
					<c:if test="${not empty loginMessage}">
						<li><a href="j_spring_security_Logout"><span
								class="glyphicon glyphicon-log-out" a></span> Logout</a></li>
					</c:if>

				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>



</body>
</html>
