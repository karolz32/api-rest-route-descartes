package com.descartes.desafio.apirotas.controller;

import com.descartes.desafio.apirotas.dto.request.RouteDTO;
import com.descartes.desafio.apirotas.dto.response.ResponseDTO;
import com.descartes.desafio.apirotas.enums.StatusRoute;
import com.descartes.desafio.apirotas.exception.RouteNotFoundException;
import com.descartes.desafio.apirotas.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/")
public class RouteController {

    private final RouteService routeService;

    @Autowired
    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @PostMapping("/Route")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseDTO postRoute(@RequestBody @Valid RouteDTO routeDTO){
        return routeService.postRoute(routeDTO);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public RouteDTO getRouteById(@PathVariable Long id) throws RouteNotFoundException {
        return routeService.getRouteById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRouteById(@PathVariable Long id) throws RouteNotFoundException {
        routeService.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseDTO updateEntireRoute(@PathVariable Long id, @RequestBody @Valid RouteDTO routeDTO) throws RouteNotFoundException {
        return routeService.updateEntireRoute(id, routeDTO);
    }

    @PatchMapping("/{id}/{statusRoute}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseDTO updateStatus(@PathVariable Long id, @PathVariable StatusRoute statusRoute) throws RouteNotFoundException{
        return routeService.updateStatusById(id, statusRoute);
    }


}
