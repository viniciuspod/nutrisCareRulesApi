package br.com.nutriscare.nutrisCareRulesApi.builder;

import br.com.nutriscare.nutrisCareRulesApi.entity.User;
import br.com.nutriscare.nutrisCareRulesApi.helper.ObjectHelper;
import br.com.nutriscare.nutrisCareRulesApi.dto.HealthUsuDTO;
import br.com.nutriscare.nutrisCareRulesApi.entity.HealthUsu;
import br.com.nutriscare.nutrisCareRulesApi.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
public class HealthUsuBuilder {

    private final ObjectHelper objectHelper = new ObjectHelper();

    public HealthUsu buildHealthUsu(HealthUsuDTO healthUsuDTO, User user){
        Double BMR = calculateBMR(user);
        return HealthUsu.builder()
                .bloodPressure(healthUsuDTO.getBloodPressure())
                .cholesterolLevel(healthUsuDTO.getCholesterolLevel())
                .glucoseLevel(healthUsuDTO.getGlucoseLevel())
                .bmi(calculateBMI(user))
                .bmr(BMR)
                .tdee(calculateTdee(BMR,user))
                .medicalConsultationHistory(healthUsuDTO.getMedicalConsultationHistory())
                .foodAllergies(healthUsuDTO.getFoodAllergies())
                .supplementation(healthUsuDTO.getSupplementation())
                .medications(healthUsuDTO.getMedications())
                .previousSurgeries(healthUsuDTO.getPreviousSurgeries())
                .build();
    }

    private Double calculateBMI(User user) {
        try {
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

    private Double calculateBMR(User user) {
        try {
            Double height = user.getHeight() * 100;
            Double weight = user.getWeight();
            String gender = user.getGender();
            Integer years = objectHelper.calculateYears(user.getBirthDate());

            Double bmr = (10 * weight) + (6.25 * height) - (5 * years);
            if (gender.equalsIgnoreCase("M")) {
                bmr += 5;
            } else {
                bmr -= 161;
            }
            return bmr;
        } catch (Exception e) {
            log.info("ERROR to calculate BMR" + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private Double calculateTdee(Double bmr, User user) {
        try {
            return switch (user.getLevelPhysicalActivityLevel()) {
                case 1 -> bmr * 1.2;
                case 2 -> bmr * 1.375;
                case 3 -> bmr * 1.55;
                case 4 -> bmr * 1.725;
                case 5 -> bmr * 1.9;
                default -> bmr * 0;
            };
        } catch (Exception e) {
            log.info("ERROR to calculate TDEE" + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
