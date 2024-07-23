package br.com.nutriscare.nutrisCareRulesApi.service;

import br.com.nutriscare.nutrisCareRulesApi.entity.Diet;
import br.com.nutriscare.nutrisCareRulesApi.entity.User;
import br.com.nutriscare.nutrisCareRulesApi.repository.DietRepository;
import lombok.extern.slf4j.Slf4j;
import org.drools.core.definitions.impl.KnowledgePackageImpl;
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
    private UserService userService;

    @Autowired
    @Qualifier("getHighScoreSession")
    private KieSession highScoreSession;

    @Autowired
    @Qualifier("getMediumScoreSession")
    private KieSession mediumScoreSession;

    @Autowired
    @Qualifier("getLowScoreSession")
    private KieSession lowScoreSession;


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

            return diet;
        } catch (Exception e) {
            log.info("ERROR to build diet" + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private KieSession getKieSessionForScore(double score) {
        if (score > 0.67) {
            return highScoreSession;
        } else if (score > 0.34) {
            return mediumScoreSession;
        } else {
            return lowScoreSession;
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

    private User getUser(String userId){
        return userService.getUserById(userId);
    }
}
