package com.eugene.spring.boot.rest.api.client_service.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @OneToMany(mappedBy = "client", cascade = {
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH,
            CascadeType.DETACH})
    private List<Order> orderList = new ArrayList<>();

    /**
     * Пустой конструктор
     */
    public Client() {
    }

    /**
     * Конструток с параметрами
     */
    public Client(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    /**
     * Добавление записи заказов у клиента
     */
    public void addOrderToClient(Order order) {
        order.setClient(this);
        orderList.add(order);
    }

    /**
     * Удаление записи закза у клиента
     */
    public void deleteOrderToClient(Order order) {
        orderList.remove(order);
        order.setClient(null);
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
}
