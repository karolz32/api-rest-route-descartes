package com.descartes.desafio.apirotas.dto.request;

import com.descartes.desafio.apirotas.entity.Route;
import com.descartes.desafio.apirotas.enums.StatusStops;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StopDTO {

    private Long id;

    @Size(min = 2, max = 100)
    private String description;

    @Size(min = 2, max = 100)
    private String address;

    @NotNull
    private double latitude;

    @NotNull
    private double longitude;

    @Enumerated(EnumType.STRING)
    private StatusStops status;

    @Valid
    private List<Route> routes;
}
