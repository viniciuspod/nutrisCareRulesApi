package br.com.nutriscare.nutrisCareRulesApi.service;

import br.com.nutriscare.nutrisCareRulesApi.builder.HealthUsuBuilder;
import br.com.nutriscare.nutrisCareRulesApi.dto.HealthUsuDTO;
import br.com.nutriscare.nutrisCareRulesApi.entity.HealthUsu;
import br.com.nutriscare.nutrisCareRulesApi.entity.User;
import br.com.nutriscare.nutrisCareRulesApi.repository.HealthUsuRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class HealthUsuService {

    @Autowired
    private UserService userService;

    @Autowired
    private HealthUsuRepository healthUsuRepository;

    private final HealthUsuBuilder healthUsuBuilder = new HealthUsuBuilder();

    public HealthUsu saveHealthUsu(HealthUsuDTO healthUsuDTO){
        try{
            User user = getUserById(healthUsuDTO.getUserId());
            HealthUsu healthUsu = healthUsuRepository.save(
                    healthUsuBuilder.buildHealthUsu(healthUsuDTO,user));
            userService.editHealthUsu(healthUsuDTO.getUserId(),healthUsu);
            return healthUsu;
        } catch (Exception e) {
            log.info("ERROR to save HealthUsu" + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private User getUserById(String id) {
        try {
            return userService.getUserById(id);
        } catch (Exception e) {
            log.info("ERROR to get User" + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public HealthUsu getHealthUsu(String id) {
        try {
            return healthUsuRepository.findById(id).orElse(new HealthUsu());
        } catch (Exception e) {
            log.info("ERROR to get HealthUsu" + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public HealthUsu updateHealthUsu(String id, HealthUsuDTO healthUsuDTO) {
        try {
            HealthUsu healthUsu = getHealthUsu(id);
            updateHealthUsuFromDTO(healthUsu, healthUsuDTO);
            return healthUsuRepository.save(healthUsu);
        } catch (Exception e) {
            log.info("ERROR to update HealthUsu" + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private void updateHealthUsuFromDTO(HealthUsu healthUsu, HealthUsuDTO healthUsuDTO) {
        if (healthUsuDTO.getBloodPressure() != null) {
            healthUsu.setBloodPressure(healthUsuDTO.getBloodPressure());
        }
        if (healthUsuDTO.getCholesterolLevel() != null) {
            healthUsu.setCholesterolLevel(healthUsuDTO.getCholesterolLevel());
        }
        if (healthUsuDTO.getGlucoseLevel() != null) {
            healthUsu.setGlucoseLevel(healthUsuDTO.getGlucoseLevel());
        }
        if (healthUsuDTO.getMedicalConsultationHistory() != null) {
            healthUsu.setMedicalConsultationHistory(healthUsuDTO.getMedicalConsultationHistory());
        }
        if (healthUsuDTO.getFoodAllergies() != null) {
            healthUsu.setFoodAllergies(healthUsuDTO.getFoodAllergies());
        }
        if (healthUsuDTO.getSupplementation() != null) {
            healthUsu.setSupplementation(healthUsuDTO.getSupplementation());
        }
        if (healthUsuDTO.getMedications() != null) {
            healthUsu.setMedications(healthUsuDTO.getMedications());
        }
        if (healthUsuDTO.getPreviousSurgeries() != null) {
            healthUsu.setPreviousSurgeries(healthUsuDTO.getPreviousSurgeries());
        }
    }

    public void deleteHealthUsu(String id) {
        try {
            healthUsuRepository.deleteById(id);
        } catch (Exception e) {
            log.info("ERROR to delete HealthUsu" + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}