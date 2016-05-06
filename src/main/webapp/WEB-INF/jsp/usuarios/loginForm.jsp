<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@include file="/WEB-INF/jspf/header.jspf"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<div class="container">
		<form class="form-horizontal" role="form"
			action="<c:url value="/login"/>" method=POST>
			<fieldset>
				<legend>Login</legend>
				<div class="form-group">
					<label class="control-label col-sm-2" for="login">Login:</label>
					<div class="col-sm-10">
						<input id="login" class="form-control" class="required"
							type="text" name="usuario.login" placeholder="Digite seu login"
							value="${usuario.login }" />
					</div>
				</div>
				<br>
				<div class="form-group">
					<label class="control-label col-sm-2" for="senha">Senha:</label>
					<div class="col-sm-10">
						<input id="senha" class="form-control" class="required"
							type="password" name="usuario.senha"
							placeholder="Digite sua senha" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<div class="checkbox">
							<label><input type="checkbox"> Lembrar me</label>
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-primary">Login</button>
						<button type="reset" class="btn btn-danger">Redefinir</button>
					</div>
				</div>
			</fieldset>
		</form>

	</div>
</body>
</html>