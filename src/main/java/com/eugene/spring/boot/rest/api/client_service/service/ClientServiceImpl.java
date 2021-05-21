package com.eugene.spring.boot.rest.api.client_service.service;

import com.eugene.spring.boot.rest.api.client_service.entity.Client;
import com.eugene.spring.boot.rest.api.client_service.entity.Order;
import com.eugene.spring.boot.rest.api.client_service.exception.ClientNotFoundException;
import com.eugene.spring.boot.rest.api.client_service.repository.ClientRepository;
import com.eugene.spring.boot.rest.api.client_service.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
    public Client createClient(Client client) {
        clientRepository.save(client);
        return client;
    }

    @Override
    public Client readClientById(int id) {
        return clientRepository.findById(id).orElseThrow(() ->
                new ClientNotFoundException(id));
    }

    @Override
    @Transactional
    public void updateClient(int id, Client updateClient) {
//        if (clientRepository.existsById(id)) {
//            client.setId(id);
//            clientRepository.save(client);
//        }

        Client client = null;
        Optional<Client> optional = clientRepository.findById(id);
        if (optional.isPresent()) {
            client = optional.get();
            client.setName(updateClient.getName());
            client.setSurname(updateClient.getSurname());
            clientRepository.save(client);
        }
    }

    @Override
    public void deleteClient(int id) {
        Client client = readClientById(id);
        clientRepository.delete(client);
    }

    @Override
    @Transactional
    public void deleteOneOrderByIdClient(int idClient, int idOrder) {
        Client client = readClientById(idClient);
        Order order = orderRepository.getOneOrderByIdClient(idOrder, client);
        orderRepository.delete(order);
    }


    @Override
    @Transactional
    public Order getOneOrderByIdClient(int idClient, int idOrder) {
        Client client = readClientById(idClient);
        return orderRepository.getOneOrderByIdClient(idOrder, client);
    }


    @Override
    @Transactional
    public Order updateOneOrderByIdClient(int idClient, int idOrder, Order orderUpdate) {
        Client client = readClientById(idClient);
        Order oneOrderByIdClient = orderRepository.getOneOrderByIdClient(idOrder, client);
        oneOrderByIdClient.setDescription(orderUpdate.getDescription());
        oneOrderByIdClient.setSum(orderUpdate.getSum());
//        orderRepository.save(oneOrderByIdClient);

        return oneOrderByIdClient;

    }

    @Override
    @Transactional
    public void creatOrderByIdClient(int idClient, Order order) {
        Client client = readClientById(idClient);
        order.setClient(client);
        orderRepository.save(order);
    }


    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }
}
