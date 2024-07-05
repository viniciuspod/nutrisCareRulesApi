package br.com.nutriscare.nutrisCareRulesApi.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Document(collection = "t_user")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    private String id;

    private String name;
    private String email;
    private LocalDate birthDate;
    private String gender;
    private Double height;
    private Double weight;
    private Double levelGoals;
    private Double levelPhysicalActivityLevel;
    private String password;
    private HealthUsu healthUsu;
}
