package com.smartenvios.rotina.service;

import com.smartenvios.rotina.client.CarriersAPI;
import com.smartenvios.rotina.model.entity.Tracking;
import com.smartenvios.rotina.model.response.TrackingResponse;
import com.smartenvios.rotina.repository.TrackingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class TrackingService {

    private final TrackingRepository trackingRepository;

    public List<String> consultAllTrackingCodeWithoutDadosEntrega() {
        List<Tracking> trackingList = trackingRepository.findAllTrackingsByDadosEntregaIsEmpty();

        return trackingList.stream()
                .map(Tracking::pedidoCliente)
                .toList();
    }
}
