package com.eugene.spring.boot.rest.api.client_service.contoller;

import com.eugene.spring.boot.rest.api.client_service.dto.OrderDto;
import com.eugene.spring.boot.rest.api.client_service.dto.mappers.OrderMappers;
import com.eugene.spring.boot.rest.api.client_service.entity.Order;
import com.eugene.spring.boot.rest.api.client_service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    //    @GetMapping("/")
//    public List<OrderDto> getAllOrder() {
//        List<Order> orderList = orderService.getAllOrders();
//        return orderList.stream().map(OrderMappers::toDto).collect(Collectors.toList());
//    }

    @GetMapping("/")
    public ResponseEntity<List<OrderDto>> getAllOrder() {
        List<Order> orderList = orderService.getAllOrders();
        List<OrderDto> orderDtoList = orderList.stream().map(OrderMappers::toDto).collect(Collectors.toList());
        return new ResponseEntity<>(orderDtoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable int id) {
        return orderService.readOrderById(id);
    }


}
