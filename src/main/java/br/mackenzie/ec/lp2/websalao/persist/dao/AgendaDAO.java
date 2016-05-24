package br.mackenzie.ec.lp2.websalao.persist.dao;

import static br.mackenzie.ec.lp2.websalao.service.TratamentoService.dataFormatter;
import static br.mackenzie.ec.lp2.websalao.service.TratamentoService.verifyTratamentoDia;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.caelum.vraptor.ioc.Component;
import br.mackenzie.ec.lp2.websalao.model.Tratamento;

/**
 * The Class AgendaDAO.
 */
/**
 * @author Caio Ribeiro
 *
 */
@Component
public class AgendaDAO implements GenericoDAO<Tratamento> {

    /** The session. */
    private Session session;

    /** The transaction. */
    private Transaction transaction;

    /**
     * Instantiates a new agenda dao.
     *
     * @param session the session
     */
    public AgendaDAO(Session session) {
        this.session = session;
    }

    /* (non-Javadoc)
     * @see br.com.caioribeiro.produto.persist.dao.GenericoDAO#save(java.lang.Object)
     */
    public void save(Tratamento tratamento) {
        transaction = session.beginTransaction();
        dataFormatter(tratamento);
        verifyTratamentoDia(tratamento);
        session.merge(tratamento);
        transaction.commit();
        session.close();

    }

    /* (non-Javadoc)
     * @see br.com.caioribeiro.produto.persist.dao.GenericoDAO#listAll()
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Tratamento> listAll() {
        return this.session.createCriteria(Tratamento.class).list();
    }

    /* (non-Javadoc)
     * @see br.com.caioribeiro.produto.persist.dao.GenericoDAO#load(java.lang.Long)
     */
    @Override
    public Tratamento load(Long id) {
        return (Tratamento) this.session.get(Tratamento.class, id);
    }

    /* (non-Javadoc)
     * @see br.com.caioribeiro.produto.persist.dao.GenericoDAO#update(java.lang.Object)
     */
    @Override
    public void update(Tratamento tratamento) {
        // TODO Auto-generated method stub
    }

    /* (non-Javadoc)
     * @see br.com.caioribeiro.produto.persist.dao.GenericoDAO#delete(java.lang.Object)
     */
    @Override
    public void delete(Tratamento tratamento) {
        // TODO Auto-generated method stub
    }

    /* (non-Javadoc)
     * @see br.com.caioribeiro.produto.persist.dao.GenericoDAO#search(java.lang.String)
     */
    @Override
    public List<Tratamento> search(String campo) {
        // TODO Auto-generated method stub
        return null;
    }

}
