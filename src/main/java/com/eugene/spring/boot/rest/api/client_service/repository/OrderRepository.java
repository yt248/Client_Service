package com.eugene.spring.boot.rest.api.client_service.repository;

import com.eugene.spring.boot.rest.api.client_service.entity.Client;
import com.eugene.spring.boot.rest.api.client_service.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query("from Order o where o.numberOrder = :idOrder and o.client = :client")
    Order getOneOrderByIdClient(@Param("idOrder") int idOrder, @Param("client") Client client);


}
