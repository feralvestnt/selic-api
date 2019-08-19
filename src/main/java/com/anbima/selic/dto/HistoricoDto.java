package com.anbima.selic.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class HistoricoDto {

    private Integer id;
    private LocalDate dataReferencia;
    private Double estimativaTaxaSelic;
}
