package br.com.nutriscare.nutrisCareRulesApi.repository;

import br.com.nutriscare.nutrisCareRulesApi.entity.Food;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends MongoRepository<Food, Long> {
}
