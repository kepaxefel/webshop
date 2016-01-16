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
		<title>Редактирование товара</title>
		<jsp:include page= "../../fragments/styles.jsp"/>		
	</head>
	
	<body> 
		<table align="center" class="main_table">
			<tr class="logo_tr">
				<td colspan="5"><a href="/"><img src="../img/0.jpg"></a></td>  	<!-- логотип/header -->
			</tr>
			<tr class="sec_tr">
				<td  rowspan="2" class="sec_td" valign="top"><br>
					<jsp:include page= "../../fragments/adminparts.jsp"/>			
				</td>				
				<jsp:include page="../../fragments/topparts.jsp"/>	
				<td rowspan="2" class="third_td"><br><br><img src="../img/korz.png"></img><br><a href="getbuyproducts">Корзина</a><br><br><br><br><br><br> 					
					<jsp:include page= "../../fragments/security.jsp"/>
				</td>
			</tr>
			<tr class="fourth_tr">
				<td colspan="3" > <br>		
					<form:form modelAttribute="productAttribute" action="saveeditproduct" method="POST" commandName="productAttribute" enctype="multipart/form-data">	
						 
						 <table cellspacing="5" cellpadding="10" border="0" align="center">									 	
							 	<tr>
							 		<td colspan="2" align="center"><h3>Редактирование товара</h3></td>
							 	</tr>
							 	
							 	<tr>
								   <td><div class="form-group"><form:label path="id">Id:</form:label></div></td>
								   <td>
								   		<div class="form-group">
								   			<form:input path="id" disabled="true"/>	
								   			<form:hidden path="id" />
								   		</div>
								   </td>
							  	</tr>
							 
							 	<tr>
							 		<td><div class="form-group"><form:label path="productsName">Наименование:</form:label></div></td>							 		
							 		<td>
							 			<div class="form-group">
							 				<form:input path="productsName" class="form-control" size="16" maxlength="20"/>
							 			</div>
							 		</td>							 		
							 	</tr>
							 	<tr>
							 		<td><div class="form-group"><form:label path="productsPart">Отдел:</form:label></div></td>
									<td>
										<div class="form-group">
											<form:select path="productsPart" class="form-control" items="${partsList}" />
										</div>
									</td>
								</tr>							
	                            <tr>
	                            	<td><div class="form-group"><form:label path="cost">Стоимость</form:label></div></td>
	                            	<td>
	                            		<div class="form-group">
	                            			<form:input path="cost" class="form-control" size="5" maxlength="7" placeholder="грн"/>
	                            		</div>
	                            	</td>
	                            </tr>    
	                            <tr>
	                            	<td><div class="form-group"><form:label path="image">Изображение</form:label></div></td>                            	  
	                            	<td>
	                            		<div class="form-group">
	                            			<input type="file" name="image" id="image"/>
	                            		</div>
	                            	</td>                     	
	                            </tr>
	                            <tr>
	                            	<td colspan="2" align="center"><input type="submit" class="btn btn-default" name="saveProduct" value=" Сохранить "/></td>
								</tr>
						</table>							
					</form:form>
				</td>				
			</tr>
		</table>	
	</body>
</html>	