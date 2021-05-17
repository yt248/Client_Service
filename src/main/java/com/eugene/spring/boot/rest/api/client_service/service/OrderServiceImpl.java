package com.eugene.spring.boot.rest.api.client_service.service;

import com.eugene.spring.boot.rest.api.client_service.model.entity.Order;
import com.eugene.spring.boot.rest.api.client_service.model.exception.OrderNotFoundException;
import com.eugene.spring.boot.rest.api.client_service.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void createOrder(Order order) {
        orderRepository.save(order);
    }

    @Override
    public Order readOrderById(int id) {
//        Optional<Order> optional = orderRepository.findById(id);
//        Order order = new Order();
//        if (optional.isPresent())
//            order = optional.get();
//
//        return order;

        return orderRepository.findById(id).orElseThrow(()->
                new OrderNotFoundException(id));
    }

    @Override
    public boolean updateOrder(int id, Order order) {
        if (orderRepository.existsById(id)) {
            order.setNumberOrder(id);
            orderRepository.save(order);

            return true;
        }
        return false;
    }

    @Override
    public Order deleteOrder(int id) {
//        Optional<Order> optional = orderRepository.findById(id);
//        if (optional.isPresent()) {
//            orderRepository.delete(optional.get());
//            return true;
//        }
//        return false;

        Order order = readOrderById(id);
        orderRepository.delete(order);
        return order;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
