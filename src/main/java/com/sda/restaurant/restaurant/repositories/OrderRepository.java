package com.sda.restaurant.restaurant.repositories;

import com.sda.restaurant.restaurant.model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
