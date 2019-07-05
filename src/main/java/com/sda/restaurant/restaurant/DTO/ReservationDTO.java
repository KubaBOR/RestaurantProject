package com.sda.restaurant.restaurant.DTO;

import java.util.Calendar;
import java.util.List;

public class ReservationDTO {

    private Long id;
    private Calendar dateAndTime;
    private Boolean isPaid;
    private Float tip;
    private ClientDTO client;
    private List<TablesDTO> tables;

    public ReservationDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Calendar getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(Calendar dateAndTime) {
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

    public ClientDTO getClient() {
        return client;
    }

    public void setClient(ClientDTO client) {
        this.client = client;
    }

    public List<TablesDTO> getTables() {
        return tables;
    }

    public void setTables(List<TablesDTO> tables) {
        this.tables = tables;
    }

    @Override
    public String toString() {
        return "ReservationDTO{" +
                "id=" + id +
                ", dateAndTime=" + dateAndTime +
                ", isPaid=" + isPaid +
                ", tip=" + tip +
                ", client=" + client +
                ", tables=" + tables +
                '}';
    }
}
