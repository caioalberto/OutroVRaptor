package br.mackenzie.ec.lp2.websalao.service;

import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.ioc.Component;
import br.mackenzie.ec.lp2.websalao.model.Tratamento;
import br.mackenzie.ec.lp2.websalao.persist.dao.AgendaDAO;

/**
 * The Class TratamentoValidator.
 */
@Component
public class TratamentoValidator {

    /** The tratamento. */
    private Tratamento tratamento;

    /** The agenda dao. */
    private AgendaDAO agendaDao;

    /** The validator. */
    private final Validator validator;

    /**
     * Instantiates a new tratamento validator.
     *
     * @param validator the validator
     * @param tratamento the tratamento
     * @param agendaDao the agenda dao
     */
    public TratamentoValidator(Validator validator, Tratamento tratamento, AgendaDAO agendaDao) {

        this.tratamento = tratamento;
        this.validator = validator;
        this.agendaDao = agendaDao;
    }

    /**
     * Validate.
     *
     * @param tratamento the tratamento
     */
    public void validate(Tratamento tratamento) {

        validator.validate(tratamento);

    }

    /**
     * On error redirect to.
     *
     * @param <T> the generic type
     * @param controller the controller
     * @return the t
     */
    public <T> T onErrorRedirectTo(T controller) {
        return validator.onErrorRedirectTo(controller);
    }

}
