package br.com.nutriscare.nutrisCareRulesApi.dto;

import lombok.Data;

import java.util.List;
@Data
public class HealthUsuDTO {

    private Long userId;
    private Integer bloodPressure;
    private Double cholesterolLevel;
    private Double glucoseLevel;
    private List<String> medicalConsultationHistory;
    private List<String> foodAllergies;
    private List<String> supplementation;
    private List<String> medications;
    private List<String> previousSurgeries;
}
