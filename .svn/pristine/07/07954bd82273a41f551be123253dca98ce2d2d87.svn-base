<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<%@ page import = "java.util.ArrayList" %>
<%@ page import = "com.shop.controllers.*" %>
<%@ page import = "com.shop.managers.*" %>
<%@ page import = "com.shop.domains.*" %>

<!DOCTYPE HTML>

<html>
	<head>
		<title>Список заказов</title>
		<jsp:include page= "../../fragments/styles.jsp"/>		
	</head>
	
	<body> 
		<table align="center" class="main_table" border="0">
			<tr class="logo_tr">
				<td colspan="5"><a href="/"><img src="../img/0.jpg"></a></td>  	<!-- логотип/header -->
			</tr>
			<tr class="sec_tr">
				<td  rowspan="2" class="sec_adm_td"><br>
					<jsp:include page= "../../fragments/adminparts.jsp"/>			
				</td>				
				<jsp:include page="../../fragments/topparts.jsp"/>	
				<td rowspan="2" class="third_td"><br><br><img src="../img/korz.png"></img><br><a href="getbuyproducts">Корзина</a><br><br><br><br><br><br> 					
					<jsp:include page= "../../fragments/security.jsp"/>
				</td>
			</tr>
			<tr class="fourth_tr">
				<td colspan="3" class="fourth_td"> <br>							
					<table class="table table-striped" border="0">
						<tr align="center">
								<td> ${columnNames[0]} </td>
								<td> ${columnNames[1]} </td>
								<td> ${columnNames[2]} </td>
								<td> ${columnNames[3]} </td>
								<td> ${columnNames[4]} </td>								
								<td> ${columnNames[5]} </td>		
								<td> ${columnNames[6]} </td>			
								<td> ${columnNames[7]} </td>	
								<td> ${columnNames[8]} </td>												
						</tr>		
						<c:forEach items="${orders}" var="order">					
							<tr align="center">	
								<td> ${order.getId()}</td>
								<td> ${order.getProductsName()}</td>					
								<td> ${order.getProductsPart()} </td>
								<td> ${order.getCost()} </td>								
								<td> ${order.getUser().getName()} </td>
								<td> ${order.getUser().getSurname()} </td>
								<td> ${order.getUser().getNumber()} </td> 	
								<td> ${order.getCurrentDate()} </td>
								<td> <a href="../adminpanel/deleteorder?id=${order.getId()}"> удалить </a>	</td>		
							</tr>	
						</c:forEach>
					</table> 
				</td>
			</tr>	
		</table>
	</body>
</html>	