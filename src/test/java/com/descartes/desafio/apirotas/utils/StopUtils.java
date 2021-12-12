package com.descartes.desafio.apirotas.utils;

import com.descartes.desafio.apirotas.dto.request.StopDTO;
import com.descartes.desafio.apirotas.entity.Stop;
import com.descartes.desafio.apirotas.enums.StatusStops;

public class StopUtils {


    private static final String DESCRIPTION = "Ponto Pinheiro";
    private static final String ADDRESS = "Av. Godofredo Maciel, 4000";
    private static final double LATITUDE = -3.8093789;
    private static final double LONGITUDE = -38.5744287;
    private static final StatusStops STATUS = StatusStops.ANSWER;
    private static final long STOP_ID = 1L;

    public static StopDTO createFakeStopDTO(){
        return StopDTO.builder()
                .description(DESCRIPTION)
                .address(ADDRESS)
                .latitude(LATITUDE)
                .longitude(LONGITUDE)
                .status(STATUS)
                .build();
    }

    public static Stop createFakeStop(){
        return Stop.builder()
                .description(DESCRIPTION)
                .address(ADDRESS)
                .latitude(LATITUDE)
                .longitude(LONGITUDE)
                .status(STATUS)
                .id(STOP_ID)
                .build();
    }

}
