package br.com.nutriscare.nutrisCareRulesApi.controller;

import br.com.nutriscare.nutrisCareRulesApi.entity.Diet;
import br.com.nutriscare.nutrisCareRulesApi.entity.Food;
import br.com.nutriscare.nutrisCareRulesApi.service.DietService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/diet")
@Slf4j
public class DietController {

    @Autowired
    private DietService dietService;

    @PostMapping(path = "/build")
    public ResponseEntity<?> buildDiet(String userId){
        try {
            Diet diet  = dietService.buildDiet(userId);
            return ResponseEntity.ok().body(diet);
        }catch (Exception e){
            log.info("Error to search foods", e);
            return ResponseEntity.badRequest().body("Error to build a diet");
        }
    }
}
