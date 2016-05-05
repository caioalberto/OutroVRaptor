<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@include file="/WEB-INF/jspf/header.jspf"%>
<html>
<head>
<title>Cadastro de Produtos</title>
<script type="text/javascript">

	$('#produtosForm').validate({
		rules : {
			"produto.nome" : {
				required : true,
				minlength : 3
			},
			"produto.descricao" : {
				required : true,
				maxlength : 40
			},
			"produto.preco" : {
				min : 0.0
			}
		}
	});
</script>
</head>
<body>
	<div class="container">
		<h1>Formulário de cadastro de produtos:</h1>
		<form id="validate-form" class="form-horizontal" role="form"
			action="<c:url value="/produtos"/>" method="POST">
			<div class="form-group">
				<input type="hidden" name="produto.id" value="${produto.id }" /> <label
					class="control-label col-sm-2" for="nome">Nome:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="produto.nome"
						placeholder="Nome do produto" value="${produto.nome }">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="descricao">Descrição</label>
				<div class="col-sm-10">
					<textarea class="form-control" name="produto.descricao"
						id="inputDescricao" placeholder="Descrição do produto">${produto.descricao }</textarea>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="descricao">Preço:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="produto.preco"
						placeholder="Preço do produto" value="${produto.preco }">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">
						<span class="glyphicon glyphicon-floppy-disk"></span>Salvar
						Produto
					</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>