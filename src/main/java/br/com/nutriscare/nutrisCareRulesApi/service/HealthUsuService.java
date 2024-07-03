package br.com.nutriscare.nutrisCareRulesApi.service;

import br.com.nutriscare.nutrisCareRulesApi.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class HealthUsuService {

    @Autowired
    private UserService userService;

    public Double calculateBMI(Long id) {
        try {
            User user = getUserById(id);
            Double height = user.getHeight();
            Double weight = user.getWeight();
            if (height <= 0 || weight <= 0) {
                throw new IllegalArgumentException("Height and Weight must be greater than 0.");
            }
            return weight / (height * height);
        } catch (Exception e) {
            log.info("ERROR to calculate BMI" + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private User getUserById(Long id) {
        return userService.getUserById(id);
    }
}