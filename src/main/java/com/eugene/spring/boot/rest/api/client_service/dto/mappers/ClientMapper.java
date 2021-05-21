package com.eugene.spring.boot.rest.api.client_service.dto.mappers;

import com.eugene.spring.boot.rest.api.client_service.dto.ClientDto;
import com.eugene.spring.boot.rest.api.client_service.entity.Client;

public class ClientMapper {

    public static ClientDto toDto(Client entity) {
        ClientDto clientDto = new ClientDto();
        clientDto.setId(entity.getId());
        clientDto.setName(entity.getName());
        clientDto.setSurname(entity.getSurname());
        clientDto.getOrderList().addAll(entity.getOrderList());
        return clientDto;
    }


    public static Client toEntity(ClientDto dto) {
        Client client = new Client();
        client.setId(dto.getId());
        client.setName(dto.getName());
        client.setSurname(dto.getSurname());
        client.getOrderList().addAll(dto.getOrderList());
        return client;
    }
}
