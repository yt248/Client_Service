package com.eugene.spring.boot.rest.api.client_service.service;

import com.eugene.spring.boot.rest.api.client_service.entity.Order;
import com.eugene.spring.boot.rest.api.client_service.exception.OrderNotFoundException;
import com.eugene.spring.boot.rest.api.client_service.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order createOrder(Order order) {
        orderRepository.save(order);
        return order;
    }

    @Override
    public Order readOrderById(int id) {
        return orderRepository.findById(id).orElseThrow(() ->
                new OrderNotFoundException(id));
    }

    @Override
    public void updateOrder(int id, Order updateOrder) {
        Order order = null;
        Optional<Order> optional = orderRepository.findById(id);
        if (optional.isPresent()) {
            order = optional.get();
            order.setDescription(updateOrder.getDescription());
            order.setSum(updateOrder.getSum());
            orderRepository.save(order);
        }

    }


    @Override
    public void deleteOrder(int id) {
        Order order = readOrderById(id);
        orderRepository.delete(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
