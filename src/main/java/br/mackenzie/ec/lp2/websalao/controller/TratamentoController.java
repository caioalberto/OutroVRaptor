package br.mackenzie.ec.lp2.websalao.controller;

import static br.mackenzie.ec.lp2.websalao.service.TratamentoService.verifyAndSetFuncionario;
import static br.mackenzie.ec.lp2.websalao.service.TratamentoService.verifyAndSetProduto;
import static br.mackenzie.ec.lp2.websalao.service.TratamentoService.verifyTratamentoDia;

import java.util.List;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.mackenzie.ec.lp2.websalao.model.Tratamento;
import br.mackenzie.ec.lp2.websalao.persist.dao.AgendaDAO;
import br.mackenzie.ec.lp2.websalao.persist.dao.FuncionarioDAO;
import br.mackenzie.ec.lp2.websalao.persist.dao.ProdutoDAO;
import br.mackenzie.ec.lp2.websalao.service.TratamentoService;
import br.mackenzie.ec.lp2.websalao.service.TratamentoValidator;


/**
 * The Class TratamentoController.
 */
@Resource
public class TratamentoController {


    /** The tratamento. */
    private final Tratamento tratamento;

    /** The funcionario dao. */
    private FuncionarioDAO funcionarioDao;
    
    /** The agenda dao. */
    private AgendaDAO agendaDao;

    /** The validator. */
    private TratamentoValidator validator;
    
    /** The produto dao. */
    private ProdutoDAO produtoDao;


    /** The result. */
    private final Result result;

    /**
     * Instantiates a new tratamento controller.
     *
     * @param tratamento the tratamento
     * @param agendaDao the agenda dao
     * @param funcionarioDao the funcionario dao
     * @param validator the validator
     * @param produtoDao the produto dao
     * @param result the result
     */
    public TratamentoController(Tratamento tratamento, AgendaDAO agendaDao, FuncionarioDAO funcionarioDao, TratamentoValidator validator, ProdutoDAO produtoDao, Result result) {
        this.tratamento = tratamento;
        this.agendaDao = agendaDao;
        this.produtoDao = produtoDao;
        this.funcionarioDao = funcionarioDao;
        this.validator = validator;
        this.result = result;
    }

    /**
     * Novo.
     */
    @Get("/tratamento/novo")
    public void novo() {
        result.include("funcionarios", this.funcionarioDao.listAll());
        result.include("produtos",this.produtoDao.listAll());
    }
    
    /**
     * Add compromisso.
     *
     * @param tratamento the tratamento
     */
    @Post
    @Path("/tratamento/novo")
    public void addCompromisso(Tratamento tratamento) {
        verifyAndSetProduto(tratamento, produtoDao);
        verifyAndSetFuncionario(tratamento, funcionarioDao);
        verifyTratamentoDia(tratamento);

        validator.validate(tratamento);
        validator.onErrorRedirectTo(this).novo();
        agendaDao.save(tratamento);
        result.redirectTo(this).tratamentos();
    }
    
    /**
     * Tratamentos.
     *
     * @return the list
     */
    @Get
    @Path("/agenda")
    public List<Tratamento> tratamentos() {
        return this.agendaDao.listAll();
    }
    
    @Path("/index")
    public void index() {
        
    }
}
