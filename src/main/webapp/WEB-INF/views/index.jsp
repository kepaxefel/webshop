<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.shop.controllers.*" %>

<!DOCTYPE HTML>

<html>
	<head>
		<title>Главная страница</title>
		<jsp:include page= "../../fragments/styles.jsp"/>	
	</head>
	
	<body> 
		<table align="center" class="main_table">
			<tr class="logo_tr">
				<td colspan="5"><a href="/"><img src="img/0.jpg"></a></td>  	<!-- логотип/header -->
			</tr>
			<tr class="sec_tr">
				<td rowspan="2" class="sec_td">
					<jsp:include page= "../../fragments/parts.jsp"/>				
				</td>								
				<jsp:include page="../../fragments/topparts.jsp"/>	
				<td rowspan="2" class="third_td"><br><br><img src="img/korz.png"></img><br><a href="getbuyproducts">Корзина</a><br><br><br><br><br><br> 					
					<jsp:include page= "../../fragments/security.jsp"/>
				</td>	
			</tr>
			<tr class="fourth_tr">
				<td colspan="3" class="fourth_td"> <br>
					<img src="img/champ.jpg"></img> <br>
				</td>
			</tr>
		</table>
	</body>
</html>	
