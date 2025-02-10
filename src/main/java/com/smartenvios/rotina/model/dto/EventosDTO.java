package com.smartenvios.rotina.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

public record EventosDTO(
        @Schema(name = "data", description = "Data", example = "30-09-2021 11:16:59")
        @JsonProperty("Data")
        String data,

        @Schema(name = "status", description = "Status", example = "ENTREGA REALIZADA")
        @JsonProperty("Status")
        String status,

        @Schema(name = "idStatus", description = "idStatus", example = "101")
        Integer idStatus,

        @Schema(name = "descricao", description = "Descricao", example = "Entregue")
        @JsonProperty("Descricao")
        String descricao
) {
}
