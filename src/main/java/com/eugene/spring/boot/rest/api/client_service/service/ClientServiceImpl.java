package com.eugene.spring.boot.rest.api.client_service.service;

import com.eugene.spring.boot.rest.api.client_service.model.entity.Client;
import com.eugene.spring.boot.rest.api.client_service.model.entity.Order;
import com.eugene.spring.boot.rest.api.client_service.model.exception.ClientNotFoundException;
import com.eugene.spring.boot.rest.api.client_service.repository.ClientRepository;
import com.eugene.spring.boot.rest.api.client_service.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final OrderRepository orderRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository, OrderRepository orderRepository) {
        this.clientRepository = clientRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public void createClient(Client client) {
        clientRepository.save(client);
    }

    @Override
    public Client readClientById(int id) {
//        Optional<Client> optionalClient = clientRepository.findById(id);
//        Client client = new Client();
//        if (optionalClient.isPresent())
//            client = optionalClient.get();
//        return client;

        return clientRepository.findById(id).orElseThrow(()->
                new ClientNotFoundException(id));
    }

    @Override
    @Transactional
    public boolean updateClient(int id, Client client) {
        if (clientRepository.existsById(id)) {
            client.setId(id);
            clientRepository.save(client);
            return true;
        }
        return false;
    }

    @Override
    public Client deleteClient(int id) {
//        if (clientRepository.existsById(id)) {
//            Client client = readClientById(id);
//            clientRepository.delete(client);
//            return true;
//        }
//        return false;
        Client client = readClientById(id);
        clientRepository.delete(client);

        return client;
    }

    @Override
    @Transactional
    public boolean deleteOneOrderByIdClient(int idClient, int idOrder) {
        if (clientRepository.existsById(idClient)) {
            Client client = readClientById(idClient);
            Order order = orderRepository.getOne(idOrder);
            client.deleteOrderToClient(order);
            return true;
        }
        return false;
    }


    @Override
    @Transactional
    public Order getOneOrderByIdClient(int idClient, int idOrder) {
        if (clientRepository.existsById(idClient)) {
            Client client = readClientById(idClient);
            for (Order order : client.getOrderList()) {
                if (order.getNumberOrder() == idOrder)
                    return order;
            }
        }
        return null;
    }

    @Override
    @Transactional
    public Order updateOneOrderByIdClient(int idClient, int idOrder, Order orderUpdate) {
        if (clientRepository.existsById(idClient)) {
            Client client = readClientById(idClient);
            Order order = null;
            for (Order or : client.getOrderList()) {
                if (or.getNumberOrder() == idOrder)
                    order = or;
            }
            order.setDescription(orderUpdate.getDescription());
            order.setSum(orderUpdate.getSum());
            return orderUpdate;
        }
        return null;
    }

    @Override
    @Transactional
    public void creatOrderByIdClient(int idClient, Order order) {
        if(clientRepository.existsById(idClient)){
            Client client = readClientById(idClient);
            client.addOrderToClient(order);
        }

    }


    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }
}
