package br.com.nutriscare.nutrisCareRulesApi.repository;

import br.com.nutriscare.nutrisCareRulesApi.entity.HealthUsu;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HealthUsuRepository extends MongoRepository<HealthUsu, Long> {
}
