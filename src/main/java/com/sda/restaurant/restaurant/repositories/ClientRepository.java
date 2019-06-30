package com.sda.restaurant.restaurant.repositories;

import com.sda.restaurant.restaurant.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class ClientRepository {

    @Autowired
    EntityManager em;

    public Client findById(Long id) {
        return em.find(Client.class,id);
    }

    public Client save(Client client){
        if(client.getId()==null){
            em.persist(client);
        }
        else{
            em.merge(client);
        }
        return client;
    }

    public void deleteById(Long id){
        Client clientToDelete =findById(id);
        em.remove(clientToDelete);
    }
}
