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
		<title>Список отделов</title>
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
								<td> Название </td>
								<td> Ссылка </td>														
								<td> Удалить </td>
						</tr>		
						<c:forEach items="${sections}" var="section">					
							<tr>	
								<td> ${section.getId()} </td>
								<td> ${section.getSection()}</td>					
								<td> ${section.getLink()} </td>
								<td> <a href="editsection?id=${section.getId()}"> редактировать </a> <br><br>
									 <a href="../adminpanel/deletesection?id=${section.getId()}"> удалить </a>	
								</td>		
							</tr>	
						</c:forEach>
					</table>
				</td>
			</tr>	
		</table>
	</body>
</html>	