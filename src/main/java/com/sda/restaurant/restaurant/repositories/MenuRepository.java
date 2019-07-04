package com.sda.restaurant.restaurant.repositories;

import com.sda.restaurant.restaurant.entities.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository <Menu,Long> {

    Menu findByCategory(String category);

}
