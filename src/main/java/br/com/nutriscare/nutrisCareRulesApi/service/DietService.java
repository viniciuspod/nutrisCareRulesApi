package br.com.nutriscare.nutrisCareRulesApi.service;

import br.com.nutriscare.nutrisCareRulesApi.entity.Diet;
import br.com.nutriscare.nutrisCareRulesApi.entity.User;
import br.com.nutriscare.nutrisCareRulesApi.repository.DietRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DietService {

    @Autowired
    private DietRepository dietRepository;

    public Diet buildDiet(User user){
        try {
            // formula da normalização x = x-min/max-min
            double normalizedBMI = (user.getHealthUsu().getBmi() - 18.5) / (24.9 - 18.5);
            double normalizedGoalLevel = (user.getLevelGoals() - 1.0) / (3.0 - 1.0);
            double normalizedActivityLevel = (user.getLevelPhysicalActivityLevel() - 1.0) / (3.0 - 1.0);

            double goalWeight = 0.3;
            double activityWeight = 0.3;
            double bmiWeight = 0.4;

            double score = (normalizedGoalLevel * goalWeight) +
                    (normalizedActivityLevel * activityWeight) +
                    (normalizedBMI * bmiWeight);

            if (score > 0.7) {
                log.info("Recomendamos uma dieta de baixa caloria com alta atividade física.");
            } else if (score > 0.4) {
                log.info("Recomendamos uma dieta balanceada com atividade física moderada.");
            } else {
                log.info("Recomendamos uma dieta de manutenção com atividade física leve.");
            }

            return null;
        } catch (Exception e) {
            log.info("ERROR to build diet" + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
