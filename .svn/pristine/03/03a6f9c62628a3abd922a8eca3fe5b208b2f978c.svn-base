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
		<title>Список пользователей</title>
		<jsp:include page= "../../fragments/styles.jsp"/>		
	</head>
	
	<body> 
		<table align="center" class="main_table" border="0">
			<tr class="logo_tr">
				<td colspan="5"><a href="/"><img src="../img/0.jpg"></a></td>  	<!-- логотип/header -->
			</tr>
			<tr class="sec_tr">
				<td rowspan="2" class="sec_adm_td"><br>
					<jsp:include page= "../../fragments/adminparts.jsp"/>				
				</td>								
				<jsp:include page="../../fragments/topparts.jsp"/>	
				<td rowspan="2" class="third_td"><br><br><img src="../img/korz.png"></img><br><a href="getbuyproducts">Корзина</a><br><br><br><br><br><br> 					
					<jsp:include page= "../../fragments/security.jsp"/>
				</td>	
			</tr>
			<tr class="fourth_tr">
				<td colspan="3" class="fourth_td"> <br>							
					<table  class="table table-bordered" border="1" cellspacing="0" cellpadding="0" align="center">
							<tr align="center">
								<td> ID </td>
								<td> ${columnNames[0]} </td>
								<td> ${columnNames[1]} </td>
								<td> ${columnNames[2]} </td>
								<td> ${columnNames[3]} </td>
								<td> ${columnNames[4]} </td>						
							</tr>					
							
							<c:forEach items="${products}" var="product">	
								<tr align="center"> 
									<td> ${product.getId()} </td>
									<td> ${product.getProductsName()} </td>
									<td> ${product.getProductsPart()} </td>
									<td> ${product.getCost()} </td>
									<td><img src="data:image/jpg;base64, <c:out value='${product.getByteArrayString()}'/>"> </td>		
									<td> <a href="editproduct?id=${product.getId()}"> редактировать </a> <br><br> 
										 <a href="deleteproduct?id=${product.getId()}"> удалить </a>
									</td>				
								</tr>			
							</c:forEach>	
					</table>
				</td>
			</tr>
		</table>	
	</body>
</html>	