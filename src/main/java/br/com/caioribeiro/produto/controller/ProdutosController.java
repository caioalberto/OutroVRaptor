package br.com.caioribeiro.produto.controller;

import java.util.List;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caioribeiro.produto.model.Produto;
import br.com.caioribeiro.produto.persist.dao.ProdutoDAO;

@Resource
public class ProdutosController {

	private ProdutoDAO dao;
	private final Result result;
	private final Validator validator;

	public ProdutosController(ProdutoDAO dao, Result result, Validator validator) {
		this.dao = dao;
		this.result = result;
		this.validator = validator;
	}

	@Get("/produtos/novo")
	public void formulario() {
	}

	@Get("/produtos/{id}/edita")
	public Produto edita(Long id) {
		return dao.load(id);
	}

	@Put("/produtos/{produto.id}/edita")
	public void altera(Produto produto) {
		validator.validate(produto);
		validator.onErrorRedirectTo(this).formulario();

		dao.update(produto);
		result.redirectTo(this).lista();
	}

	@Post("/produtos")
	public void cadastra(final Produto produto) {
		validator.validate(produto);
		validator.onErrorRedirectTo(this).formulario();

		dao.save(produto);
		result.redirectTo(this).lista();
	}

	@Delete("/produtos/{id}")
	public void remove(Long id) {
		Produto produto = dao.load(id);
		dao.delete(produto);
		result.redirectTo(ProdutosController.class).lista();
	}

	@Get("/produtos")
	public List<Produto> lista() {
		return dao.listAll();
	}
	
	public List<Produto> busca(String nome) {
		result.include("nome", nome);
		return dao.search(nome);
	}

}
