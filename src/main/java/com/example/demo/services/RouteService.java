package com.example.demo.services;

import com.example.demo.controllers.dto.InfoRoute;
import com.example.demo.controllers.dto.MainInfoRoute;
import org.springframework.stereotype.Service;

@Service
public interface RouteService {

    Iterable<MainInfoRoute> getAllRoutes();

    InfoRoute getInfoRoute(long id);

    void addRoute(Long idCompany, String fromName, String toName, String transportName);

}
