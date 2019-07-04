package com.sda.restaurant.restaurant.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * This class is for table object used in restaurants.
 */
@Entity
@Table(name = "Tables")
public class Tables {
    @Id
    @GeneratedValue
    private Long id;

    private int size;

    public Tables() {
    }

    public Tables(int size) {
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
        return "Tables{" +
                "id=" + id +
                ", size=" + size +
                '}';
    }
}
