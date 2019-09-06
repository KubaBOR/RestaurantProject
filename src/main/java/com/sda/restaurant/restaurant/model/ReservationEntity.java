package com.sda.restaurant.restaurant.model;

import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
public class ReservationEntity {
    @Id
    @GeneratedValue
    private Long id;
    @DateTimeFormat(pattern = "dd/MM/yyyy''hh:mm")
    private LocalDateTime dateAndTime;

    private Boolean occupied;
// todo - klucz obcy id klienta
// todo - klucz obcy id tables

    //todo - fix
    @OneToOne //(cascade = CascadeType.ALL)
    private ClientEntity client;

    @OneToOne
    private TablesEntity tables;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="reservation_id",referencedColumnName = "id")
    private OrderEntity order;


    public ReservationEntity() {
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

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }

    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity client) {
        this.client = client;
    }

    public TablesEntity getTables() {
        return tables;
    }

    public void setTables(TablesEntity tables) {
        this.tables = tables;
    }

    public Boolean getOccupied() {
        return occupied;
    }

    public void setOccupied(Boolean occupied) {
        this.occupied = occupied;
    }
}