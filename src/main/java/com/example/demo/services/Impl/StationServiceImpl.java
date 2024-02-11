package com.example.demo.services.Impl;

import com.example.demo.models.*;
import com.example.demo.models.types.Station;
import com.example.demo.models.types.Transport;
import com.example.demo.repo.AirportRepository;
import com.example.demo.repo.BusStationRepository;
import com.example.demo.repo.RailwayStationRepository;
import com.example.demo.services.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;

@Component
public class StationServiceImpl implements StationService {
    @Autowired
    private AirportRepository airportRepository;
    @Autowired
    private RailwayStationRepository railwayStationRepository;
    @Autowired
    private BusStationRepository busStationRepository;

    @Override
    public String getName(Long id, Station station) {
        return switch (station) {
            case AIRPORT -> airportRepository.findById(id).orElse(new Airport()).getName();
            case BUSSTATION -> busStationRepository.findById(id).orElse(new BusStation()).getName();
            case RAILWAYSTATION -> railwayStationRepository.findById(id).orElse(new RailwayStation()).getName();
        };
    }

    @Override
    public String getAddress(Long id, Station station) {
        return switch (station) {
            case AIRPORT -> airportRepository.findById(id).orElse(new Airport()).getAddress();
            case BUSSTATION -> busStationRepository.findById(id).orElse(new BusStation()).getAddress();
            case RAILWAYSTATION -> railwayStationRepository.findById(id).orElse(new RailwayStation()).getAddress();
        };
    }

    @Override
    public Pair<Long, Station> findStation(String name) {
        for (Airport airport: airportRepository.findAll()) {
            if (airport.getName().equals(name)) {
                return Pair.of(airport.getId(), Station.AIRPORT);
            }
        }
        for (BusStation busStation: busStationRepository.findAll()) {
            if (busStation.getName().equals(name)) {
                return Pair.of(busStation.getId(), Station.BUSSTATION);
            }
        }
        for (RailwayStation railwayStation: railwayStationRepository.findAll()) {
            if (railwayStation.getName().equals(name)) {
                return Pair.of(railwayStation.getId(), Station.RAILWAYSTATION);
            }
        }
        return null;
    }
}
