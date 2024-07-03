package br.com.nutriscare.nutrisCareRulesApi.entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document(collection = "t_user")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private Long id;

    private String name;
    private String email;
    private LocalDateTime birthDate;
    private String gender;
    private Double height;
    private Double weight;
    private List<String> goals;
    private List<String> physicalActivityLevel;
    private String password;
    private HealthUsu healthUsu;
}
