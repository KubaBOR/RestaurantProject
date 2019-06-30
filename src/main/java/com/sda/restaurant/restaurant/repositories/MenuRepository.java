package com.sda.restaurant.restaurant.repositories;

import com.sda.restaurant.restaurant.entities.Client;
import com.sda.restaurant.restaurant.entities.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class MenuRepository {

    @Autowired
    EntityManager em;

    public Menu findById(Long id) {
        return em.find(Menu.class,id);
    }

    public Menu save(Menu menu){
        if(menu.getId()==null){
            em.persist(menu);
        }
        else{
            em.merge(menu);
        }
        return menu;
    }

    public void deleteById(Long id){
        Menu menuToDelete =findById(id);
        em.remove(menuToDelete);
    }
}
