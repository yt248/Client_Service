package com.eugene.spring.boot.rest.api.client_service.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "number_order")
    private int numberOrder;

    @Column(name = "description")
    private String description;

    @Column(name = "sum")
    private double sum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    public Order() {
    }

    public int getNumberOrder() {
        return numberOrder;
    }

    public void setNumberOrder(int numberOrder) {
        this.numberOrder = numberOrder;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    @JsonIgnore
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }


    @Override
    public String toString() {
        return "Order{" +
                "numberOrder=" + numberOrder +
                ", description='" + description + '\'' +
                ", sum=" + sum +
                '}';
    }
}
