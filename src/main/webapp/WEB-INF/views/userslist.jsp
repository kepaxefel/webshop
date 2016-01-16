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
		<table align="center" class="main_table">
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
				<td  colspan="3" class="fourth_adm_td"> <br>							
					<table class="table table-striped" border="0">
						<tr>
								<td> ID </td>
								<td> Имя </td>
								<td> Фамилия </td>
								<td> Логин </td>
								<td> Пол </td>
								<td> Email </td>
								<td> Телефон </td>		
								<td> Удаление </td>								
						</tr>		
						<c:forEach items="${users}" var="user">					
							<tr>	
								<td> ${user.getId()}</td>					
								<td> ${user.getName()} </td>
								<td> ${user.getSurname()} </td>
								<td> ${user.getLogin()} </td>
								<td> ${user.isGender() ? "мужской" : "женский"} </td>
								<td> ${user.getEmail()} </td>
								<td> ${user.getNumber()} </td> 	
								<td> <a href="../adminpanel/deleteuser?id=${user.getId()}"> удалить </a>	</td>		
							</tr>	
						</c:forEach>
					</table>
				</td>
			</tr>	
		</table>
	</body>
</html>	