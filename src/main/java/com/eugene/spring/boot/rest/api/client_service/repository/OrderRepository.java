package com.eugene.spring.boot.rest.api.client_service.repository;

import com.eugene.spring.boot.rest.api.client_service.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
}
