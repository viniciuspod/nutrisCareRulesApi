package br.com.nutriscare.nutrisCareRulesApi.entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "t_food")
@AllArgsConstructor
@NoArgsConstructor
public class Food {

    @Id
    private String id;

    private String category;
    private String description;
    private Double moisturePercent;
    private Double kilocalories;
    private Double kilojoules;
    private Double proteinGrams;
    private Double lipidsGrams;
    private Double cholesterolMilligrams;
    private Double carbohydratesGrams;
    private Double dietaryFiberGrams;
    private Double ashGrams;
    private Double calciumGrams;
    private Double magnesiumGrams;
    private Double manganeseMilligrams;
    private Double phosphorusMilligrams;
    private Double ironMilligrams;
    private Double sodiumMilligrams;
    private Double potassiumMilligrams;
    private Double copperMilligrams;
    private Double zincMilligrams;
    private Double retinolMicrograms;
    private Double reMicrograms;
    private Double raeMicrograms;
    private Double thiamineMilligrams;
    private Double riboflavinMilligrams;
    private Double pyridoxineMilligrams;
    private Double niacinMilligrams;
    private Double vitaminCMilligrams;
}
