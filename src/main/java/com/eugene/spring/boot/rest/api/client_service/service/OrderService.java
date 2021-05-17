package com.eugene.spring.boot.rest.api.client_service.service;

import com.eugene.spring.boot.rest.api.client_service.model.entity.Order;

import java.util.List;

public interface OrderService {


    /**
     * Создает нового заказа
     *
     * @param order - заказ для создания
     */
     void createOrder(Order order);

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
     * @param order - заказ в соответсвии с которым нужно обновить данные
     * @return - true если данные были обновлены, иначе false
     */
     boolean updateOrder(int id, Order order);


    /**
     * Удаляет клиента с заданным ID
     *
     * @param id - id заказа, которого нужно удалить
     * @return - true если заказ был удален, иначе false
     */
     Order deleteOrder(int id);


    /**
     * Возвращает список всех имеющихся заказов
     *
     * @return список заказов
     */
     List<Order> getAllOrders();

}
