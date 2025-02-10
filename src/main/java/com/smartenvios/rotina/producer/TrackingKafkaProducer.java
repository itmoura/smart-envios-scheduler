package com.smartenvios.rotina.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartenvios.rotina.model.response.TrackingResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class TrackingKafkaProducer {

    @Value("${kafka.producer.topic}")
    private String topic;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendKafkaMessage(TrackingResponse tracking) throws JsonProcessingException {
        log.info("Sending message to Kafka");
        var messagePayload = new ObjectMapper().writeValueAsString(tracking);
        kafkaTemplate.send(topic, messagePayload);
    }
}
