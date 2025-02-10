package com.smartenvios.rotina.jobs;

import com.smartenvios.rotina.client.CarriersAPI;
import com.smartenvios.rotina.model.response.TrackingResponse;
import com.smartenvios.rotina.producer.TrackingKafkaProducer;
import com.smartenvios.rotina.service.TrackingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Log4j2
@Service
@RequiredArgsConstructor
public class SendTrackingToKafka {

    private final CarriersAPI carriersAPI;
    private final TrackingService trackingService;
    private final TrackingKafkaProducer trackingKafkaProducer;

    @Scheduled(fixedRate = 60000)
    public void rotina() {
        List<String> trackingCodes = trackingService.consultAllTrackingCodeWithoutDadosEntrega();
        trackingCodes.forEach(trackingCode -> {
            try {
                var tracking = carriersAPI.getTracking(trackingCode);
                if (Objects.nonNull(tracking)) {
                    trackingKafkaProducer.sendKafkaMessage(tracking);
                }
            } catch (Exception ex) {
                log.error("Erro ao enviar Tracking - Kafka", ex.getMessage());
            }
        });
    }
}