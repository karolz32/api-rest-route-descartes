package com.descartes.desafio.apirotas.utils;

import com.descartes.desafio.apirotas.entity.Route;
import com.descartes.desafio.apirotas.entity.Stop;
import com.descartes.desafio.apirotas.enums.StatusRoute;
import com.descartes.desafio.apirotas.enums.StatusStops;
import org.mockito.Mockito;

import java.util.Collections;

public class TrueUtils {

    public static Route createTrueRoute() {

        return Mockito.mock(Route.class);
        /*return Route.builder()
                .id(1L)
                .date("08/12/2021")
                .status(StatusRoute.DONE)
                .stops(Collections.singletonList(createTrueStop()))
                .build();*/
    }

    public static Stop createTrueStop() {
        return Mockito.mock(Stop.class);

        /*return Stop.builder()
                .id(1L)
                .description("Ponto Pinheiro")
                .address("Av. Godofredo Maciel, 4000")
                .latitude(-3.8093789)
                .longitude(-38.5744287)
                .status(StatusStops.ANSWER).build();*/
    }

}
