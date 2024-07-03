package br.com.nutriscare.nutrisCareRulesApi.service;

import br.com.nutriscare.nutrisCareRulesApi.entity.Food;
import br.com.nutriscare.nutrisCareRulesApi.repository.FoodRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;

    public List<Food> findAllFoods(){
        try {
            return foodRepository.findAll();
        } catch (DataAccessException e) {
            log.info("Error to search foods" + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public Food findFoodById(Long id){
        try {
            return foodRepository.findById(id).orElse(new Food());
        } catch (DataAccessException e) {
            log.info("Error to search food" + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
