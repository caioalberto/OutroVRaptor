package br.com.caioribeiro.produto.persist.dao;

import org.hibernate.Session;

import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caioribeiro.produto.model.Usuario;

@Component
public class UsuarioDAO {
    
    private Session session;
    private Transaction transaction;
    
    public UsuarioDAO(Session session) {
        this.session = session;
    }
    
    public boolean checkIfAlreadyExistsUser(Usuario usuario) {
        Usuario usuarioEncontrado = (Usuario) session.createCriteria(Usuario.class)
                .add(Restrictions.eq("login", usuario.getLogin()))
                .uniqueResult();
        return usuarioEncontrado != null;
    }
    
    public void save(Usuario usuario) {
      transaction = session.beginTransaction();
      session.save(usuario);
      transaction.commit();
      session.close();
    }

    public Usuario get(Usuario usuario) {
        return (Usuario) session.createCriteria(Usuario.class)
                .add(Restrictions.eq("login", usuario.getLogin()))
                .add(Restrictions.eq("senha", usuario.getSenha()))
                .uniqueResult();
    }
}
