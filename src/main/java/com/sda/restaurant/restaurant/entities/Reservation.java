package com.sda.restaurant.restaurant.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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

    //todo - fix
    /*@ManyToMany(mappedBy = "reservationClients")
    private List<Client> clients = new ArrayList<>();

    @ManyToMany(mappedBy = "reservationTables")
    private List<Table> tables = new ArrayList<>();*/

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


    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", dateAndTime=" + dateAndTime +
                ", isPaid=" + isPaid +
                ", tip=" + tip +
                '}';
    }
}