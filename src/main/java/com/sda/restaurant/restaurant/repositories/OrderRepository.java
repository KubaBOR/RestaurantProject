package com.sda.restaurant.restaurant.repositories;

import com.sda.restaurant.restaurant.model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    /*@Query("SELECT SUM(o.menu) from OrderEntity o")
    int getById();*/

}
