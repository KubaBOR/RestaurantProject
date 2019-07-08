package com.sda.restaurant.restaurant.DTO;

import com.sda.restaurant.restaurant.model.MenuEntity;
import com.sda.restaurant.restaurant.model.ReservationEntity;

import java.util.List;

public class OrderDTO {

    private Long id;

    private ReservationEntity reservation;

    private List<MenuEntity> menu;

    public OrderDTO() {
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

    public List<MenuEntity> getMenu() {
        return menu;
    }

    public void setMenu(List<MenuEntity> menu) {
        this.menu = menu;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "id=" + id +
                ", reservation=" + reservation +
                ", menu=" + menu +
                '}';
    }
}