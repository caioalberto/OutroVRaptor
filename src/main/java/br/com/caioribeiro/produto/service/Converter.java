package br.com.caioribeiro.produto.service;

import org.joda.time.LocalDate;

public final class Converter {

    private Converter(){}
    
    public static LocalDate convertStringToLocalDate(String data) {
        LocalDate dataConvertida = new LocalDate();
   
        LocalDate.parse(data);
        
        return dataConvertida;
    }
}
