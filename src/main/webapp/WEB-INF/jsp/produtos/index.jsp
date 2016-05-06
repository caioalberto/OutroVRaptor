<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="/WEB-INF/jspf/header.jspf"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>WebSalão - Home</title>
</head>
<body>
	<div class="container">
		<c:if test="${empty usuarioWeb or not usuarioWeb.logado}">
			<h1>Olá, visitante</h1>
		</c:if>
		<div class="dropdown">
			<button class="btn btn-primary dropdown-toggle" type="button"
				data-toggle="dropdown">
				Escolha um mês <span class="caret"></span>
			</button>
			<ul class="dropdown-menu">

			</ul>
		</div>
	</div>
</body>
</html>