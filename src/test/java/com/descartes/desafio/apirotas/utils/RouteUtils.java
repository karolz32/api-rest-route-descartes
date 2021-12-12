package com.descartes.desafio.apirotas.utils;

import com.descartes.desafio.apirotas.dto.request.RouteDTO;
import com.descartes.desafio.apirotas.entity.Route;
import com.descartes.desafio.apirotas.enums.StatusRoute;

import java.util.Collections;

public class RouteUtils {

    private static final String DATE = "08/12/2021";
    private static final StatusRoute STATUS = StatusRoute.DONE;
    private static final long ROUTE_ID = 1L;

    public static RouteDTO createFakeRouteDTO(){
        return RouteDTO.builder()
                .date(DATE)
                .status(STATUS)
                .stops(Collections.singletonList(StopUtils.createFakeStopDTO()))
                .build();
    }

    public static Route createFakeRoute(){
        return Route.builder()
                .id(ROUTE_ID)
                .date(DATE)
                .status(STATUS)
                .stops(Collections.singletonList(StopUtils.createFakeStop()))
                .build();
    }
}
