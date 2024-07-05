package br.com.nutriscare.nutrisCareRulesApi.dto;

import br.com.nutriscare.nutrisCareRulesApi.entity.HealthUsu;
import br.com.nutriscare.nutrisCareRulesApi.entity.User;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class UserDTO {

    private String name;
    private String email;
    private LocalDateTime birthDate;
    private String gender;
    private Double height;
    private Double weight;
    private String password;
    private List<String> goals;
    private List<String> physicalActivityLevel;
}
