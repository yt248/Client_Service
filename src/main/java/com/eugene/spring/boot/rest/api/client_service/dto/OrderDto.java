package com.eugene.spring.boot.rest.api.client_service.dto;

public class OrderDto {

    private int numberOrder;
    private String description;
    private double sum;

    public OrderDto() {
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

    @Override
    public String toString() {
        return "OrderDto{" +
                "numberOrder=" + numberOrder +
                ", description='" + description + '\'' +
                ", sum=" + sum +
                '}';
    }
}
