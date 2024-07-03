package br.com.nutriscare.nutrisCareRulesApi.dto;

import br.com.nutriscare.nutrisCareRulesApi.entity.User;
import lombok.Data;

@Data
public class UserDTO {

    private User user;
    private String goals;
    private String objectives;
    private String routine;
    private String needs;
    private String preferredFoods;
}
