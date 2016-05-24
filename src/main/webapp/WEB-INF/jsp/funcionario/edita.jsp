<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@include file="/WEB-INF/jspf/header.jspf"%>
<html>
<head>
<title>Cadastro de Produtos</title>
</head>
<body>
	<div class="container">
		<form id="validate-form" class="form-horizontal" role="form"
			action="<c:url value="/funcionarios/${funcionario.id}"/>" method="POST">
			<fieldset>
				<legend>Cadastro de funcionarios</legend>
				<small>Todos os campos são obrigatórios!</small>
				<div class="form-group">
					<label class="control-label col-sm-2" class="required" for="nome">Nome:</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="funcionario.nome"
							minlength="3" id="nome" placeholder="Nome do funcionario"
							value="${funcionario.nome }">
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" class="required"
						for="profissao">Profissão</label>
					<div class="col-sm-10">
						<input type="text" class="form-control"
							name="funcionario.profissao" minlenght="3" id="profissao"
							placeholder="Profissão do funcionário"
							value="${funcionario.profissao}">
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="usuario">Usuário:</label>
					<div class="col-sm-10">
						<input type="hidden" value="${usuario.login }"
							name="funcionario.usuario.login">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-default">
							<span class="glyphicon glyphicon-floppy-disk"></span>Incluir
							Funcionario
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
            $('#validate-form').validate();
        </script>
	</div>
</body>
</html>