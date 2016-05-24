package br.mackenzie.ec.lp2.websalao.converter;

import org.joda.time.LocalDate;

public final class DataConverter {

    private DataConverter(){}
    
    public static LocalDate convertStringToLocalDate(String data) {
        LocalDate dataConvertida = new LocalDate();
   
        LocalDate.parse(data);
        
        return dataConvertida;
    }
}
