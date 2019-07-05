package com.sda.restaurant.restaurant.model;


import javax.persistence.*;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

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
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private ClientEntity clientEntity;

    @OneToMany
    private Set<TablesEntity> tables;

    public ReservationEntity() {
    }

    public ReservationEntity(Calendar dateAndTime, Boolean isPaid, Float tip, ClientEntity clientEntity) {
        this.dateAndTime = dateAndTime;
        this.isPaid = isPaid;
        this.tip = tip;
        this.clientEntity = clientEntity;
        this.clientEntity.setReservationEntity(this);
    }

    public ReservationEntity(Calendar dateAndTime, Boolean isPaid, Float tip, ClientEntity clientEntity, Set<TablesEntity> tables) {
        this.dateAndTime = dateAndTime;
        this.isPaid = isPaid;
        this.tip = tip;
        this.clientEntity = clientEntity;
        this.tables = tables;
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

    public ClientEntity getClientEntity() {
        return clientEntity;
    }

    public void setClientEntity(ClientEntity clientEntity) {
        this.clientEntity = clientEntity;
    }

    public Set<TablesEntity> getTables() {
        return tables;
    }

    public void setTables(Set<TablesEntity> tables) {
        this.tables = tables;
    }
}