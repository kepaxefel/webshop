<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page import = "java.util.ArrayList" %>
<%@ page import = "com.shop.controllers.*" %>
<%@ page import = "com.shop.managers.*" %>
<%@ page import = "com.shop.domains.*" %>
<%@ page import = "com.shop.forms.*" %>

<!DOCTYPE HTML>

<html>
	<head>
		<title>Регистрация нового пользователя</title>
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
				<td colspan="3" align="center"> <br>
					<form:form action="adduser" method="POST" commandName="userForm" >
						 <table border="0" >							 	
							 	<tr>
							  		<td> <form:input path="name" size="15" maxlength="30" placeholder="Имя" class="form-control"/> Введите Ваше имя </td>
							 	</tr>
							 	<tr>
							 		<td> <form:input path="surname" size="15" maxlength="30" placeholder="Фамилия" class="form-control"/> Введите Вашу фамилию </td>
							 	</tr>
							 	<tr>
							 		<td> <form:input path="login" size="15" maxlength="30" placeholder="Логин" class="form-control"/> Введите логин для входа на сайт	</td>
							 	</tr>
							 	<tr>
							 		<td> <form:password path="passOne" size="15" maxlength="30" placeholder="Введите пароль" class="form-control"/> Введите Ваш пароль</td>
							 	</tr>
							 	<tr>
							 		<td> <form:password path="passTwo" size="15" maxlength="30" placeholder="Повторите пароль" class="form-control" /> Повторите Ваш пароль </td>
							 	</tr>
							 	<tr>
							 		<td align="center"> <form:radiobutton path="gender" value="m" />муж. <form:radiobutton path="gender" value="f"/>жен.</td>
							 	</tr>
							 	<tr>
							 		<td> <form:input path="email" size="15" maxlength="30" placeholder="Укажите Ваш e-mail" class="form-control"/> Укажите Ваш электронный адрес </td>
							 	</tr>
							 	<tr>
							 		<td> <form:input path="number" size="15" maxlength="30" placeholder="Ваш номер телефона" class="form-control"/> Укажите Ваш мобильный телефон </td>
							 	</tr>
							 	<tr>
							 		<td align="center"> <input type="submit" value=" Оформить " name="UsersServlet"/> <input type="reset" value=" Очистить "/> </td>							 		 
							 	</tr>
						 </table>
					</form:form>
				</td>
			</tr>
		</table>
	</body>
</html>	
