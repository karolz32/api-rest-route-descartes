package com.descartes.desafio.apirotas.service;

import com.descartes.desafio.apirotas.dto.mapper.RouteMapper;
import com.descartes.desafio.apirotas.dto.request.RouteDTO;
import com.descartes.desafio.apirotas.dto.response.ResponseDTO;
import com.descartes.desafio.apirotas.entity.Route;
import com.descartes.desafio.apirotas.enums.StatusRoute;
import com.descartes.desafio.apirotas.exception.RouteNotFoundException;
import com.descartes.desafio.apirotas.repository.RouteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class RouteService {

    Logger logger = LoggerFactory.getLogger(RouteService.class);
    private RouteRepository routeRepository;

    private final RouteMapper routeMapper = RouteMapper.INSTANCE;


    @Autowired
    public RouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    public ResponseDTO postRoute(RouteDTO routeDTO) {
        logger.debug("Tentativa de salvar objeto DTO:");
        Route routeToSave = routeMapper.toModel(routeDTO);
        Route savedRoute = routeRepository.save(routeToSave);
        logger.debug("Objeto salvo: " + savedRoute);
        return createResponseDTO(savedRoute.getId(), "Rota criada no ID ");
    }

    public RouteDTO getRouteById(Long id) throws RouteNotFoundException{
        Route route = verifyIfExists(id);
        return routeMapper.toDTO(route);
    }

    public void delete(Long id) throws RouteNotFoundException {
        verifyIfExists(id);
        routeRepository.deleteById(id);
    }

    public ResponseDTO updateEntireRoute(Long id, RouteDTO routeDTO) throws RouteNotFoundException {
        verifyIfExists(id);
        Route toUpdateRoute = routeMapper.toModel(routeDTO);
        Route updatedRoute = routeRepository.save(toUpdateRoute);

        return createResponseDTO(updatedRoute.getId(), "Rota atualizada no ID ");
    }

    public ResponseDTO updateStatusById(Long id, StatusRoute statusRoute) throws RouteNotFoundException {
        Route route = verifyIfExists(id);
        route.setStatus(statusRoute);
        routeRepository.save(route);

        logger.info("O status da rota " + id + " mudou para " + statusRoute + " na data: " + LocalDate.now());
        return createResponseDTO(route.getId(), "Rota atualizada no ID ");

    }

    private Route verifyIfExists(Long id) throws RouteNotFoundException {
        return routeRepository.findById(id).orElseThrow(() -> new RouteNotFoundException(id));
    }

    private ResponseDTO createResponseDTO(Long id, String s) {
        return ResponseDTO.builder().message(s + id).build();
    }

}
