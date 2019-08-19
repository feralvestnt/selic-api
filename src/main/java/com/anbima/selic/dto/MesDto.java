package com.anbima.selic.dto;

import lombok.Data;

@Data
public class MesDto {

    private Integer mes;
    private Integer ano;

    public MesDto(Integer mes, Integer ano) {
        this.mes = mes;
        this.ano = ano;
    }
}
