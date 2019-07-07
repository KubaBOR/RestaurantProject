package com.sda.restaurant.restaurant.DTO;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

public class ReservationDTO {

    private Long id;
    //@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime dateAndTime;
    private Boolean Paid = false;
    private Float tip;
    private ClientDTO client;
    private TablesDTO tables;

    public ReservationDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(LocalDateTime dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public Boolean getPaid() {
        return Paid;
    }

    public void setPaid(Boolean paid) {
        Paid = paid;
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

    public TablesDTO getTables() {
        return tables;
    }

    public void setTables(TablesDTO tables) {
        this.tables = tables;
    }

    @Override
    public String toString() {
        return "ReservationDTO{" +
                "id=" + id +
                ", dateAndTime=" + dateAndTime +
                ", Paid=" + Paid +
                ", tip=" + tip +
                ", client=" + client +
                ", tables=" + tables +
                '}';
    }
}
