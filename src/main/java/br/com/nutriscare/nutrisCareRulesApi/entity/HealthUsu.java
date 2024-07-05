package br.com.nutriscare.nutrisCareRulesApi.entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "t_healthUsu")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HealthUsu {

    @Id
    private Long id;

    private int bloodPressure;
    private double cholesterolLevel;
    private double glucoseLevel;
    private Double bmi;
    private List<String> medicalConsultationHistory;
    private List<String> foodAllergies;
    private List<String> supplementation;
    private List<String> medications;
    private List<String> previousSurgeries;
}
