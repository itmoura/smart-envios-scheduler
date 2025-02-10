package com.smartenvios.rotina.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

public record DadosEntregaDTO(
        @Schema(name = "recebedor", description = "Recebedor", example = "Marcondes")
        @JsonProperty("Recebedor")
        String recebedor,

        @Schema(name = "docRecebedor", description = "Doc Recebedor", example = "42019335808")
        @JsonProperty("DocRecebedor")
        String docRecebedor,

        @Schema(name = "parentesco", description = "Parentesco", example = "PORTARIA")
        @JsonProperty("Parentesco")
        String parentesco,

        @Schema(name = "dataProtocolo", description = "Data Protocolo", example = "01-10-2021 08:17:47")
        @JsonProperty("DataProtocolo")
        String dataProtocolo
){
}
