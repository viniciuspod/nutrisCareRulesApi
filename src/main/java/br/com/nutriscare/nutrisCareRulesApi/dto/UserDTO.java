package br.com.nutriscare.nutrisCareRulesApi.dto;

import br.com.nutriscare.nutrisCareRulesApi.entity.HealthUsu;
import br.com.nutriscare.nutrisCareRulesApi.entity.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class UserDTO {

    @NotBlank
    private String name;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthDate;

    @NotBlank
    private String gender;

    @NotBlank
    private String password;

    private Double height;
    private Double weight;
    private Double levelGoals;
    private Double levelPhysicalActivityLevel;
}
