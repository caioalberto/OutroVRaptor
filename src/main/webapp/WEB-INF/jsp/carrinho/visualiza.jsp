<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Carrinho de compras</title>
</head>
<body>
	<div class="container">
		<h3>Itens do seu carrinho de compras</h3>

		<table>
			<thead>
				<tr>
					<th>Nome</th>
					<th>Descrição</th>
					<th>Preço</th>
					<th>Quantidade</th>
					<th>Total</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${carrinho.itens}" var="item" varStatus="s">
					<tr>
						<td>${item.produto.nome }</td>
						<td>${item.produto.descricao }</td>
						<td><fmt:formatNumber type="currency"
								value="${item.produto.preco }" /></td>
						<td>${item.quantidade }</td>
						<td><fmt:formatNumber type="currency"
								value="${item.quantidade * item.produto.preco }" /></td>
						<td>
							<form action="<c:url value="/carrinho/${s.index}"/>"
								method="POST">
								<button class="btn btn-danger btn-sm" name="_method"
									value="DELETE">
									<span class="glyphicon glyphicon-trash"></span>Remover do
									Carrinho
								</button>
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td></td>
					<th>Total:</th>
					<th><fmt:formatNumber type="currency"
							value="${carrinho.total }" /></th>
				</tr>
			</tfoot>
		</table>
	</div>
</body>
</html>