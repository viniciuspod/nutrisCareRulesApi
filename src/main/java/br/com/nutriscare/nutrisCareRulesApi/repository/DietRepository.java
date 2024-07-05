package br.com.nutriscare.nutrisCareRulesApi.repository;

import br.com.nutriscare.nutrisCareRulesApi.entity.Diet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DietRepository extends MongoRepository<Diet, Long>{
}
