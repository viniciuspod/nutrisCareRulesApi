package br.com.nutriscare.nutrisCareRulesApi.controller;

import br.com.nutriscare.nutrisCareRulesApi.dto.HealthUsuDTO;
import br.com.nutriscare.nutrisCareRulesApi.entity.HealthUsu;
import br.com.nutriscare.nutrisCareRulesApi.service.HealthUsuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController(value = "/healthUsu")
@Slf4j
public class HealthUsuController {

    @Autowired
    private HealthUsuService healthUsuService;

    @PostMapping(path = "/save")
    public ResponseEntity<?> saveHealthUsu(@RequestBody HealthUsuDTO healthUsuDTO){
        try {
            HealthUsu healthUsu = healthUsuService.saveHealthUsu(healthUsuDTO);
            return ResponseEntity.ok().body(healthUsu);
        } catch (Exception e) {
            log.info("Error to save healthUsu", e);
            return ResponseEntity.badRequest().body("Error to save healthUsu");
        }
    }

    @GetMapping(path = "/get")
    public ResponseEntity<?> getHealthUsu(@RequestParam Long id){
        try {
            HealthUsu healthUsu = healthUsuService.getHealthUsu(id);
            return ResponseEntity.ok().body(healthUsu);
        } catch (Exception e) {
            log.info("Error to get healthUsu", e);
            return ResponseEntity.badRequest().body("Error to get healthUsu");
        }
    }

    @PutMapping(path = "/update")
    public ResponseEntity<?> updateHealthUsu(@RequestParam Long id, @RequestBody HealthUsuDTO healthUsuDTO){
        try {
            HealthUsu healthUsu = healthUsuService.updateHealthUsu(id, healthUsuDTO);
            return ResponseEntity.ok().body(healthUsu);
        } catch (Exception e) {
            log.info("Error to update healthUsu", e);
            return ResponseEntity.badRequest().body("Error to update healthUsu");
        }
    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity<?> deleteHealthUsu(@RequestParam Long id){
        try {
            healthUsuService.deleteHealthUsu(id);
            return ResponseEntity.ok().body("HealthUsu deleted");
        } catch (Exception e) {
            log.info("Error to delete healthUsu", e);
            return ResponseEntity.badRequest().body("Error to delete healthUsu");
        }
    }
}
