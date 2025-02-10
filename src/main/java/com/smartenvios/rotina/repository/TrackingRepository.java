package com.smartenvios.rotina.repository;

import com.smartenvios.rotina.model.entity.Tracking;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrackingRepository extends MongoRepository<Tracking, String> {

    @Query(value = "{dadosEntrega: { $exists: false }}")
    List<Tracking> findAllTrackingsByDadosEntregaIsEmpty();
}
