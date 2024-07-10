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
    private List<Food> foodItems;
}
