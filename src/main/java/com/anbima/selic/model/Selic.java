package com.anbima.selic.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

import javax.persistence.Entity;
import java.time.LocalDate;

@Data
@Entity
@SequenceGenerator(name="SELIC_ID_SEQ", sequenceName="SELIC_ID_SEQ", allocationSize = 1)
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "SELIC")
public class Selic {

    @Id
    @GeneratedValue(generator = "SELIC_ID_SEQ", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "DATA_REFERENCIA")
    private LocalDate dataReferencia;

    @Column(name = "ANO")
    private Integer ano;

    @Column(name = "MES")
    private Integer mes;

    @Column(name = "DIA")
    private Integer dia;

    @Column(name = "ESTIMATIVA_TAXA_SELIC")
    private Double estimativaTaxaSelic;

    public Selic(){}

    public static Selic createFromString(String dataReferencia, String estimativaTaxaSelic) {
        Selic selic = new Selic();
        LocalDate date = LocalDate.parse(dataReferencia);
        selic.setDataReferencia(date);
        selic.setAno(date.getYear());
        selic.setMes(date.getMonth().getValue());
        selic.setDia(date.getDayOfMonth());
        selic.setEstimativaTaxaSelic(Double.parseDouble(estimativaTaxaSelic));
        return selic;
    }
}
