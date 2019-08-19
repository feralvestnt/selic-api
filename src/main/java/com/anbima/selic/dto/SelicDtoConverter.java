package com.anbima.selic.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SelicDtoConverter {

    @JsonProperty("data_referencia")
    private String dataReferencia;

    @JsonProperty("estimativa_taxa_selic")
    private String estimativaTaxaSelic;
}
