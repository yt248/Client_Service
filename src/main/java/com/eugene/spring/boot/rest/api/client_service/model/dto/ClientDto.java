package com.eugene.spring.boot.rest.api.client_service.model.dto;

import com.eugene.spring.boot.rest.api.client_service.model.entity.Order;

import java.util.ArrayList;
import java.util.List;

public class ClientDto {

    private int id;
    private String name;
    private String surname;
    private List<Order> orderList = new ArrayList<>();

    public ClientDto() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    @Override
    public String toString() {
        return "ClientDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
