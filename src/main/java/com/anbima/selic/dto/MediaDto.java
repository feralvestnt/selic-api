package com.anbima.selic.dto;

import lombok.Data;

@Data
public class MediaDto {

    private Double media;
    private Integer ano;

    public MediaDto(Integer ano, Double media) {
        this.media = media;
        this.ano = ano;
    }
}
