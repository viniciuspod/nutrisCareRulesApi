package br.com.nutriscare.nutrisCareRulesApi.controller;

import br.com.nutriscare.nutrisCareRulesApi.service.CsvImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/csv-import-food")
public class CsvImportFoodController {

    @Autowired
    private CsvImportService csvImportService;

    @PostMapping(path = "/import")
    public ResponseEntity<?> importCsv(){
        try{
            csvImportService.importCsv();
            return ResponseEntity.ok().body("CSV imported");
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Error importing CSV" + e.getMessage());
        }
    }
}
