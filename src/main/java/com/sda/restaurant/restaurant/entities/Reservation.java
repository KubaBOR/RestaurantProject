package com.sda.restaurant.restaurant.entities;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Entity
public class Reservation {

    @Id
    @GeneratedValue
    private Long id;
    private Calendar dateAndTime;
    private Boolean isPaid;
    private Float tip;

    @ManyToMany(mappedBy = "reservationClients")
    private List<Client> clients = new ArrayList<>();

    @ManyToMany(mappedBy = "reservationTables")
    private List<Table> tables = new ArrayList<>();

    public Reservation() {
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

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public List<Table> getTables() {
        return tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", dateAndTime=" + dateAndTime +
                ", isPaid=" + isPaid +
                ", tip=" + tip +
                ", clients=" + clients +
                ", tables=" + tables +
                '}';
    }
}