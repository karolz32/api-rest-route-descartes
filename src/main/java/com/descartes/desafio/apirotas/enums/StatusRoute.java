package com.descartes.desafio.apirotas.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusRoute {

    NOT_STARTED("Rota não iniciada."),
    STARTED("Rota iniciada."),
    DONE("Rota feita.");

    private final String description;

}
