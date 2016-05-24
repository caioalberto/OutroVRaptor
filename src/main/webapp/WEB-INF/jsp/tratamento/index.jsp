<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="/WEB-INF/jspf/header.jspf"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>WebSal�o - Home</title>
</head>
<body>
	<div class="container">
		<c:if test="${empty usuarioWeb or not usuarioWeb.logado}">
			<h1>Ol�, visitante</h1>
		</c:if>
		<c:if test="${usuarioWeb.logado}">
		<h1>Ol�, ${usuarioWeb.nome }!</h1>
		</c:if>
		<p>Seja bem vindo ao sistema de gerenciamento de sal�es de beleza, WebSal�o.
		Este portal permite voc� marcar suas idas ao sal�o de beleza sem precisar sair de casa. J� para quem �
		dono de um sal�o, aqui voc� pode cadastrar novos tratamentos, editar os hor�rios marcados.</p>
		<br>
		<p>Para poder utilizar o portal, voc� deve se cadastrar.</p>
	</div>
</body>
</html>