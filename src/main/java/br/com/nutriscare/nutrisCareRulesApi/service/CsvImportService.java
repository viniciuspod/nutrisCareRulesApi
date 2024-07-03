package br.com.nutriscare.nutrisCareRulesApi.service;

import br.com.nutriscare.nutrisCareRulesApi.entity.Alimentos;
import br.com.nutriscare.nutrisCareRulesApi.repository.AlimentosRepository;
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
    private AlimentosRepository alimentosRepository;

    public void importCsv(String path){
        try {
            FileReader fileReader = new FileReader(path);
            CSVParser parser = new CSVParserBuilder().withSeparator(';').build();
            CSVReader reader = new CSVReaderBuilder(fileReader)
                    .withCSVParser(parser)
                    .build();

            List<Alimentos> alimentosList = new ArrayList<>();
            String[] line;
            reader.readNext();
            while ((line = reader.readNext()) != null) {
                Alimentos alimentos = new Alimentos();
                alimentos.setId(Long.parseLong(line[0]));
                alimentos.setCategoria(line[1]);
                alimentos.setDescricao(line[2]);
                alimentos.setUmidadePerCent(parseDouble(line[3]));
                alimentos.setQuiloCalorias(parseDouble(line[4]));
                alimentos.setQuiloJoules(parseDouble(line[5]));
                alimentos.setProteinaGrama(parseDouble(line[6]));
                alimentos.setLipideosGrama(parseDouble(line[7]));
                alimentos.setColesterolMiliGrama(parseDouble(line[8]));
                alimentos.setCarboidratoGrama(parseDouble(line[9]));
                alimentos.setFibraAlimentarGrama(parseDouble(line[10]));
                alimentos.setCinzasGrama(parseDouble(line[11]));
                alimentos.setCalcioGrama(parseDouble(line[12]));
                alimentos.setMagnesioGrama(parseDouble(line[13]));
                alimentos.setManganesMiliGrama(parseDouble(line[14]));
                alimentos.setFosforoMiliGrama(parseDouble(line[15]));
                alimentos.setFerroMiliGrama(parseDouble(line[16]));
                alimentos.setSodioMiliGrama(parseDouble(line[17]));
                alimentos.setPotassioMiliGrama(parseDouble(line[18]));
                alimentos.setCobreMiliGrama(parseDouble(line[19]));
                alimentos.setZincoMiliGrama(parseDouble(line[20]));
                alimentos.setRetinolMicroGrama(parseDouble(line[21]));
                alimentos.setReMicroGrama(parseDouble(line[22]));
                alimentos.setRaeMicroGrama(parseDouble(line[23]));
                alimentos.setTiaminaMiliGrama(parseDouble(line[24]));
                alimentos.setRiboflavinaMiliGrama(parseDouble(line[25]));
                alimentos.setPiridoxinaMiliGrama(parseDouble(line[26]));
                alimentos.setNiacinaMiliGrama(parseDouble(line[27]));
                alimentos.setVitaminaCMiliGrama(parseDouble(line[28]));
                alimentosList.add(alimentos);
            }
            alimentosRepository.saveAll(alimentosList);
        } catch (FileNotFoundException e) {
            log.info("Arquivo CSV não encontrado");
            throw new RuntimeException(e);
        } catch (IOException e) {
            log.info("Erro ao ler arquivo CSV");
            throw new RuntimeException(e);
        } catch (CsvValidationException e) {
            log.info("Erro ao validar arquivo CSV");
            throw new RuntimeException(e);
        } catch (NumberFormatException e) {
            log.info("Erro ao converter valor numérico");
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

