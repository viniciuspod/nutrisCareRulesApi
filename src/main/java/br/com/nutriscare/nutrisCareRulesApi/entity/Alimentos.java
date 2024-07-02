package br.com.nutriscare.nutrisCareRulesApi.entity;

import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "alimentos")
public class Alimentos {

    @Id
    private Long id;

    private String categoria;
    private String descricao;
    private double umidadePerCent;
    private double quiloCalorias;
    private double quiloJoules;
    private double proteinaGrama;
    private double lipideosGrama;
    private double colesterolMiliGrama;
    private double carboidratoGrama;
    private double fibraAlimentarGrama;
    private double cinzasGrama;
    private double calcioGrama;
    private double magnesioGrama;
    private double manganesMiliGrama;
    private double fosforoMiliGrama;
    private double ferroMiliGrama;
    private double sodioMiliGrama;
    private double potassioMiliGrama;
    private double cobreMiliGrama;
    private double zincoMiliGrama;
    private double retinolMicroGrama;
    private double reMicroGrama;
    private double raeMicroGrama;
    private double tiaminaMiliGrama;
    private double riboflavinaMiliGrama;
    private double piridoxinaMiliGrama;
    private double niacinaMiliGrama;
    private double vitaminaCMiliGrama;
}
