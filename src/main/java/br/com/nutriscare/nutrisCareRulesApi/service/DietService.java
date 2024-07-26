package br.com.nutriscare.nutrisCareRulesApi.service;

import br.com.nutriscare.nutrisCareRulesApi.entity.Diet;
import br.com.nutriscare.nutrisCareRulesApi.entity.User;
import br.com.nutriscare.nutrisCareRulesApi.repository.DietRepository;
import lombok.extern.slf4j.Slf4j;
import org.drools.core.definitions.impl.KnowledgePackageImpl;
import org.kie.api.KieServices;
import org.kie.api.definition.KiePackage;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Slf4j
public class DietService {

    @Autowired
    private DietRepository dietRepository;

    @Autowired
    private MealService mealService;

    @Autowired
    private UserService userService;


    public Diet buildDiet(String userId){
        try {
            User user = getUser(userId);
            double score = getScoreNormalized(user);

            KieSession kieSession = getKieSessionForScore(score);
            kieSession.insert(user);
            kieSession.fireAllRules();

            Diet diet = (Diet) kieSession.getObjects().stream()
                    .filter(obj -> obj instanceof Diet)
                    .findFirst()
                    .orElse(null);

            kieSession.dispose();

            return saveDiet(diet);
        } catch (Exception e) {
            log.info("ERROR to build diet" + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private KieSession getKieSessionForScore(double score) {
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        if (score > 0.67) {
            return kContainer.newKieSession("ksession-highScore");
        } else if (score > 0.34) {
            return kContainer.newKieSession("ksession-mediumScore");
        } else {
            return kContainer.newKieSession("ksession-lowScore");
        }
    }

    private double getScoreNormalized(User user){
        double normalizedBMI = (24.9 - user.getHealthUsu().getBmi()) / (24.9 - 18.5);
        double normalizedGoalLevel = (user.getLevelGoals() - 1.0) / (3.0 - 1.0);
        double normalizedActivityLevel = (user.getLevelPhysicalActivityLevel() - 1.0) / (5.0 - 1.0);

        double goalWeight = 0.3;
        double activityWeight = 0.3;
        double bmiWeight = 0.4;

        return (normalizedGoalLevel * goalWeight) +
                (normalizedActivityLevel * activityWeight) +
                (normalizedBMI * bmiWeight);
    }

    private Diet saveDiet(Diet diet){
        try {
            mealService.saveAllMeals(diet.getMeals());
            return dietRepository.save(diet);
        } catch (Exception e) {
            log.info("ERROR to save diet" + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private User getUser(String userId){
        return userService.getUserById(userId);
    }

    public static void distributeCalories(Diet diet){
        Double totalCalories = diet.getTotalCalories();
        Double carbPercentage = diet.getCarboPercentage();
        Double proteinPercentage = diet.getProteinPercentage();
        Double fatPercentage = diet.getLipidPercentage();

        diet.getMeals().forEach(meal -> {
            Double mealCalories = totalCalories * meal.getTotalCaloriesPerCent();
            meal.setTotalCalories(mealCalories);
            meal.setCarbsGrams(mealCalories * carbPercentage / 4);
            meal.setProteinGrams(mealCalories * proteinPercentage / 4);
            meal.setFatGrams(mealCalories * fatPercentage / 9);
        });
    }
}
