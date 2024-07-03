package br.com.nutriscare.nutrisCareRulesApi.entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "alimentos")
@AllArgsConstructor
@NoArgsConstructor
public class Alimentos {

    @Id
    private Long id;

    private String categoria;
    private String descricao;
    private Double umidadePerCent;
    private Double quiloCalorias;
    private Double quiloJoules;
    private Double proteinaGrama;
    private Double lipideosGrama;
    private Double colesterolMiliGrama;
    private Double carboidratoGrama;
    private Double fibraAlimentarGrama;
    private Double cinzasGrama;
    private Double calcioGrama;
    private Double magnesioGrama;
    private Double manganesMiliGrama;
    private Double fosforoMiliGrama;
    private Double ferroMiliGrama;
    private Double sodioMiliGrama;
    private Double potassioMiliGrama;
    private Double cobreMiliGrama;
    private Double zincoMiliGrama;
    private Double retinolMicroGrama;
    private Double reMicroGrama;
    private Double raeMicroGrama;
    private Double tiaminaMiliGrama;
    private Double riboflavinaMiliGrama;
    private Double piridoxinaMiliGrama;
    private Double niacinaMiliGrama;
    private Double vitaminaCMiliGrama;
}
