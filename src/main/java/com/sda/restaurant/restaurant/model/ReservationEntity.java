package com.sda.restaurant.restaurant.model;


import com.sda.restaurant.restaurant.controllers.ReservationController;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class ReservationEntity {
    @Id
    @GeneratedValue
    private Long id;
    @DateTimeFormat(pattern = "dd/MM/yyyy'T'hh:mm")
    private LocalDateTime dateAndTime;
    private Boolean isPaid;
    private Float tip;
// todo - klucz obcy id klienta
// todo - klucz obcy id tables

    //todo - fix
    @OneToOne //(cascade = CascadeType.ALL)
//    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private ClientEntity client;

    @OneToMany
    private Set<TablesEntity> tables;


    public ReservationEntity() {
    }

/*    public ReservationEntity(LocalDateTime dateAndTime, Boolean isPaid, Float tip, Set<ClientEntity> client) {
        this.dateAndTime = dateAndTime;
        this.isPaid = isPaid;
        this.tip = tip;
        this.client = client;
//        this.client.setReservationEntity(this);
    }

    public ReservationEntity(LocalDateTime dateAndTime, Boolean isPaid, Float tip, ClientEntity client, Set<TablesEntity> tables) {
        this.dateAndTime = dateAndTime;
        this.isPaid = isPaid;
        this.tip = tip;
//        this.client = client;
        this.tables = tables;
    }*/

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

    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity client) {
        this.client = client;
    }

    public Set<TablesEntity> getTables() {
        return tables;
    }

    public void setTables(Set<TablesEntity> tables) {
        this.tables = tables;
    }
}