package br.com.nutriscare.nutrisCareRulesApi.entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "t_meal")
@AllArgsConstructor
@NoArgsConstructor
public class Meal {

    @Id
    private String id;

    private String name;
    private Double totalCaloriesPerCent;
    private Double totalCalories;
    private Double carbsGrams;
    private Double proteinGrams;
    private Double fatGrams;
    private List<Food> foodItems;

    public Meal(String name, Double totalCaloriesPerCent) {
        this.name = name;
        this.totalCaloriesPerCent = totalCaloriesPerCent;
    }
}
