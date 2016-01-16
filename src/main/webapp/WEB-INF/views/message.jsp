<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page import = "java.util.ArrayList" %>
<%@ page import = "com.shop.controllers.*" %>

<!DOCTYPE HTML>

<html>
	<head>
		<title>Сообщение</title>
		<jsp:include page= "../../fragments/styles.jsp"/>		
	</head>
	
	<body> 
		<table align="center" class="main_table">
			<tr class="logo_tr">
				<td colspan="5"><a href="/"><img src="../../img/0.jpg"></a></td>  	<!-- логотип/header -->
			</tr>
			<tr class="sec_tr"> 
				<td  rowspan="2" class="sec_td" valign="top"><br>
					<jsp:include page= "../../fragments/adminparts.jsp"/>				
				</td>				
				<jsp:include page="../../fragments/topparts.jsp"/>	
				<td rowspan="2" class="third_td"><br><br><img src="img/korz.png"></img><br><a href="getbuyproducts">Корзина</a><br><br><br><br><br><br> 					
					<jsp:include page= "../../fragments/security.jsp"/>
				</td>
			</tr>
			<tr class="fourth_tr">
				<td colspan="3" class="fourth_td"> <br>		
						<h2>${message}</h2>						
						<a href="${link}"> <button class="btn btn-default" >  OK  </button> </a>						
				</td>				
			</tr>
		</table>	
	</body>
</html>	