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
		<title>Спортивное питание</title>
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
				<td rowspan="2" class="third_td"><br><br><img src="../img/korz.png"></img><br><a href="../getbuyproducts">Корзина</a><br><br><br><br><br><br> 					
					<jsp:include page= "../../fragments/security.jsp"/>
				</td>
			</tr>
			<tr class="fourth_tr">
				<td colspan="3" class="fourth_td"> <br>		
					<c:if test="${products.isEmpty()}">
						<h3>Товары в данном разделе отсутствуют</h3>
					</c:if>
					<c:if test="${!products.isEmpty()}">
						<table border="0" class="table table-condensed">  			
									<jsp:include page= "../../fragments/tablesheader.jsp"/>
						 	<c:forEach items="${products}" var="products">
						 		<tr>
									<td> &nbsp; ${products.getProductsName()} &nbsp; </td>	
									<td> &nbsp; ${products.getCost()} грн. &nbsp; </td>
									<td><img src="data:image/jpg;base64, <c:out value='${products.getByteArrayString()}'/>"> </td>		
									<td>   	
										<a href="../buyproduct?id=${products.getId()}"><input type="button" value="купить" class="btn btn-default"></a>																					
									</td>						
								</tr>								
							</c:forEach>
						</table> 
					</c:if>	
				</td>
			</tr>	
		</table>
	</body>
</html>	
