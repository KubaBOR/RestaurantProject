package com.sda.restaurant.restaurant.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="table_id",referencedColumnName = "id")
    private ReservationEntity reservationEntity;

    public TablesEntity() {
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

    public ReservationEntity getReservationEntity() {
        return reservationEntity;
    }

    public void setReservationEntity(ReservationEntity reservationEntity) {
        this.reservationEntity = reservationEntity;
    }
}
