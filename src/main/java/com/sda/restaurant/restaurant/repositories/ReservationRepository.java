package com.sda.restaurant.restaurant.repositories;

import com.sda.restaurant.restaurant.model.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<ReservationEntity,Long> {


}
