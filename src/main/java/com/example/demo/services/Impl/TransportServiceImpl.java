package com.example.demo.services.Impl;

import com.example.demo.models.*;
import com.example.demo.models.types.Transport;
import com.example.demo.repo.AirplaneRepository;
import com.example.demo.repo.BusRepository;
import com.example.demo.repo.TrainRepository;
import com.example.demo.services.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;

@Component
public class TransportServiceImpl implements TransportService {
    @Autowired
    private AirplaneRepository airplaneRepository;
    @Autowired
    private TrainRepository trainRepository;
    @Autowired
    private BusRepository busRepository;

    @Override
    public String getName(Long id, Transport transport) {
        return switch (transport) {
            case AIRPLANE -> airplaneRepository.findById(id).orElse(new Airplane()).getName();
            case TRAIN -> trainRepository.findById(id).orElse(new Train()).getName();
            case BUS -> busRepository.findById(id).orElse(new Bus()).getName();
        };
    }

    @Override
    public String getCompanyInfo(Long id, Transport transport) {
        return switch (transport) {
            case AIRPLANE -> airplaneRepository.findById(id).orElse(new Airplane()).getCompany_info();
            case TRAIN -> trainRepository.findById(id).orElse(new Train()).getCompany_info();
            case BUS -> busRepository.findById(id).orElse(new Bus()).getCompany_info();
        };
    }

    @Override
    public Pair<Long, Transport> findTransport(String name) {
        for (Airplane airplane: airplaneRepository.findAll()) {
            if (airplane.getName().equals(name)) {
                return Pair.of(airplane.getId(), Transport.AIRPLANE);
            }
        }
        for (Train train: trainRepository.findAll()) {
            if (train.getName().equals(name)) {
                return Pair.of(train.getId(), Transport.TRAIN);
            }
        }
        for (Bus bus: busRepository.findAll()) {
            if (bus.getName().equals(name)) {
                return Pair.of(bus.getId(), Transport.BUS);
            }
        }
        return null;
    }
}
