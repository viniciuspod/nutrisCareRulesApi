package br.com.nutriscare.nutrisCareRulesApi.service;

import br.com.nutriscare.nutrisCareRulesApi.builder.UserBuilder;
import br.com.nutriscare.nutrisCareRulesApi.dto.UserDTO;
import br.com.nutriscare.nutrisCareRulesApi.entity.HealthUsu;
import br.com.nutriscare.nutrisCareRulesApi.entity.User;
import br.com.nutriscare.nutrisCareRulesApi.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private final UserBuilder userBuilder = new UserBuilder();

    public User saveUser(UserDTO userDTO){
        try{
            return userRepository.save(userBuilder.buildUser(userDTO));
        }catch (DataAccessException e){
            log.info("ERROR to save user" + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public User editUser(String id, UserDTO userDTO){
        try{
            User user = getUserById(id);
            updateUserFromDTO(user, userDTO);
            return userRepository.save(user);
        }catch (DataAccessException e){
            log.info("ERROR to edit user" + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private void updateUserFromDTO(User user, UserDTO userDTO) {
        if (userDTO.getName() != null) {
            user.setName(userDTO.getName());
        }
        if (userDTO.getEmail() != null) {
            user.setEmail(userDTO.getEmail());
        }
        if (userDTO.getBirthDate() != null) {
            user.setBirthDate(userDTO.getBirthDate());
        }
        if (userDTO.getGender() != null) {
            user.setGender(userDTO.getGender());
        }
        if (userDTO.getHeight() != null) {
            user.setHeight(userDTO.getHeight());
        }
        if (userDTO.getWeight() != null) {
            user.setWeight(userDTO.getWeight());
        }
        if (userDTO.getLevelGoals() != null) {
            user.setLevelGoals(userDTO.getLevelGoals());
        }
        if (userDTO.getLevelPhysicalActivityLevel() != null) {
            user.setLevelPhysicalActivityLevel(userDTO.getLevelPhysicalActivityLevel());
        }
    }

    public void editHealthUsu(String id, HealthUsu healthUsu){
        try{
            User user = getUserById(id);
            user.setHealthUsu(healthUsu);
            userRepository.save(user);
        }catch (DataAccessException e){
            log.info("ERROR to edit healthUsu" + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void deleteUser(String id){
        try{
            userRepository.deleteById(id);
        }catch (DataAccessException e){
            log.info("ERROR to delete user" + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public User getUserById(String id){
        try{
            return userRepository.findById(id).orElse(new User());
        }catch (DataAccessException e){
            log.info("ERROR to get user by id" + e.getMessage());
            throw new RuntimeException(e);
        }

    }
}
