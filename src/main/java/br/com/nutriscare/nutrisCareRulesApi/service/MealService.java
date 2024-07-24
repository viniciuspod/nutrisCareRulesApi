package br.com.nutriscare.nutrisCareRulesApi.service;

import br.com.nutriscare.nutrisCareRulesApi.entity.Meal;
import br.com.nutriscare.nutrisCareRulesApi.repository.MealRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MealService {

    @Autowired
    private MealRepository mealRepository;

    public Meal saveMeal(Meal meal){
        try {
            return mealRepository.save(meal);
        } catch (Exception e) {
            log.info("ERROR to save meal" + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public Meal getMeal(String mealId){
        try {
            return mealRepository.findById(mealId).orElse(null);
        } catch (Exception e) {
            log.info("ERROR to get meal" + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public Meal updateMeal(Meal meal){
        try {
            return mealRepository.save(meal);
        } catch (Exception e) {
            log.info("ERROR to update meal" + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void deleteMeal(String mealId){
        try {
            mealRepository.deleteById(mealId);
        } catch (Exception e) {
            log.info("ERROR to delete meal" + e.getMessage());
            throw new RuntimeException(e);
        }
    }

}
