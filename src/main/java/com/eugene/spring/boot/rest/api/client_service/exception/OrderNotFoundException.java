package com.eugene.spring.boot.rest.api.client_service.exception;

import java.text.MessageFormat;

public class OrderNotFoundException extends RuntimeException {

    public OrderNotFoundException(Integer id) {
        super(MessageFormat.format("Could not find order with id: {0}", id));
    }

}
