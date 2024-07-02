package br.com.nutriscare.nutrisCareRulesApi.repository;

import br.com.nutriscare.nutrisCareRulesApi.entity.Alimentos;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlimentosRepository extends MongoRepository<Alimentos, Long> {
}
