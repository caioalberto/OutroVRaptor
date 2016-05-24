<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="/WEB-INF/jspf/header.jspf"%>
<html>
<head>
<style type="text/css">
</style>
<title>Lista de Funcionarios</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h2>Funcionarios:</h2>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Código</th>
					<th>Nome</th>
					<th>Profissão</th>
					<th>Usuario</th>
				</tr>
			</thead>
			<tbody class="table-striped">
				<c:forEach items="${funcionarioList}" var="funcionario">
					<tr>
						<td>${funcionario.id }</td>
						<td>${funcionario.nome }</td>
						<td>${funcionario.profissao }</td>
						<td>${funcionario.usuario.login }</td>
						<td><a href="<c:url value="/funcionarios/${funcionario.id}"/>"
							class="btn btn-primary btn-sm"> <span
								class="glyphicon glyphicon-edit" aria-hidden="true"></span>Editar Dados
						</a></td>
						<td><form action="<c:url value="/funcionarios/${funcionario.id}"/>"
								method="POST">
								<button class="btn btn-danger btn-sm" name="_method"
									value="DELETE">
									<span class="glyphicon glyphicon-trash"></span>Remover Funcionario
								</button>
							</form></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>