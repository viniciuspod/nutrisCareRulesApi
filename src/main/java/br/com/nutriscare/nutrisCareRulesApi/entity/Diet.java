package br.com.nutriscare.nutrisCareRulesApi.entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "t_diet")
@AllArgsConstructor
@NoArgsConstructor
public class Diet {

    @Id
    private String id;

    private String usuId;

    private String observation;

    private Double totalCalories;

    private Double proteinPercentage;

    private Double carboPercentage;

    private Double lipidPercentage;

    private List<Meal> meals;

    private List<String> forbiddenFoods;
}
