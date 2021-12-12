package com.descartes.desafio.apirotas.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RouteNotFoundException extends Exception{

    public RouteNotFoundException(Long id) {
        super("Rota não encontrada no ID");
    }
}
