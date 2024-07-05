package br.com.nutriscare.nutrisCareRulesApi.builder;

import br.com.nutriscare.nutrisCareRulesApi.dto.UserDTO;
import br.com.nutriscare.nutrisCareRulesApi.entity.User;

public class UserBuilder {

    public User buildUser(UserDTO userDTO) {
        return User.builder()
                .name(userDTO.getName())
                .email(userDTO.getEmail())
                .birthDate(userDTO.getBirthDate())
                .gender(userDTO.getGender())
                .height(userDTO.getHeight())
                .weight(userDTO.getWeight())
                .password(userDTO.getPassword())
                .build();
    }
}
