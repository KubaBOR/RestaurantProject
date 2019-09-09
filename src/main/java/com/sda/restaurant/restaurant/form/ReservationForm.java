package com.sda.restaurant.restaurant.form;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class ReservationForm {
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime dateAndTime;
    private Boolean isPaid = false;
    private Float tip;
    private Boolean occupied;

    private Long clientId;
    private Long[] tableIds;

    public ReservationForm() {

    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(LocalDateTime dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public Boolean getPaid() {
        return isPaid;
    }

    public void setPaid(Boolean paid) {
        isPaid = paid;
    }

    public Float getTip() {
        return tip;
    }

    public void setTip(Float tip) {
        this.tip = tip;
    }

    public Long[] getTableIds() {
        return tableIds;
    }

    public void setTableIds(Long[] tableIds) {
        this.tableIds = tableIds;
    }

    public Boolean getOccupied() {
        return occupied;
    }

    public void setOccupied(Boolean occupied) {
        this.occupied = occupied;
    }
}
