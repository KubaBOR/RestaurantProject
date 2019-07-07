package com.sda.restaurant.restaurant.repositories;

import com.sda.restaurant.restaurant.controllers.ReservationController;
import com.sda.restaurant.restaurant.model.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ReservationRepository extends JpaRepository<ReservationEntity,Long> {

    ReservationEntity getById(Long id);
    Optional<ReservationEntity> findById(Long id);

}
