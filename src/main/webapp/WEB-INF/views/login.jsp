<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
	<%-- <h2>this is login page</h2>
	<center>${msg}</center>
	<center>${mesg}</center> --%>
	<%--  <form action="validation">

		USER ID:<input type="text" name="username"> <br> PASSWORD:<input
			type="password" name="password"> <br> <input
			type="submit" value="login">

	</form> 
 --%>

	<%-- <c:url var="addAction" value="j_spring_security_check"></c:url>
	<form action="${addAction}" method="post">

		UserID: <input class="form-control" type="text" name="username"><br>
		<br> Password: <input class="form-control" type="text"
			name="password"> <br> <input type="hidden"
			name="${_csrf.parameterName}" value="${_csrf.token}" />
		<!-- (AFTER ADDING THIS IT GOT STARTING GETTING INTO METHOD-->
		<input type="submit" value="LOGIN"> <br>

	</form> 
	 --%>
	<div class="container">
    	<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div class="panel panel-login">
					<div class="panel-heading">
						<div class="row">
							<div class="col-xs-6">
								<a href="#" class="active" id="login-form-link">Login</a>
							</div>
							<div class="col-xs-6">
								<a href="" id="register-form-link">Register</a>
							</div>
						</div>
						<hr>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-lg-12">
							<c:url var="addAction" value="j_spring_security_check"></c:url>
								<form id="login-form" action="${addAction}" method="post" role="form" style="display: block;">
									<div class="form-group">
										<input type="text" name="username" id="username" tabindex="1" class="form-control" placeholder="Username" value="" required>
									</div>
									<div class="form-group">
										<input type="password" name="password" id="password" tabindex="2" class="form-control" placeholder="Password" required>
									</div>
									<div class="form-group text-center">
										<input type="checkbox" tabindex="3" class="" name="remember" id="remember">
										<label for="remember"> Remember Me</label>
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-sm-6 col-sm-offset-3">
												<input type="submit" name="login-submit" id="login-submit" tabindex="4" class="form-control btn btn-login" value="Log In">
											</div>
										</div>
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-lg-12">
												<div class="text-center">
													<a href="http://phpoll.com/recover" tabindex="5" class="forgot-password">Forgot Password?</a>
												</div>
											</div>
										</div>
									</div>
								</form>
								<c:url var="addAction" value="register"></c:url>
	 									<%-- <form:form action="${addAction}" method="post" commandName="form-reg"> --%>
								<form id="register-form" action="${addAction}" method="post" role="form" style="display: none;">
									<div class="form-group">
										<input type="text" name="id" id="username" tabindex="1" class="form-control" placeholder="userID" value="">
									</div>
									<div class="form-group">
										<input type="name" name="name" id="name" tabindex="1" class="form-control" placeholder="Name" value="">
									</div>
									<div class="form-group">
										<input type="password" name="password" id="password" tabindex="2" class="form-control" placeholder="Password">
									</div>
									<div class="form-group">
										<input type="text" name="contact" id="contact" tabindex="2" class="form-control" placeholder="Contact">
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-sm-6 col-sm-offset-3">
												<input type="submit" name="register-submit" id="register-submit" tabindex="4" class="form-control btn btn-register" value="Register Now">
											</div>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>
