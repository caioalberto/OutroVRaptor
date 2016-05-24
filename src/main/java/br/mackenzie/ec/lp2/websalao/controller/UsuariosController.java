package br.mackenzie.ec.lp2.websalao.controller;

import javax.servlet.jsp.tagext.ValidationMessage;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.Message;
import br.mackenzie.ec.lp2.websalao.model.Usuario;
import br.mackenzie.ec.lp2.websalao.model.login.UsuarioWeb;
import br.mackenzie.ec.lp2.websalao.persist.dao.UsuarioDAO;

@Resource
public class UsuariosController {

    private final UsuarioDAO dao;
    private final Result result;
    private final Validator validator;
    private final UsuarioWeb usuarioWeb;

    public UsuariosController(UsuarioDAO dao, Result result, Validator validator, UsuarioWeb usuarioWeb) {
        this.dao = dao;
        this.result = result;
        this.validator = validator;
        this.usuarioWeb = usuarioWeb;
    }

    @Post("/usuarios")
    public void adiciona(Usuario usuario) {
        if (dao.checkIfAlreadyExistsUser(usuario)) {
            validator.add((Message) new ValidationMessage("Login já existe", "usuario.login"));
        }
        validator.onErrorUsePageOf(UsuariosController.class).novo();

        dao.save(usuario);

        result.redirectTo(ProdutosController.class).lista();
    }

    public void novo() {
    }
    
    @Get("/login")
    public void loginForm() {
      
    }
    
    @Post("/login")
    public void login(Usuario usuario) {
        Usuario carregado = dao.get(usuario);
        if(carregado == null) {
            validator.add((Message) new ValidationMessage("Login e/ou Senha inválidos!", "usuario.login"));
        }
        validator.onErrorUsePageOf(UsuariosController.class).loginForm();
        
        usuarioWeb.login(carregado);
        
        result.redirectTo(ProdutosController.class).lista();
    }
    
    @Path("/logout")
    public void logout() {
      usuarioWeb.logout();
      result.redirectTo(ProdutosController.class).lista();
    }

}
