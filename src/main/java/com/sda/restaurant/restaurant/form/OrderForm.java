package com.sda.restaurant.restaurant.form;

public class OrderForm {

    private Long reservationId;
    private Long[] menuIds;

    public OrderForm() {}

    public OrderForm(Long[] menuIds) {
        this.menuIds = menuIds;
    }

    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    public Long[] getMenuIds() {
        return menuIds;
    }

    public void setMenuIds(Long[] menuIds) {
        this.menuIds = menuIds;
    }
}
