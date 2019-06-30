package com.sda.restaurant.restaurant.repositories;

import com.sda.restaurant.restaurant.entities.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional

public class TableRepository {

    @Autowired
    EntityManager em;

    public Table findTableById(Long id) {
        return em.find(Table.class, id);
    }

    public Table save(Table table) {
        if (table.getId() == null) {
            em.persist(table);
        }
        else {
            em.merge(table);
        }
        return table;
    }
}
