package com.eugene.spring.boot.rest.api.client_service.service;

import com.eugene.spring.boot.rest.api.client_service.entity.Order;

import java.util.List;

public interface OrderService {


    /**
     * Создает нового заказа
     *
     * @param order - заказ для создания
     * @return созданный заказ
     */
     Order createOrder(Order order);

    /**
     * Возвращает заказа по его ID
     *
     * @param id - ID заказа
     * @return - объект заказа с заданным ID
     */
     Order readOrderById(int id);


    /**
     * Обновляет заказа с заданным ID,
     * в соответствии с переданным клиентом
     *
     * @param id     - id заказа которого нужно обновить
     * @param updateOrder - заказ в соответствии с которым нужно обновить данные
     */
     void updateOrder(int id, Order updateOrder);


    /**
     * Удаляет клиента с заданным ID
     *
     * @param id - id заказа, которого нужно удалить
     */
     void deleteOrder(int id);


    /**
     * Возвращает список всех имеющихся заказов
     *
     * @return список заказов
     */
     List<Order> getAllOrders();

}
