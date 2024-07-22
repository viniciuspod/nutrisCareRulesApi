package br.com.nutriscare.nutrisCareRulesApi.builder;

import br.com.nutriscare.nutrisCareRulesApi.entity.User;
import br.com.nutriscare.nutrisCareRulesApi.helper.ObjectHelper;
import br.com.nutriscare.nutrisCareRulesApi.dto.HealthUsuDTO;
import br.com.nutriscare.nutrisCareRulesApi.entity.HealthUsu;
import br.com.nutriscare.nutrisCareRulesApi.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class HealthUsuBuilder {

    @Autowired
    private UserService userService;

    private final ObjectHelper objectHelper = new ObjectHelper();

    public HealthUsu buildHealthUsu(HealthUsuDTO healthUsuDTO){
        return HealthUsu.builder()
                .bloodPressure(healthUsuDTO.getBloodPressure())
                .cholesterolLevel(healthUsuDTO.getCholesterolLevel())
                .glucoseLevel(healthUsuDTO.getGlucoseLevel())
                .bmi(calculateBMI(healthUsuDTO.getUserId()))
                .bmr(calculateBMR(healthUsuDTO.getUserId()))
                .medicalConsultationHistory(healthUsuDTO.getMedicalConsultationHistory())
                .foodAllergies(healthUsuDTO.getFoodAllergies())
                .supplementation(healthUsuDTO.getSupplementation())
                .medications(healthUsuDTO.getMedications())
                .previousSurgeries(healthUsuDTO.getPreviousSurgeries())
                .build();
    }

    private Double calculateBMI(String userId) {
        try {
            User user = getUserById(userId);
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

    private Double calculateBMR(String userId) {
        try {
            User user = getUserById(userId);
            Double height = user.getHeight() * 100;
            Double weight = user.getWeight();
            String gender = user.getGender();
            Integer years = objectHelper.calculateYears(user.getBirthDate());

            Double bmr;
            if (gender.equalsIgnoreCase("M")) {
                bmr = 88.362 + (13.397 * weight) + (4.799 * height) - (5.677 * years);
            } else {
                bmr = 447.593 + (9.247 * weight) + (3.098 * height) - (4.330 * years);
            }
            return bmr;
        } catch (Exception e) {
            log.info("ERROR to calculate BMR" + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private User getUserById(String id) {
        return userService.getUserById(id);
    }
}
