package com.sda.restaurant.restaurant.repositories;

import com.sda.restaurant.restaurant.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findByEmail(String email);


}
