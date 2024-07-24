package br.com.nutriscare.nutrisCareRulesApi.repository;

import br.com.nutriscare.nutrisCareRulesApi.entity.Meal;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealRepository extends MongoRepository<Meal, String>{
}
