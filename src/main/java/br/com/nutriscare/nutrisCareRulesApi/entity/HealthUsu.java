package br.com.nutriscare.nutrisCareRulesApi.entity;

import br.com.nutriscare.nutrisCareRulesApi.dto.HealthUsuDTO;
import br.com.nutriscare.nutrisCareRulesApi.helper.ObjectHelper;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@Document(collection = "t_healthUsu")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HealthUsu {

    @Id
    private String id;

    private Integer bloodPressure;
    private Double cholesterolLevel;
    private Double glucoseLevel;
    private Double bmi;
    private Double bmr;
    private Double tdee;
    private List<String> medicalConsultationHistory;
    private List<String> foodAllergies;
    private List<String> supplementation;
    private List<String> medications;
    private List<String> previousSurgeries;
}
