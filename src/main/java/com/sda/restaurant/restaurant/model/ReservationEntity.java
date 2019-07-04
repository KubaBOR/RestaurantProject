package com.sda.restaurant.restaurant.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Calendar;

@Entity
public class ReservationEntity {
    @Id
    @GeneratedValue
    private Long id;
    private Calendar dateAndTime;
    private Boolean isPaid;
    private Float tip;
// todo - klucz obcy id klienta
// todo - klucz obcy id tables

    //todo - fix
    /*@ManyToMany(mappedBy = "reservationClients")
    private List<ClientEntity> clients = new ArrayList<>();

    @ManyToMany(mappedBy = "reservationTables")
    private List<Table> tables = new ArrayList<>();*/

    public ReservationEntity() {
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
        return "ReservationEntity{" +
                "id=" + id +
                ", dateAndTime=" + dateAndTime +
                ", isPaid=" + isPaid +
                ", tip=" + tip +
                '}';
    }
}