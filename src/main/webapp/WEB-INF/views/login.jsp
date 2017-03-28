<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
<h2>this is login page</h2>
 <center> ${msg}</center>
<form action="validation">

		USER ID:<input type="text" name="userID"> <br>
		 PASSWORD:<input type="password" name="password"> <br>
			 <input type="submit" value="login"> 
			
	</form>

</body>
</html>