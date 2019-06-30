package com.sda.restaurant.restaurant.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * This class is for table object used in restaurants.
 */
@Entity
public class Table {
    @Id
    @GeneratedValue
    private Long id;

    private int size;
    private int tableNumber;

    public Table() {
    }

    public Table(int size, int tableNumber) {
        this.size = size;
        this.tableNumber = tableNumber;
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

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    @Override
    public String toString() {
        return "Table{" +
                "id=" + id +
                ", size=" + size +
                ", tableNumber=" + tableNumber +
                '}';
    }
}
