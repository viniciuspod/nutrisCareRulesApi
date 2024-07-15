package br.com.nutriscare.nutrisCareRulesApi.helper;

import java.time.LocalDate;

public class ObjectHelper {

    public Object verifyObject(Object object){
        if(object == null){
            return null;
        }
        return object;
    }

    public Integer calculateYears(LocalDate birthDate) {
        return LocalDate.now().getYear() - birthDate.getYear();
    }
}
