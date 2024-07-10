package br.com.nutriscare.nutrisCareRulesApi.service;

import br.com.nutriscare.nutrisCareRulesApi.entity.Food;
import br.com.nutriscare.nutrisCareRulesApi.repository.FoodRepository;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class CsvImportService {

    @Autowired
    private FoodRepository foodRepository;

    public void importCsv(){
        try {
            FileReader fileReader = new FileReader("C://NUTRISCARE//alimentos.csv");
            CSVParser parser = new CSVParserBuilder().withSeparator(';').build();
            CSVReader reader = new CSVReaderBuilder(fileReader)
                    .withCSVParser(parser)
                    .build();

            List<Food> foods = new ArrayList<>();
            String[] line;
            reader.readNext();
            while ((line = reader.readNext()) != null) {
                Food food = new Food();
                food.setCategory(line[1]);
                food.setDescription(line[2]);
                food.setMoisturePercent(parseDouble(line[3]));
                food.setKilocalories(parseDouble(line[4]));
                food.setKilojoules(parseDouble(line[5]));
                food.setProteinGrams(parseDouble(line[6]));
                food.setLipidsGrams(parseDouble(line[7]));
                food.setCholesterolMilligrams(parseDouble(line[8]));
                food.setCarbohydratesGrams(parseDouble(line[9]));
                food.setDietaryFiberGrams(parseDouble(line[10]));
                food.setAshGrams(parseDouble(line[11]));
                food.setCalciumGrams(parseDouble(line[12]));
                food.setMagnesiumGrams(parseDouble(line[13]));
                food.setManganeseMilligrams(parseDouble(line[14]));
                food.setPhosphorusMilligrams(parseDouble(line[15]));
                food.setIronMilligrams(parseDouble(line[16]));
                food.setSodiumMilligrams(parseDouble(line[17]));
                food.setPotassiumMilligrams(parseDouble(line[18]));
                food.setCopperMilligrams(parseDouble(line[19]));
                food.setZincMilligrams(parseDouble(line[20]));
                food.setRetinolMicrograms(parseDouble(line[21]));
                food.setReMicrograms(parseDouble(line[22]));
                food.setRaeMicrograms(parseDouble(line[23]));
                food.setThiamineMilligrams(parseDouble(line[24]));
                food.setRiboflavinMilligrams(parseDouble(line[25]));
                food.setPyridoxineMilligrams(parseDouble(line[26]));
                food.setNiacinMilligrams(parseDouble(line[27]));
                food.setVitaminCMilligrams(parseDouble(line[28]));
                foods.add(food);
            }
            foodRepository.saveAll(foods);
        } catch (FileNotFoundException e) {
            log.info("CSV file not found");
            throw new RuntimeException(e);
        } catch (IOException e) {
            log.info("Error reading CSV file");
            throw new RuntimeException(e);
        } catch (CsvValidationException e) {
            log.info("Error validating CSV file");
            throw new RuntimeException(e);
        } catch (NumberFormatException e) {
            log.info("Error converting numeric value");
            throw new RuntimeException(e);
        }
    }

    private Double parseDouble(String value) {
        try {
            return value == null || value.isEmpty() ? null : Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}

