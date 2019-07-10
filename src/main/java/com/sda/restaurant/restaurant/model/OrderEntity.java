package com.sda.restaurant.restaurant.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class OrderEntity {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private ReservationEntity reservation;

    @OneToOne
    private MenuEntity menu;

    public OrderEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ReservationEntity getReservation() {
        return reservation;
    }

    public void setReservation(ReservationEntity reservation) {
        this.reservation = reservation;
    }

    public MenuEntity getMenu() {
        return menu;
    }

    public void setMenu(MenuEntity menu) {
        this.menu = menu;
    }
}
