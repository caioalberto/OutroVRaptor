package br.com.caioribeiro.produto.persist.dao;

import static br.com.caioribeiro.produto.service.TratamentoService.dataFormatter;
import static br.com.caioribeiro.produto.service.TratamentoService.verifyTratamentoDia;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caioribeiro.produto.model.Tratamento;

/**
 * The Class AgendaDAO.
 */
@Component
public class AgendaDAO {

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

    /**
     * Save.
     *
     * @param tratamento the tratamento
     */
    public void save(Tratamento tratamento) {
        transaction = session.beginTransaction();
        dataFormatter(tratamento);
        verifyTratamentoDia(tratamento);
        //TratamentoService.convertStringToLocalTime(tratamento.getHoraInicio());
        //TratamentoService.convertStringToLocalTime(tratamento.getHoraFim());
        session.merge(tratamento);
        transaction.commit();
        session.close();

    }

    /**
     * List tratamentos.
     *
     * @return the list
     */
    @SuppressWarnings("unchecked")
    public List<Tratamento> listTratamentos() {
        return this.session.createCriteria(Tratamento.class).list();
    }

}
