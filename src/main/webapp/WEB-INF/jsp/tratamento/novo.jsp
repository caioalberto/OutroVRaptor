<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/jspf/header.jspf"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Agenda</title>
</head>
<body>
	<div class="container">
		<div class="middle-form">
			<form class="form-horizontal" role="form"
				action="<c:url value="/tratamento/novo"/>" method="POST">
				<fieldset>
					<legend>Marcar Horário</legend>

					<div class="form-group">
						<label class="control-label col-sm-2" for="nome">Nome do
							Tratamento:</label>
						<div class="col-sm-10">
							<select class="form-control" name="tratamento.produto.id">
								<c:forEach items="${produtos}" var="produto">
									<option value="${produto.id}">${produto.nome}</option>
								</c:forEach>
							</select>
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-2"
							for="funcionario responsavel">Funcionario Responsável:</label>
						<div class="col-sm-10">
							<select class="form-control" name="tratamento.responsavel.id">
								<c:forEach items="${funcionarios}" var="funcionario">
									<option value="${funcionario.id}">${funcionario.nome}</option>
								</c:forEach>
							</select>
						</div>
					</div> 

					<div class="form-group">
						<label class="control-label col-sm-2" for=data>Data:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="tratamento.data">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="horaInicio">
							Hora de início:</label>
						<div class="col-sm-10">
							<select class="form-control" name="tratamento.horaInicio">
								<option value="12">12:00</option>
								<option value="13">13:00</option>
								<option value="14">14:00</option>
								<option value="15">15:00</option>
								<option value="16">16:00</option>
								<option value="17">17:00</option>
								<option value="18">18:00</option>
								<option value="19">19:00</option>
								<option value="20">20:00</option>
								<option value="21">21:00</option>
								<option value="22">22:00</option>
							</select>
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-2" for="horaFim">Hora
							de término:</label>
						<div class="col-sm-10">
							<select class="form-control" name="tratamento.horaFim">
								<option value="12">12:00</option>
								<option value="13">13:00</option>
								<option value="14">14:00</option>
								<option value="15">15:00</option>
								<option value="16">16:00</option>
								<option value="17">17:00</option>
								<option value="18">18:00</option>
								<option value="19">19:00</option>
								<option value="20">20:00</option>
								<option value="21">21:00</option>
								<option value="22">22:00</option>
							</select>
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-primary">Marcar
								Horário</button>
						</div>
					</div>
				</fieldset>
			</form>
		</div>
	</div>
</body>
</html>