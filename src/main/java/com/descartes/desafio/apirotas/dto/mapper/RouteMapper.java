package com.descartes.desafio.apirotas.dto.mapper;

import com.descartes.desafio.apirotas.dto.request.RouteDTO;
import com.descartes.desafio.apirotas.entity.Route;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RouteMapper {

    RouteMapper INSTANCE = Mappers.getMapper(RouteMapper.class);

    Route toModel(RouteDTO routeDTO);
    RouteDTO toDTO(Route route);

}
