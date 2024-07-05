package br.com.nutriscare.nutrisCareRulesApi.service;

import br.com.nutriscare.nutrisCareRulesApi.entity.Diet;
import br.com.nutriscare.nutrisCareRulesApi.repository.DietRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DietService {

    @Autowired
    private DietRepository dietRepository;

    public Diet buildDieta(){
        try {
            return null;
        } catch (Exception e) {
            log.info("ERROR to build diet" + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
