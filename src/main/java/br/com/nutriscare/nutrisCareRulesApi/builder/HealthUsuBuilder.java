package br.com.nutriscare.nutrisCareRulesApi.builder;

import br.com.nutriscare.nutrisCareRulesApi.Helper.ObjectHelper;
import br.com.nutriscare.nutrisCareRulesApi.dto.HealthUsuDTO;
import br.com.nutriscare.nutrisCareRulesApi.entity.HealthUsu;

public class HealthUsuBuilder {

    private final ObjectHelper objectHelper = new ObjectHelper();

    public HealthUsu buildHealthUsu(HealthUsuDTO healthUsuDTO, Double Bmi){
        return HealthUsu.builder()
                .bloodPressure(healthUsuDTO.getBloodPressure())
                .cholesterolLevel(healthUsuDTO.getCholesterolLevel())
                .glucoseLevel(healthUsuDTO.getGlucoseLevel())
                .bmi(Bmi)
                .medicalConsultationHistory(healthUsuDTO.getMedicalConsultationHistory())
                .foodAllergies(healthUsuDTO.getFoodAllergies())
                .supplementation(healthUsuDTO.getSupplementation())
                .medications(healthUsuDTO.getMedications())
                .previousSurgeries(healthUsuDTO.getPreviousSurgeries())
                .build();
    }
}
