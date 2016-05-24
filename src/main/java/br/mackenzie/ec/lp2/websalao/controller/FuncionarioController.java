package br.mackenzie.ec.lp2.websalao.controller;

import java.util.List;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.mackenzie.ec.lp2.websalao.model.Funcionario;
import br.mackenzie.ec.lp2.websalao.model.Usuario;
import br.mackenzie.ec.lp2.websalao.persist.dao.FuncionarioDAO;
import br.mackenzie.ec.lp2.websalao.persist.dao.UsuarioDAO;

/**
 * The Class FuncionarioController.
 */
@Resource
public class FuncionarioController {

    /** The funcionario dao. */
    private final FuncionarioDAO funcionarioDao;

    /** The usuario dao. */
    private final UsuarioDAO usuarioDao;

    /** The result. */
    private final Result result;

    /** The validator. */
    private final Validator validator;

    /**
     * Instantiates a new funcionario controller.
     *
     * @param funcionarioDao the funcionario dao
     * @param usuarioDao the usuario dao
     * @param result the result
     * @param validator the validator
     */
    public FuncionarioController(FuncionarioDAO funcionarioDao, UsuarioDAO usuarioDao, Result result, Validator validator) {
        this.funcionarioDao = funcionarioDao;
        this.usuarioDao = usuarioDao;
        this.result = result;
        this.validator = validator;
    }

    /**
     * Novo.
     *
     * @return the list
     */
    @Get
    @Path("/funcionarios/novo")
    public List<Usuario> novo() {
        return this.usuarioDao.listAll();
    }

    /**
     * Salvar funcionario.
     *
     * @param funcionario the funcionario
     */
    @Post
    @Path("/funcionarios/novo")
    public void salvarFuncionario(Funcionario funcionario) {
        validator.onErrorRedirectTo(this).novo();
        funcionarioDao.save(funcionario);
        result.redirectTo(this).listarFuncionarios();
    }

    /**
     * Listar funcionarios.
     *
     * @return the list
     */
    @Get("/funcionarios")
    public List<Funcionario> listarFuncionarios() {
        return this.funcionarioDao.listAll();
    }

    /**
     * Edita.
     *
     * @param id the id
     * @return the funcionario
     */
    @Get("/funcionarios/{id}")
    public Funcionario edita(Long id) {
        return funcionarioDao.load(id);
    }

    /**
     * Altera.
     *
     * @param funcionario the funcionario
     */
    @Put("/funcionarios/{funcionario.id}")
    public void altera(Funcionario funcionario) {
        validator.validate(funcionario);
        validator.onErrorRedirectTo(this).novo();

        funcionarioDao.update(funcionario);
        result.redirectTo(this).listarFuncionarios();
    }

}
