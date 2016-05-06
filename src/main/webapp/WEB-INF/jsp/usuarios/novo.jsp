<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@include file="/WEB-INF/jspf/header.jspf"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastrando um novo usuário</title>
</head>
<body>
	<div class="container">
		<form id="usuariosForm" class="form-horizontal" role="form"
			action="<c:url value="/usuarios"/>" method="POST">
			<fieldset>
				<legend>Criar novo usuário</legend>
				<div class="form-group">
					<label class="control-label col-sm-2" for="nome">Nome:</label>
					<div class="col-sm-10">
						<input id="nome" class="form-control" class="required" type="text"
							name="usuario.nome" placeholder="Digite seu nome"
							value="${usuario.nome }" />

					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="login">Login:</label>
					<div class="col-sm-10">
						<input id="login" class="form-control" data-required type="text"
							name="usuario.login" placeholder="Digite um nome de usuário"
							value="${usuario.login }" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="senha">Senha:</label>
					<div class="col-sm-10">
						<input id="senha" class="form-control" data-required
							type="password" name="usuario.senha"
							placeholder="Digite sua senha" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="confirmacao">Confirme
						a senha:</label>
					<div class="col-sm-10">
						<input class="form-control" data-required id="confirmacao"
							equalTo="#senha" type="password" placeholder="Confirme sua senha" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-primary">
							<span class="glyphicon glyphicon-floppy-disk"></span>Finalizar
							Cadastro
						</button>
					</div>
				</div>
			</fieldset>
		</form>
		<script type="text/javascript">
		 $.validator.setDefaults({
             highlight : function(element, errorClass, validClass) {
                 if (element.type === "radio") {
                     this.findByName(element.name).addClass(errorClass).removeClass(validClass);
                 } else {
                     $(element).closest('.form-group').removeClass('has-success has-feedback').addClass('has-error has-feedback');
                     $(element).closest('.form-group').find('span.glyphicon').remove();
                     $(element).closest('.form-group').append('<span class="glyphicon glyphicon-remove form-control-feedback" aria-hidden="true"></span>');
                 }
             },
             unhighlight : function(element, errorClass, validClass) {
                 if (element.type === "radio") {
                     this.findByName(element.name).removeClass(errorClass).addClass(validClass);
                 } else {
                     $(element).closest('.form-group').removeClass('has-error has-feedback').addClass('has-success has-feedback');
                     $(element).closest('.form-group').find('span.glyphicon').remove();
                     $(element).closest('.form-group').append('<span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>');
                 }
             }
         });
            $('#usuariosForm').validate();
        </script>
	</div>
</body>
</html>