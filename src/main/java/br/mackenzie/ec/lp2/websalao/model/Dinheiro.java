package br.mackenzie.ec.lp2.websalao.model;

import java.math.BigDecimal;

import br.mackenzie.ec.lp2.websalao.model.enums.Moeda;

public class Dinheiro {

    private Moeda moeda;
    
    private BigDecimal montante;

    public Dinheiro(Moeda moeda, BigDecimal montante) {
        this.moeda = moeda;
        this.montante = montante;
    }

    @Override
    public String toString() {
        return String.format("Dinheiro(%s, %s)", moeda.getSimbolo());
    }
    
    
    
}
