<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<spring:url value="/resources/images/" var="imag"></spring:url>

<script>
$(document).ready(function(){
    //-- Click on detail
    $("ul.menu-items > li").on("click",function(){
        $("ul.menu-items > li").removeClass("active");
        $(this).addClass("active");
    })

    $(".attr,.attr2").on("click",function(){
        var clase = $(this).attr("class");

        $("." + clase).removeClass("active");
        $(this).addClass("active");
    })

    //-- Click on QUANTITY
    $(".btn-minus").on("click",function(){
        var now = $(".section > div > input").val();
        if ($.isNumeric(now)){
            if (parseInt(now) -1 > 0){ now--;}
            $(".section > div > input").val(now);
        }else{
            $(".section > div > input").val("1");
        }
    })            
    $(".btn-plus").on("click",function(){
        var now = $(".section > div > input").val();
        if ($.isNumeric(now)){
            $(".section > div > input").val(parseInt(now)+1);
        }else{
            $(".section > div > input").val("1");
        }
    })                        
}) 
</script>

</head>
<body>



	<!-- **************************************************************************************************************************************** -->

	<div class="container">
		<div class="row">
			<div class="col-xs-4 item-photo">
				<img style="max-width: 100%;"
					src="${imag}/${product.id}.jpg" />
			</div>
			<div class="col-xs-5" style="border: 0px solid gray">
				<!-- Datos del vendedor y titulo del producto -->
				<h3>S${product.name}</h3>
				<h5 style="color: #337ab7">
					vendido por <a href="#">Samsung</a> · <small style="color: #337ab7">(5054
						ventas)</small>
				</h5>

				<!-- Precios -->
				<h6 class="title-price">
					<small> ${product.description}</small>
				</h6>
				<h3 style="margin-top: 0px;">${product.price}</h3>

				<!-- Detalles especificos del producto -->
				<div class="section">
					<h6 class="title-attr" style="margin-top: 15px;">
					</h6>
					<div>
						<div class="attr" style="width: 25px; background: #5a5a5a;"></div>
						<div class="attr" style="width: 25px; background: white;"></div>
					</div>
				</div>
				<div class="section" style="padding-bottom: 20px;">
					<h6 class="title-attr">
						<small>QUANTITY</small>
					</h6>
					<div>
						<div class="btn-minus">
							<span class="glyphicon glyphicon-minus"></span>
						</div>
						<input value="1" />
						<div class="btn-plus">
							<span class="glyphicon glyphicon-plus"></span>
						</div>
					</div>
				</div>

				<!-- Botones de compra -->
				
					
					 <div class="col-xs-12 col-md-6 col-sm-6">
                         <a class="btn btn-success" href='<c:url value="addToCart/${product.id}"></c:url>'>Add to Cart</a>
                       
                     <a class="btn btn-success" href='<c:url value="/"></c:url>'>BACK</a>
                        </div>
					
					
				</div>
			</div>

			<div class="col-xs-9">
				<div style="width: 100%; border-top: 1px solid silver">
					<p style="padding: 15px;">
						<small> </small>
					</p>
				</div>
			</div>
		</div>
	</div>
</body>
</html>