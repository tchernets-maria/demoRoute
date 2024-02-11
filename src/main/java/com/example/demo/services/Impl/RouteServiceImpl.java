package com.example.demo.services.Impl;

import com.example.demo.controllers.dto.InfoRoute;
import com.example.demo.controllers.dto.MainInfoRoute;
import com.example.demo.models.Route;
import com.example.demo.models.types.Station;
import com.example.demo.models.types.Transport;
import com.example.demo.repo.RouteRepository;
import com.example.demo.services.CompanyService;
import com.example.demo.services.RouteService;
import com.example.demo.services.StationService;
import com.example.demo.services.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class RouteServiceImpl implements RouteService {
    @Autowired
    private RouteRepository routeRepository;
    @Autowired
    private StationService stationService;
    @Autowired
    private TransportService transportService;
    @Autowired
    private CompanyService companyService;

    @Override
    public Iterable<MainInfoRoute> getAllRoutes() {
        Iterable<Route> routes = routeRepository.findAll();
        List<MainInfoRoute> mainInfoRoutes = new ArrayList<>();
        routes.forEach(route ->
            mainInfoRoutes.add(new MainInfoRoute(route.getId(),
                    stationService.getName(route.getIdStationFrom(), route.getStationFrom()),
                    stationService.getName(route.getIdStationTo(), route.getStationTo()),
                    route.getTransport())));
        return mainInfoRoutes;
    }

    @Override
    public InfoRoute getInfoRoute(long id) {
        Optional<Route> optionalRoute = routeRepository.findById(id);
        if (optionalRoute.isPresent()) {
            Route route = optionalRoute.get();
            return new InfoRoute(route.getTransport(),
                    transportService.getName(route.getIdTransport(), route.getTransport()),
                    transportService.getCompanyInfo(route.getIdTransport(), route.getTransport()),
                    route.getStationFrom(),
                    stationService.getName(route.getIdStationFrom(), route.getStationFrom()),
                    stationService.getAddress(route.getIdStationFrom(), route.getStationFrom()),
                    stationService.getName(route.getIdStationTo(), route.getStationTo()),
                    stationService.getAddress(route.getIdStationTo(), route.getStationTo()),
                    companyService.getName(route.getIdCompany()),
                    companyService.getEmail(route.getIdCompany()),
                    companyService.getPhone(route.getIdCompany()));
        }
        return new InfoRoute();
    }

    @Override
    public void addRoute(Long idCompany, String fromName, String toName, String transportName) {
        Pair<Long, Transport> transport = transportService.findTransport(transportName);
        if (transport == null) {
            return;
        }
        Pair<Long, Station> stationFrom = stationService.findStation(fromName);
        if (stationFrom == null) {
            return;
        }
        Pair<Long, Station> stationTo = stationService.findStation(toName);
        if (stationTo == null) {
            return;
        }
        routeRepository.save(new Route(transport.getFirst(), stationFrom.getFirst(), stationTo.getFirst(), idCompany,
                transport.getSecond(), stationFrom.getSecond(), stationTo.getSecond()));
    }
}
