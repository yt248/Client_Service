package com.eugene.spring.boot.rest.api.client_service.contoller;

import com.eugene.spring.boot.rest.api.client_service.model.dto.ClientDto;
import com.eugene.spring.boot.rest.api.client_service.model.dto.OrderDto;
import com.eugene.spring.boot.rest.api.client_service.model.dto.mappers.ClientMapper;
import com.eugene.spring.boot.rest.api.client_service.model.dto.mappers.OrderMappers;
import com.eugene.spring.boot.rest.api.client_service.model.entity.Client;
import com.eugene.spring.boot.rest.api.client_service.model.entity.Order;
import com.eugene.spring.boot.rest.api.client_service.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    //------------------------------Создание клинета---------------------------------
    @PostMapping(value = "/")
    @ResponseStatus(HttpStatus.CREATED)
    public ClientDto create(@RequestBody ClientDto clientDto) {
        clientService.createClient(ClientMapper.toEntity(clientDto));
        return clientDto;
    }

    //------------------------------Получение всех клиентов---------------------------------
    @GetMapping("/")
    public List<ClientDto> getAllClients() {
        List<Client> clients = clientService.getAllClients();
        List<ClientDto> clientDtoList = clients.stream().map(ClientMapper::toDto).collect(Collectors.toList());
        return clientDtoList;
    }

    //-------------------------------Получение клинета по ID--------------------------------
    @GetMapping("/{id}")
    public ClientDto getClientById(@PathVariable("id") int id) {
        Client client = clientService.readClientById(id);
        return ClientMapper.toDto(client);
    }

    //--------------------------------Получить список всех заказов по клиенту-------------------------------
    @GetMapping("/{id}/orders")
    public List<Order> getAllOrdersByIdClient(@PathVariable("id") int id) {
        Client client = clientService.readClientById(id);
        return ClientMapper.toDto(client).getOrderList();
    }


    //--------------------------------Обновление клинета по ID-------------------------------
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ClientDto updateClientById(@PathVariable("id") int id, @RequestBody ClientDto clientDto) {
        clientService.updateClient(id, ClientMapper.toEntity(clientDto));
        return clientDto;
    }

    //--------------------------------Удаление клинета по ID-------------------------------
    @DeleteMapping("/{id}")
    public void deleteClientById(@PathVariable("id") int id) {
        clientService.deleteClient(id);
    }

    //--------------------------------Удаление единичной записи заказа у клинета по ID-------------
    @DeleteMapping("/{idClient}/orders/{idOrder}")
    public void deleteOneOrderByIdClient(@PathVariable("idClient") int idClient, @PathVariable("idOrder") int idOrder) {
        clientService.deleteOneOrderByIdClient(idClient, idOrder);
    }


    //--------------------------------Выдать единичный заказа у клинета по ID-------------
    @GetMapping("/{idClient}/orders/{idOrder}")
    public OrderDto getOneOrderByIdClient(@PathVariable("idClient") int idClient, @PathVariable("idOrder") int idOrder) {
        return OrderMappers.toDto(clientService.getOneOrderByIdClient(idClient, idOrder));
    }

    //--------------------------------Обновить единичный заказа у клинета по ID-------------
    @PutMapping("/{idClient}/orders/{idOrder}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public OrderDto updateOneOrderByIdClient(@PathVariable("idClient") int idClient, @PathVariable("idOrder") int idOrder,
                                             @RequestBody Order updateOrder) {
        return OrderMappers.toDto(clientService.updateOneOrderByIdClient(idClient, idOrder, updateOrder));
    }

    //--------------------------------Создать заказа у клинета по ID-------------
    @PostMapping("/{idClient}/orders/")
    @ResponseStatus(HttpStatus.CREATED)
    public void creatOrderByIdClient(@PathVariable("idClient") int idClient, @RequestBody OrderDto orderDto) {
        clientService.creatOrderByIdClient(idClient, OrderMappers.toEntity(orderDto));
    }


}
