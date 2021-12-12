package com.descartes.desafio.apirotas.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusStops {

    NOT_ANSWER("Entrega não foi feita. Entregador não foi atendido."),
    ANSWER("Entrega feita.");

    private final String description;

}
