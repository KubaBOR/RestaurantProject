package com.sda.restaurant.restaurant.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class OrderEntity {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private ReservationEntity reservation;

    @OneToMany
    private Set<MenuEntity> menu;

    private Double totalPrice;

    public OrderEntity() {
    }

    public OrderEntity(ReservationEntity reservation, Set<MenuEntity> menu, Double totalPrice) {
        this.reservation = reservation;
        this.menu = menu;
        this.totalPrice = totalPrice;
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

    public Set<MenuEntity> getMenu() {
        return menu;
    }

    public void setMenu(Set<MenuEntity> menu) {
        this.menu = menu;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
