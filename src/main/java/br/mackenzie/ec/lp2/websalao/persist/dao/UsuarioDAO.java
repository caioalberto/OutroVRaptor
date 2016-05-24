package br.mackenzie.ec.lp2.websalao.persist.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.mackenzie.ec.lp2.websalao.model.Usuario;

@Component
public class UsuarioDAO implements GenericoDAO<Usuario>{
    
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
    
    public List<Usuario> listAll() {
        return this.session.createCriteria(Usuario.class).list();
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

    @Override
    public Usuario load(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void update(Usuario t) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void delete(Usuario t) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<Usuario> search(String campo) {
        // TODO Auto-generated method stub
        return null;
    }
}
