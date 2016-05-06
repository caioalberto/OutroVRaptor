package br.com.caioribeiro.produto.controller;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caioribeiro.produto.model.Carrinho;
import br.com.caioribeiro.produto.model.Item;
import br.com.caioribeiro.produto.persist.dao.ProdutoDAO;

/**
 * @author Caio Ribeiro
 *
 */
@Resource
public class CarrinhoController {

    private final Carrinho carrinho;
    private final ProdutoDAO dao;
    private final Result result;

    public CarrinhoController(Carrinho carrinho, ProdutoDAO dao, Result result) {
        this.carrinho = carrinho;
        this.dao = dao;
        this.result = result;
    }

    @Post
    @Path("/carrinho")
    public void adiciona(Item item) {
        dao.reload(item.getProduto());
        carrinho.add(item);
        result.redirectTo(ProdutosController.class).lista();
    }

    @Get
    @Path("/carrinho")
    public void visualiza() {

    }
    
    @Delete("carrinho/{indiceItem}")
    public void remove(int indiceItem) {
        carrinho.remove(indiceItem);
        result.redirectTo(this).visualiza();
    }
}
