package com.eugene.spring.boot.rest.api.client_service.service;

import com.eugene.spring.boot.rest.api.client_service.model.entity.Client;
import com.eugene.spring.boot.rest.api.client_service.model.entity.Order;

import java.util.List;

public interface ClientService {


    /**
     * Создает нового клиента
     *
     * @param client - клиент для создания
     */
     void createClient(Client client);

    /**
     * Возвращает клиента по его ID
     *
     * @param id - ID клиента
     * @return - объект клиента с заданным ID
     */
     Client readClientById(int id);


    /**
     * Обновляет клиента с заданным ID,
     * в соответствии с переданным клиентом
     *
     * @param id     - id клиента которого нужно обновить
     * @param client - клиент в соответсвии с которым нужно обновить данные
     * @return - true если данные были обновлены, иначе false
     */
     boolean updateClient(int id, Client client);


    /**
     * Удаляет клиента с заданным ID
     *
     * @param id - id клиента, которого нужно удалить
     * @return - true если клиент был удален, иначе false
     */
     Client deleteClient(int id);


    /**
     * Возвращает список всех имеющихся клиентов
     *
     * @return список клиентов
     */
     List<Client> getAllClients();


    /**
     * Удалять единичные записи закза у клиента
     *
     * @param idClient - id клиента у которого нужно удалить запись
     * @param idOrder  - id запили которую нужно удалить
     * @return true если клиент был удален, иначе false
     */
     boolean deleteOneOrderByIdClient(int idClient, int idOrder);

    /**
     * Выдавать единичные записи заказа у клиента
     *
     * @param idClient - id клина у которого нужно взять запись
     * @param idOrder  - id записи которую нужно получить
     * @return обьект записи если она удачно получена, иначе null
     */
     Order getOneOrderByIdClient(int idClient, int idOrder);

    /**
     * Обновлять единичные записи заказа у клиента
     *
     * @param idClient    - id клина у которого нужно взять запись
     * @param idOrder     - id записи которую нужно обновить
     * @param orderUpdate - обьект для обновление записи
     * @return обновленный обьект если запись уданоч обновлена, иначе null
     */
     Order updateOneOrderByIdClient(int idClient, int idOrder, Order orderUpdate);

    /**
     * Создавать записи заказаов у клинета
     *
     * @param idClient - id клиента у которого будет создана запись
     * @param order    - запись в соотвествии с которой нужно создать новую
     */
     void creatOrderByIdClient(int idClient, Order order);
}

//        выдавать список всех заказов по клиенту