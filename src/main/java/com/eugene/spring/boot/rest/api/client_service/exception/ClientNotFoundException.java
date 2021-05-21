package com.eugene.spring.boot.rest.api.client_service.exception;

import java.text.MessageFormat;

public class ClientNotFoundException extends RuntimeException {

    public ClientNotFoundException(Integer id) {
        super(MessageFormat.format("Could not find client with id: {0}", id));
    }

}
