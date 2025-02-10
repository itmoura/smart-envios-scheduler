package com.smartenvios.rotina.model.entity;

import com.smartenvios.rotina.model.dto.DadosEntregaDTO;
import com.smartenvios.rotina.model.dto.EventosDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public record Tracking(
        @Id
        @Schema(name = "id", description = "tracking identifier", example = "638781f41257846c89d55B32")
        String id,

        @Schema(name = "pedidoCliente", description = "Pedido do cliente", example = "SM82886187440BM")
        String pedidoCliente,

        @Schema(name = "valorFrete", description = "Valor do frete", example = "8.36")
        Double valorFrete,

        @Schema(name = "idItemParceiro", description = "Id do item parceiro", example = "30394626")
        Integer idItemParceiro,

        @Schema(name = "cliente", description = "Cliente", example = "SMART ENVIOS - MATRIZ")
        String cliente,

        @Schema(name = "dtPrevista", description = "Data prevista", example = "2021-10-04")
        String dtPrevista,

        @Schema(name = "destinatario", description = "Destinatario", example = "CLOVIS WASHINGTON SILVA DE ALMEI")
        String destinatario,

        @Schema(name = "codigoRastreio", description = "Codigo de rastreio", example = "588-SM82886187440BM-04537082")
        String codigoRastreio,

        @Schema(name = "url", description = "Url", example = "https://www.carriers.com.br/portal/localizador.php?l=588-SM82886187440BM-04537082")
        String url,

        @Schema(name = "urlProtocolo", description = "Url do protocolo", example = "https://carriers.com.br/portaris/prot_entrega//2021/09/30/1014092/4000257119711.jpg")
        String urlProtocolo,

        @Schema(name = "dadosEntrega", description = "Dados de entrega")
        DadosEntregaDTO dadosEntrega,

        @Schema(name = "eventos", description = "Eventos")
        List<EventosDTO> eventos
) {
}
