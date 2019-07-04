package com.sda.restaurant.restaurant.repositories;

import com.sda.restaurant.restaurant.entities.Tables;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TableRepository extends JpaRepository <Tables, Long> {

}