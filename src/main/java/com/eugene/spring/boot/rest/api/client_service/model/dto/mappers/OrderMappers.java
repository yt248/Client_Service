package com.eugene.spring.boot.rest.api.client_service.model.dto.mappers;

import com.eugene.spring.boot.rest.api.client_service.model.dto.OrderDto;
import com.eugene.spring.boot.rest.api.client_service.model.entity.Order;

public class OrderMappers {

    public static OrderDto toDto(Order entity) {
        OrderDto orderDto = new OrderDto();
        orderDto.setNumberOrder(entity.getNumberOrder());
        orderDto.setDescription(entity.getDescription());
        orderDto.setSum(entity.getSum());
        return orderDto;
    }

    public static Order toEntity(OrderDto dto) {
        Order order = new Order();
        order.setNumberOrder(dto.getNumberOrder());
        order.setDescription(dto.getDescription());
        order.setSum(dto.getSum());
        return order;
    }
}
