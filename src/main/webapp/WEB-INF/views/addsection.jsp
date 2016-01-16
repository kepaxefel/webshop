<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page import = "java.util.ArrayList" %>
<%@ page import = "com.shop.controllers.*" %>
<%@ page import = "com.shop.managers.*" %>
<%@ page import = "com.shop.domains.*" %>
<%@ page import = "com.shop.forms.SectionForm" %>

<!DOCTYPE HTML>

<html>
	<head>
		<title>Добавление товаров</title>
		<jsp:include page= "../../fragments/styles.jsp"/>		
	</head>
	
	<body> 
		<table align="center">
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
				<td colspan="3"class="fourth_adm_td" align="center"> <br>		
					<form:form action="savesection" method="POST" commandName="sectionForm">							 
						 <table cellspacing="5" cellpadding="10" border="0" >									 	
							 	<tr>
							 		<td colspan="2" align="center"><h3>Добавление нового отдела</h3></td>
							 	</tr>
							 
							 	<tr>
							 		<td><div class="form-group">Наименование:</div></td>							 		
							 		<td>
							 			<div class="form-group">
							 				<form:input path="section" class="form-control" size="16" maxlength="30"/>
							 			</div>
							 		</td>							 		
							 	</tr>
							 	<tr>
							 		<td><div class="form-group">Ссылка:</div></td>
									<td>
										<div class="form-group">
											<form:input path="link" class="form-control" size="16" maxlength="30" />
										</div>
									</td>
								</tr>							
	                            <tr>
	                            	<td colspan="2" align="center"><input type="submit" class="btn btn-default" name="saveProduct" value=" Добавить "/></td>
								</tr>
						</table>							
					</form:form>
				</td>				
			</tr>
		</table>	
	</body>
</html>	