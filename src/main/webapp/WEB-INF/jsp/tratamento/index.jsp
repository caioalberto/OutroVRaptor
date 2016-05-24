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
		<c:if test="${usuarioWeb.logado}">
		<h1>Olá, ${usuarioWeb.nome }!</h1>
		</c:if>
		<p>Seja bem vindo ao sistema de gerenciamento de salões de beleza, WebSalão.
		Este portal permite você marcar suas idas ao salão de beleza sem precisar sair de casa. Já para quem é
		dono de um salão, aqui você pode cadastrar novos tratamentos, editar os horários marcados.</p>
		<br>
		<p>Para poder utilizar o portal, você deve se cadastrar.</p>
	</div>
</body>
</html>