package com.descartes.desafio.apirotas.repository;

import com.descartes.desafio.apirotas.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepository extends JpaRepository<Route, Long> {
}
