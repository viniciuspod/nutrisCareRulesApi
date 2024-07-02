package br.com.nutriscare.nutrisCareRulesApi.controller;

import br.com.nutriscare.nutrisCareRulesApi.entity.Alimentos;
import br.com.nutriscare.nutrisCareRulesApi.service.AlimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController(value = "/alimentos")
public class AlimentoController {

    @Autowired
    private AlimentoService alimentoService;

    @GetMapping(path = "/get/alimento/all")
    public ResponseEntity<?> findAllAlimentos(){
        try {
            List<Alimentos> alimentos = alimentoService.findAllAlimentos();
            return ResponseEntity.ok().body(alimentos);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Erro ao buscar alimentos");
        }
    }

    @GetMapping(path = "/get/alimento/id")
    public ResponseEntity<?> findAlimentosById(@RequestParam Long id){
        try {
            Alimentos alimento = alimentoService.findAlimentoById(id);
            return ResponseEntity.ok().body(alimento);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Erro ao buscar alimentos");
        }
    }
}
