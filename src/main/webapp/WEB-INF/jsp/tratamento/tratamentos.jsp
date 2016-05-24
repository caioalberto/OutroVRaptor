<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="/WEB-INF/jspf/header.jspf"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Tratamento</th>
					<th>Data</th>
					<th>Hora Inicial</th>
					<th>Hora Final</th>
					<th>Funcionario Responsável</th>
					<th>Valor Final</th>
				</tr>
			</thead>
			<c:forEach items="${tratamentoList}" var="tratamento">
				<tbody>
					<tr>
						<td>${tratamento.produto.nome}</td>
						<td>${tratamento.dataNome } - ${tratamento.diaNome }</td>
						<td>${tratamento.horaInicio }</td>
						<td>${tratamento.horaFim }</td>
						<td>${tratamento.funcionarioResponsavel.nome}</td>
						<td>${tratamento.produto.preco }</td>
					</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>