<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript">
	$(document).ready(function() {
		$('#list').click(function(event) {
			event.preventDefault();
			$('#products .item').addClass('list-group-item');
		});
		$('#grid').click(function(event) {
			event.preventDefault();
			$('#products .item').removeClass('list-group-item');
			$('#products .item').addClass('grid-group-item');
		});
	});
	
</script>



<spring:url value="/resources/images/" var="imag"></spring:url>
 




</head>
<body>


<div class="container">

<c:forEach items="${productList}" var="product">


   
        <div class="item  col-xs-4 col-lg-4">
            <div class="thumbnail">
            <a href='<c:url value="proDetails/${product.id}"></c:url>'>
                <img class="productDetails.jsp" src="${imag}/${product.id}.jpg" alt="" />
                </a>
                <div class="caption">
                    <h4 class="group inner list-group-item-heading">
                       ${product.name}</h4>
                    <p class="group inner list-group-item-text">
                        ${product.description}</p>
                    <div class="row">
                        <div class="col-xs-12 col-md-6 col-sm-6">
                            <p class="lead">
                                ${product.price}</p>
                        </div>
                        <div class="col-xs-12 col-md-6 col-sm-6">
                         <a class="btn btn-success" href='<c:url value="addToCart/${product.id}"></c:url>'>Add to Cart</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    
</c:forEach>
</div>
</body>
</html>