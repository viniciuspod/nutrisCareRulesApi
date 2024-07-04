package br.com.nutriscare.nutrisCareRulesApi.controller;

import br.com.nutriscare.nutrisCareRulesApi.entity.Food;
import br.com.nutriscare.nutrisCareRulesApi.service.FoodService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController(value = "/food")
@Slf4j
public class FoodController {

    @Autowired
    private FoodService foodService;

    @GetMapping(path = "/get/food/all")
    public ResponseEntity<?> findAllAlimentos(){
        try {
            List<Food> foods = foodService.findAllFoods();
            return ResponseEntity.ok().body(foods);
        }catch (Exception e){
            log.info("Error to search foods", e);
            return ResponseEntity.badRequest().body("Error to search foods");
        }
    }

    @GetMapping(path = "/get/food")
    public ResponseEntity<?> findAlimentosById(@RequestParam Long id){
        try {
            Food food = foodService.findFoodById(id);
            return ResponseEntity.ok().body(food);
        }catch (Exception e){
            log.info("Error to search foods", e);
            return ResponseEntity.badRequest().body("Erro to search food by id");
        }
    }
}