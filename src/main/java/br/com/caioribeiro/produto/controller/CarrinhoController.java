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
 * The Class CarrinhoController.
 */
@Resource
public class CarrinhoController {

    /** The carrinho. */
    private final Carrinho carrinho;
    
    /** The dao. */
    private final ProdutoDAO dao;
    
    /** The result. */
    private final Result result;

    /**
     * Instantiates a new carrinho controller.
     *
     * @param carrinho the carrinho
     * @param dao the dao
     * @param result the result
     */
    public CarrinhoController(Carrinho carrinho, ProdutoDAO dao, Result result) {
        this.carrinho = carrinho;
        this.dao = dao;
        this.result = result;
    }

    /**
     * Adiciona.
     *
     * @param item the item
     */
    @Post
    @Path("/carrinho")
    public void adiciona(Item item) {
        dao.reload(item.getProduto());
        carrinho.add(item);
        result.redirectTo(ProdutosController.class).lista();
    }

    /**
     * Visualiza.
     */
    @Get
    @Path("/carrinho")
    public void visualiza() {

    }
    
    /**
     * Remove.
     *
     * @param indiceItem the indice item
     */
    @Delete("carrinho/{indiceItem}")
    public void remove(int indiceItem) {
        carrinho.remove(indiceItem);
        result.redirectTo(this).visualiza();
    }
}
