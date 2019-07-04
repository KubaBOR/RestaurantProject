package com.sda.restaurant.restaurant.repositories;

import com.sda.restaurant.restaurant.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findByEmail(String email);


}
