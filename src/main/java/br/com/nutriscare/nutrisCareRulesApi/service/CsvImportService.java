package br.com.nutriscare.nutrisCareRulesApi.service;

import br.com.nutriscare.nutrisCareRulesApi.entity.Alimentos;
import br.com.nutriscare.nutrisCareRulesApi.repository.AlimentosRepository;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CsvImportService {

    @Autowired
    private AlimentosRepository alimentosRepository;

    public void importCsv(String path){
        try(CSVReader reader = new CSVReader(new FileReader(path))) {
            List<Alimentos> alimentosList = new ArrayList<>();
            String[] line;
            reader.readNext();
            while((line = reader.readNext()) != null){
                Alimentos alimentos = new Alimentos();
                alimentos.setId(Long.parseLong(line[0]));
                alimentos.setCategoria(line[1]);
                alimentos.setDescricao(line[2]);
                alimentos.setUmidadePerCent(Double.parseDouble(line[3]));
                alimentos.setQuiloCalorias(Double.parseDouble(line[4]));
                alimentos.setQuiloJoules(Double.parseDouble(line[5]));
                alimentos.setProteinaGrama(Double.parseDouble(line[6]));
                alimentos.setLipideosGrama(Double.parseDouble(line[7]));
                alimentos.setColesterolMiliGrama(Double.parseDouble(line[8]));
                alimentos.setCarboidratoGrama(Double.parseDouble(line[9]));
                alimentos.setFibraAlimentarGrama(Double.parseDouble(line[10]));
                alimentos.setCinzasGrama(Double.parseDouble(line[11]));
                alimentos.setCalcioGrama(Double.parseDouble(line[12]));
                alimentos.setMagnesioGrama(Double.parseDouble(line[13]));
                alimentos.setManganesMiliGrama(Double.parseDouble(line[14]));
                alimentos.setFosforoMiliGrama(Double.parseDouble(line[15]));
                alimentos.setFerroMiliGrama(Double.parseDouble(line[16]));
                alimentos.setSodioMiliGrama(Double.parseDouble(line[17]));
                alimentos.setPotassioMiliGrama(Double.parseDouble(line[18]));
                alimentos.setCobreMiliGrama(Double.parseDouble(line[19]));
                alimentos.setZincoMiliGrama(Double.parseDouble(line[20]));
                alimentos.setRetinolMicroGrama(Double.parseDouble(line[21]));
                alimentos.setReMicroGrama(Double.parseDouble(line[22]));
                alimentos.setRaeMicroGrama(Double.parseDouble(line[23]));
                alimentos.setTiaminaMiliGrama(Double.parseDouble(line[24]));
                alimentos.setRiboflavinaMiliGrama(Double.parseDouble(line[25]));
                alimentos.setPiridoxinaMiliGrama(Double.parseDouble(line[26]));
                alimentos.setNiacinaMiliGrama(Double.parseDouble(line[27]));
                alimentos.setVitaminaCMiliGrama(Double.parseDouble(line[28]));
                alimentosList.add(alimentos);
            }
            alimentosRepository.saveAll(alimentosList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }
}

