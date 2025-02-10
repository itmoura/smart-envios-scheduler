package com.smartenvios.rotina.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.smartenvios.rotina.model.dto.DadosEntregaDTO;
import com.smartenvios.rotina.model.dto.EventosDTO;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record TrackingResponse(
        @Schema(name = "pedidoCliente", description = "Pedido do cliente", example = "SM82886187440BM")
        @JsonProperty("PedidoCliente")
        String pedidoCliente,

        @Schema(name = "valorFrete", description = "Valor do frete", example = "8.36")
        @JsonProperty("ValorFrete")
        Double valorFrete,

        @Schema(name = "idItemParceiro", description = "Id do item parceiro", example = "30394626")
        Integer idItemParceiro,

        @Schema(name = "cliente", description = "Cliente", example = "SMART ENVIOS - MATRIZ")
        @JsonProperty("Cliente")
        String cliente,

        @Schema(name = "dtPrevista", description = "Data prevista", example = "2021-10-04")
        String dtPrevista,

        @Schema(name = "destinatario", description = "Destinatario", example = "CLOVIS WASHINGTON SILVA DE ALMEI")
        @JsonProperty("Destinatario")
        String destinatario,

        @Schema(name = "codigoRastreio", description = "Codigo de rastreio", example = "588-SM82886187440BM-04537082")
        String codigoRastreio,

        @Schema(name = "url", description = "Url", example = "https://www.carriers.com.br/portal/localizador.php?l=588-SM82886187440BM-04537082")
        @JsonProperty("Url")
        String url,

        @Schema(name = "urlProtocolo", description = "Url do protocolo", example = "https://carriers.com.br/portaris/prot_entrega//2021/09/30/1014092/4000257119711.jpg")
        @JsonProperty("UrlProtocolo")
        String urlProtocolo,

        @Schema(name = "dadosEntrega", description = "Dados de entrega")
        @JsonProperty("DadosEntrega")
        DadosEntregaDTO dadosEntrega,

        @Schema(name = "eventos", description = "Eventos")
        @JsonProperty("Eventos")
        List<EventosDTO> eventos
) {
}
