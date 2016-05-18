package br.com.caioribeiro.produto.service;

import static java.util.Calendar.DAY_OF_WEEK;

import java.text.DateFormat;
import java.util.Date;

import org.hibernate.validator.internal.xml.FieldType;
import org.joda.time.LocalTime;

import br.com.caioribeiro.produto.model.Tratamento;
import sun.reflect.generics.tree.FieldTypeSignature;

/**
 * The Class TratamentoService.
 */
public class TratamentoService {

    /**
     * Verify tratamento dia.
     *
     * @param tratamento the tratamento
     */
    public static void verifyTratamentoDia(Tratamento tratamento) {
        if (tratamento.getData().get(DAY_OF_WEEK) == 2) {
            tratamento.setDiaNome("Segunda-Feira");
        } else if (tratamento.getData().get(DAY_OF_WEEK) == 3) {
            tratamento.setDiaNome("Terça-Feira");
        } else if (tratamento.getData().get(DAY_OF_WEEK) == 4) {
            tratamento.setDiaNome("Quarta-Feira");
        } else if (tratamento.getData().get(DAY_OF_WEEK) == 5) {
            tratamento.setDiaNome("Quinta-Feira");
        } else if (tratamento.getData().get(DAY_OF_WEEK) == 6) {
            tratamento.setDiaNome("Sexta-Feira");
        } else if (tratamento.getData().get(DAY_OF_WEEK) == 7) {
            tratamento.setDiaNome("Sábado");
        } else {
            tratamento.setDiaNome("Domingo");
        }
    }

    /**
     * Data formatter.
     *
     * @param tratamento the tratamento
     */
    public static void dataFormatter(Tratamento tratamento) {
        Date formatar = tratamento.getData().getTime();
        DateFormat formataData = DateFormat.getDateInstance();
        tratamento.setDataNome(formataData.format(formatar));
    }

    public static void convertStringToLocalTime(LocalTime hora) {
        // TODO Implementar método
    }
}
