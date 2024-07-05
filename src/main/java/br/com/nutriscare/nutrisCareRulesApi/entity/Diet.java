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
    private Long id;

    private List<Food> foods;
}
