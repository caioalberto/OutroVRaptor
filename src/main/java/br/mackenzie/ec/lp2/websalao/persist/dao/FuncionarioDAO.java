package br.mackenzie.ec.lp2.websalao.persist.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.mackenzie.ec.lp2.websalao.model.Funcionario;
import br.mackenzie.ec.lp2.websalao.model.Tratamento;

/**
 * The Class FuncionarioDAO.
 */
@Component
public class FuncionarioDAO implements GenericoDAO<Funcionario>{

    /** The session. */
    private Session session;

    /** The transaction. */
    private Transaction transaction;

    /**
     * Instantiates a new funcionario dao.
     *
     * @param session the session
     */
    public FuncionarioDAO(Session session) {
        this.session = session;
    }

    /* (non-Javadoc)
     * @see br.com.caioribeiro.produto.persist.dao.GenericoDAO#save(java.lang.Object)
     */
    public void save(Funcionario funcionario) {
        transaction = session.beginTransaction();
        session.save(funcionario);
        transaction.commit();
        session.close();
    }

    /* (non-Javadoc)
     * @see br.com.caioribeiro.produto.persist.dao.GenericoDAO#listAll()
     */
    @SuppressWarnings("unchecked")
    public List<Funcionario> listAll() {
        return this.session.createCriteria(Funcionario.class).list();
    }

    /* (non-Javadoc)
     * @see br.com.caioribeiro.produto.persist.dao.GenericoDAO#load(java.lang.Long)
     */
    public Funcionario load(Long id) {
        return (Funcionario) this.session.get(Funcionario.class, id);
    }

    /* (non-Javadoc)
     * @see br.com.caioribeiro.produto.persist.dao.GenericoDAO#update(java.lang.Object)
     */
    public void update(Funcionario funcionario) {
        transaction = session.beginTransaction();
        session.update(funcionario);
        transaction.commit();
        session.close();
    }

    /* (non-Javadoc)
     * @see br.com.caioribeiro.produto.persist.dao.GenericoDAO#delete(java.lang.Object)
     */
    public void delete(Funcionario funcionario) {
        transaction = session.beginTransaction();
        session.delete(funcionario);
        transaction.commit();
        session.close();
    }

    /* (non-Javadoc)
     * @see br.com.caioribeiro.produto.persist.dao.GenericoDAO#search(java.lang.String)
     */
    @Override
    public List<Funcionario> search(String nome) {
        return (List<Funcionario>) this.session.createCriteria(Tratamento.class).add(Restrictions.ilike("nome", nome, MatchMode.ANYWHERE));
        
    }
}
