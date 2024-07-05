package br.com.nutriscare.nutrisCareRulesApi.config;

import br.com.nutriscare.nutrisCareRulesApi.service.CsvImportService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStartupRunner {

    @Autowired
    private CsvImportService csvImportService;

    @PostConstruct
    public void init() {
        csvImportService.importCsv("C:\\NUTRISCARE\\alimentos.csv");
    }
}
