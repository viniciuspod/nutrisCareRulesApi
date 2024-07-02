package br.com.nutriscare.nutrisCareRulesApi.service;

import br.com.nutriscare.nutrisCareRulesApi.entity.Alimentos;
import br.com.nutriscare.nutrisCareRulesApi.repository.AlimentosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlimentoService {

    @Autowired
    private AlimentosRepository alimentosRepository;

    public List<Alimentos> findAllAlimentos(){
        try {
            return alimentosRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public Alimentos findAlimentoById(Long id){
        try {
            return alimentosRepository.findById(id).orElse(new Alimentos());
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
