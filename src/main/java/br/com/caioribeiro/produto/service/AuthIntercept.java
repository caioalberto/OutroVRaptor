package br.com.caioribeiro.produto.service;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.resource.ResourceMethod;
import br.com.caioribeiro.produto.controller.UsuariosController;

@Intercepts
public class AuthIntercept implements Interceptor {

    private final UsuarioWeb usuario;
    private final Result result;

    public AuthIntercept(UsuarioWeb usuario, Result result) {
        this.usuario = usuario;
        this.result = result;
    }

    public boolean accepts(ResourceMethod method) {
        return !usuario.isLogado() && method.containsAnnotation(Forbidden.class);
    }

    public void intercept(InterceptorStack stack, ResourceMethod method, Object resourceInstance) throws InterceptionException {
        result.redirectTo(UsuariosController.class).loginForm();
    }

}
