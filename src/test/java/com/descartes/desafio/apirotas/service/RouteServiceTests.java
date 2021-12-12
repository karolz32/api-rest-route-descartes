package com.descartes.desafio.apirotas.service;

import com.descartes.desafio.apirotas.dto.request.RouteDTO;
import com.descartes.desafio.apirotas.dto.response.ResponseDTO;
import com.descartes.desafio.apirotas.entity.Route;
import com.descartes.desafio.apirotas.enums.StatusRoute;
import com.descartes.desafio.apirotas.exception.RouteNotFoundException;
import com.descartes.desafio.apirotas.repository.RouteRepository;
import com.descartes.desafio.apirotas.utils.RouteUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RouteServiceTests {

    @Mock
    private RouteRepository routeRepository;

    @InjectMocks
    private RouteService routeService;

    @Test
    void testRouteDTOandEntityReturnMessage() {
        RouteDTO testRouteDTO = RouteUtils.createFakeRouteDTO();
        Route expectedRoute = RouteUtils.createFakeRoute();

        when(routeRepository.save(any(Route.class))).thenReturn(expectedRoute);

        ResponseDTO expectedMessage = ResponseDTO.builder().message("Rota criada no ID " + expectedRoute.getId()).build();
        ResponseDTO message = routeService.postRoute(testRouteDTO);

        Assertions.assertEquals(expectedMessage, message);
    }

    @Test
    void shouldThrowsAnExceptionIfRouteIsNotFound(){
        RouteNotFoundException erro = Assertions.assertThrows(RouteNotFoundException.class, () -> {
            routeService.getRouteById(null);
        });
        Assertions.assertEquals(erro.getMessage(), "Rota não encontrada no ID");
    }

    @Test
    void testGetRouteById() throws RouteNotFoundException {

        Long id = 1L;
        Optional<Route> expectedRoute = Optional.of(RouteUtils.createFakeRoute());
        when(routeRepository.findById(ArgumentMatchers.eq(id))).thenReturn(expectedRoute);

        routeService.getRouteById(id);
        Mockito.verify(routeRepository, Mockito.times(1)).findById(id);

    }

    @Test
    void testDeletebyId() throws RouteNotFoundException {

        Long id = 1L;
        Optional<Route> expectedRoute = Optional.of(RouteUtils.createFakeRoute());
        when(routeRepository.findById(ArgumentMatchers.eq(id))).thenReturn(expectedRoute);
        doNothing().when(routeRepository).deleteById(id);
        routeService.delete(id);

        Mockito.verify(routeRepository, Mockito.times(1)).deleteById(id);


    }

    @Test
    void testUpdatebyId() throws RouteNotFoundException {

        Long id = 1L;
        RouteDTO testRouteDTO = RouteUtils.createFakeRouteDTO();
        Route expectedRoute = RouteUtils.createFakeRoute();

        when(routeRepository.save(any(Route.class))).thenReturn(expectedRoute);
        when(routeRepository.findById(id)).thenReturn(Optional.ofNullable(expectedRoute));

        ResponseDTO expectedMessage = ResponseDTO.builder().message("Rota atualizada no ID " + expectedRoute.getId()).build();
        ResponseDTO message = routeService.updateEntireRoute(id, testRouteDTO);

        Assertions.assertEquals(expectedMessage, message);

    }

    @Test
    void testUpdateStatusbyId() throws RouteNotFoundException{
        Long id = 1L;
        RouteDTO testRouteDTO = RouteUtils.createFakeRouteDTO();
        Route expectedRoute = RouteUtils.createFakeRoute();
        StatusRoute statusRoute = testRouteDTO.getStatus();

        when(routeRepository.save(any(Route.class))).thenReturn(expectedRoute);
        when(routeRepository.findById(id)).thenReturn(Optional.ofNullable(expectedRoute));

        ResponseDTO expectedMessage = ResponseDTO.builder().message("Rota atualizada no ID " + expectedRoute.getId()).build();
        ResponseDTO message = routeService.updateStatusById(id, statusRoute);

        Assertions.assertEquals(expectedMessage, message);
    }


}
