<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="/WEB-INF/jspf/header.jspf"%>
<html>
<head>
<style type="text/css">
.link {
	text-decoration: none;
	border: none;
	background: none;
	cursor: pointer;
}
</style>
<title>Lista de Produtos</title>
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
		<c:if test="${not empty nome}">
			<h3>
				Resultados da busca pelo nome <b>"${nome}"</b>
			</h3>
		</c:if>
		<h2>Lista de produtos:</h2>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Código</th>
					<th>Nome</th>
					<th>Descrição</th>
					<th>Preco</th>
				</tr>
			</thead>
			<tbody class="table-striped">
				<c:forEach items="${produtoList}" var="produto">
					<tr>
						<td>${produto.id }</td>
						<td>${produto.nome }</td>
						<td>${produto.descricao }</td>
						<td>${produto.preco }</td>
						<td><a href="<c:url value="/produtos/${produto.id}"/>"
							class="btn btn-primary btn-sm"> <span
								class="glyphicon glyphicon-edit" aria-hidden="true"></span>Editar
						</a></td>
						<td><form action="<c:url value="/produtos/${produto.id}"/>"
								method="POST">
								<button class="btn btn-danger btn-sm" name="_method"
									value="DELETE">
									<span class="glyphicon glyphicon-trash"></span>Remover
								</button>
							</form></td>
						<td><form action="<c:url value="/carrinho"/>" method="POST">
								<input type="hidden" name="item.produto.id"
									value="${produto.id }" /> <input type="number"
									class="quantidade" name="item.quantidade" value="1" />
								<button type="submit" class="btn btn-success btn-sm">
									<span class="glyphicon glyphicon-shopping-cart"></span>Comprar
								</button>
							</form>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>