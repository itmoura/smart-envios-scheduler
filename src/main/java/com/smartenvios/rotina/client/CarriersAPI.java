package com.smartenvios.rotina.client;

import com.smartenvios.rotina.client.config.CarriersClientConfig;
import com.smartenvios.rotina.model.dto.DadosEntregaDTO;
import com.smartenvios.rotina.model.dto.EventosDTO;
import com.smartenvios.rotina.model.response.TrackingResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.logging.Logger;

@Component
@FeignClient(name = "carriers-api", url = "${apis.carriers.url}", configuration = CarriersClientConfig.class)
public interface CarriersAPI {
    Logger LOGGER = Logger.getLogger(CarriersAPI.class.getName());

    @CircuitBreaker(name = "get-tracking", fallbackMethod = "fallbackGetTracking")
    @GetMapping(value = "Carriers/Tracking/{trackingCode}", consumes = "application/json")
    TrackingResponse getTracking(@PathVariable String trackingCode);

    default TrackingResponse fallbackGetTracking(String trackingCode, Throwable throwable) {
        LOGGER.warning("Fallback method triggered for tracking code: " + trackingCode + ", reason: " + throwable.getMessage());
        DadosEntregaDTO dadosEntregaDTO = new DadosEntregaDTO("", "", "", "");
        List<EventosDTO> eventosDTOList = List.of(new EventosDTO("", "", 0, ""));

        return new TrackingResponse(
                "",
                0.0,
                0,
                "",
                "",
                "",
                "",
                "",
                "",
                dadosEntregaDTO,
                eventosDTOList
        );
    }
}
