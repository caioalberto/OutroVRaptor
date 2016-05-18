package br.com.caioribeiro.produto.controller;

import static br.com.caioribeiro.produto.service.Utils.verifyAndSetProduto;

import java.util.List;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caioribeiro.produto.model.Produto;
import br.com.caioribeiro.produto.model.Tratamento;
import br.com.caioribeiro.produto.persist.dao.AgendaDAO;
import br.com.caioribeiro.produto.persist.dao.ProdutoDAO;


/**
 * The Class TratamentoController.
 */
@Resource
public class TratamentoController {


    /** The tratamento. */
    private final Tratamento tratamento;


    /** The agenda dao. */
    private AgendaDAO agendaDao;


    /** The produto dao. */
    private ProdutoDAO produtoDao;


    /** The result. */
    private final Result result;

    /**
     * Instantiates a new tratamento controller.
     *
     * @param tratamento the tratamento
     * @param agendaDao the agenda dao
     * @param produtoDao the produto dao
     * @param result the result
     */
    public TratamentoController(Tratamento tratamento, AgendaDAO agendaDao, ProdutoDAO produtoDao, Result result) {
        this.tratamento = tratamento;
        this.agendaDao = agendaDao;
        this.produtoDao = produtoDao;
        this.result = result;
    }

    /**
     * Novo.
     *
     * @return the list
     */
    @Get("/nova-reserva")
    public List<Produto> novo() {
        return this.produtoDao.listAll();
    }

    /**
     * Add compromisso.
     *
     * @param tratamento the tratamento
     */
    @Post
    @Path("/nova-reserva")
    public void addCompromisso(Tratamento tratamento) {
        verifyAndSetProduto(tratamento, produtoDao);
        agendaDao.save(tratamento);
        result.redirectTo(this).tratamentos();
    }
    
    @Get
    @Path("/agenda")
    public List<Tratamento> tratamentos() {
        return this.agendaDao.listTratamentos();
    }
}
