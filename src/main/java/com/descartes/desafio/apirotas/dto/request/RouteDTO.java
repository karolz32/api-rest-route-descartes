package com.descartes.desafio.apirotas.dto.request;

import com.descartes.desafio.apirotas.enums.StatusRoute;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.Valid;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RouteDTO {

    private Long id;

    private String date;

    @Enumerated(EnumType.STRING)
    private StatusRoute status;

    @Valid
    private List<StopDTO> stops;
}
