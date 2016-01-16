<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
	
	<sec:authorize access="isAuthenticated() and principal.username=='admin'"> 
		<a href="/adminpanel"> Панель администратора </a>
	</sec:authorize>
	
	<sec:authorize access="!isAuthenticated()">
		<div class="container" style="width: 220px;">
	    <c:url value="/j_spring_security_check" var="loginUrl" />
		    <form action="${loginUrl}" method="post">
		        <h3 class="form-signin-heading">Вход</h3>
		        <input type="text" class="form-control" name="j_username" placeholder="Логин">
		        <input type="password" class="form-control" name="j_password" placeholder="Пароль" >
		        <button class="btn btn-lg btn-primary btn-block" type="submit">Войти</button>
		    </form>
		    <a href="registration"> Регистрация </a>
		</div>
	</sec:authorize>
	
	<sec:authorize access="isAuthenticated()">
	    <p>Ваш логин: <sec:authentication property="principal.username" /></p>
	    <p><a class="btn btn-lg btn-danger" href="<c:url value="/logout" />" role="button">Выйти</a></p>
	</sec:authorize>
	