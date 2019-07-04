package com.sda.restaurant.restaurant.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * This class is for table object used in restaurants.
 */
@Entity
@Table(name = "TablesEntity")
public class TablesEntity {
    @Id
    @GeneratedValue
    private Long id;

    private int size;

    public TablesEntity() {
    }

    public TablesEntity(int size) {
        this.size = size;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "TablesEntity{" +
                "id=" + id +
                ", size=" + size +
                '}';
    }
}
