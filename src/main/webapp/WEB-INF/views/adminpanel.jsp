<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page import = "java.util.ArrayList" %>
<%@ page import = "com.shop.controllers.*" %>
<%@ page import = "com.shop.managers.*" %>
<%@ page import = "com.shop.domains.*" %>

<!DOCTYPE HTML>

<html>
	<head>
		<title>Добавление товаров</title>
		<jsp:include page= "../../fragments/styles.jsp"/>		
	</head>
	
	<body> 
		<table align="center" class="main_table">
			<tr class="logo_tr">
				<td colspan="5"><a href="/"><img src="img/0.jpg"></a></td>  	<!-- логотип/header -->
			</tr>
			<tr class="sec_tr">
				<td rowspan="2" class="sec_td" valign="top"><br>
					<ul>
						<li><a href="adminpanel/getorders">Cписок заказов</a></li>
						<li><a href="adminpanel/getusers">Cписок пользователей</a></li>
						<li><a href="adminpanel/getproducts">Список товаров</a></li>
						<li><a href="adminpanel/addproduct">Добавить новый товар</a></li>
						<li><a href="adminpanel/sections">Отделы товаров</a></li>	
						<li><a href="adminpanel/addsection">Добавить отдел</a></li>							
					</ul>				
				</td>				
				<jsp:include page="../../fragments/topparts.jsp"/>	
				<td rowspan="2" class="third_td"><br><br><img src="../img/korz.png"></img><br><a href="getbuyproducts">Корзина</a><br><br><br><br><br><br> 					
					<jsp:include page= "../../fragments/security.jsp"/>
				</td>
			</tr>
			<tr class="fourth_tr">
				<td colspan="3" class="fourth_td"> <br>
							
				</td>				
			</tr>	
		</table>
	</body>
</html>	