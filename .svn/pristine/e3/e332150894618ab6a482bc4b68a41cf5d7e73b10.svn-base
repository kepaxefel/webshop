<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "com.shop.domains.*" %>

<!DOCTYPE HTML>

<html>
	<head>
		<title>Корзина покупок</title>
		<jsp:include page= "../../fragments/styles.jsp"/>	
	</head>
	
	<body>
		<table align="center" class="main_table">
			<tr class="logo_tr">
				<td colspan="5"><a href="/"><img src="../img/0.jpg"></a></td>  	<!-- логотип/header -->
			</tr>
			<tr class="sec_tr">
				<td rowspan="2" class="sec_td">
					<jsp:include page= "../../fragments/parts.jsp"/>				
				</td>				
				<jsp:include page="../../fragments/topparts.jsp"/>	
				<td td rowspan="2" class="third_td"><br><br><img src="img/korz.png"></img><br><a href="getbuyproducts">Корзина</a><br><br><br><br><br><br> 					
					<jsp:include page= "../../fragments/security.jsp"/>
				</td>
			</tr>
			<tr class="fourth_tr">
				<td colspan="3" class="fourth_td"> <br>
						<h3> Ваши покупки: </h3>
					<c:if test="${buyProducts.isEmpty()}">
						<h3> Ваша корзина пуста </h3>
					</c:if>
				
					<c:if test="${buyProducts != null }">							
						<c:forEach items="${buyProducts}" var="buyProducts">
							${buyProducts.getProductsName()} &nbsp;&nbsp;
							${buyProducts.getCost()} грн.	<br>
						</c:forEach>					
					</c:if><br>					
						--------------------------------- <br>
						&nbsp;&nbsp;&nbsp;&nbsp; Итого: ${sum}  грн. <br><br>
					
						<a href="cleancart"><input type="button" name="/clean" value=" Очистить "></a> 
						<a href="saveorder"><input type="button" name="continue" value=" Оформление "></a>
										
				</td>				
			</tr>			
	</body>
</html>	
